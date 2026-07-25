package com.learningdeveloper.spendwise.base.auth;

import com.learningdeveloper.spendwise.users.dto.User;
import com.learningdeveloper.spendwise.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String emailId = authentication.getName();
        String password = Optional.ofNullable(authentication.getCredentials()).orElse("").toString();

        User appUser = userService.selectUserByEmailIdAndPassword(emailId, password);
        if (appUser == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        List<GrantedAuthority> authorities = appUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        // Principal is now YOUR AppUser object, not a UserDetails wrapper
        return new UsernamePasswordAuthToken(appUser, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthToken.class.isAssignableFrom(authentication);
    }
}