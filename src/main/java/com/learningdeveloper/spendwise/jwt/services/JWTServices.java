package com.learningdeveloper.spendwise.jwt.services;

import com.learningdeveloper.spendwise.base.exceptions.InvalidToken;
import com.learningdeveloper.spendwise.jwt.dao.JwtDao;
import com.learningdeveloper.spendwise.users.dto.User;
import com.learningdeveloper.spendwise.users.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServices {

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    @Value("${security.jwt.secret}")
    private String secret;

    private UserService userService;
    private JwtDao jwtDao;

    public JWTServices(UserService userService, JwtDao jwtDao) {
        this.userService = userService;
        this.jwtDao = jwtDao;
    }

    public String extractUserId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(User user) {
        return generateToken(new HashMap<>(), user);
    }

    public String generateToken(Map<String, Object> extraClaims, User user) {
        return buildToken(extraClaims, user, getExpirationTime());
    }

    public long getExpirationTime() {
        return jwtExpiration;
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            User user,
            long expiration
    ) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(user.getUserId())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String token, String userId) {
        return isTokenWithOwner(token, userId) && !isTokenExpired(token);
    }

    private boolean isTokenWithOwner(String token, String userId) {
        final String extractUserId = extractUserId(token);
        return (userId.equals(extractUserId));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return (Claims) Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parse(token)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        if (secret == null) {
            throw new IllegalStateException("JWT_SECRET environment variable is not set");
        }
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public Map<String, String> refreshToken(Map<String, String> payload) {
        String userId = payload.get("userId");
        String refreshToken = payload.get("refreshToken");

        if (!isTokenWithOwner(refreshToken, userId)) {
            throw new InvalidToken("Refresh token is not with the correct owner.");
        }

        String accessToken = generateToken(userService.selectUserById(userId));
        String newRefreshToken = generateToken(userService.selectUserById(userId));
        jwtDao.updateRefreshToken(userId, newRefreshToken);

        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("refreshToken", newRefreshToken);
        parameterMap.put("accessToken", accessToken);

        return parameterMap;
    }
}