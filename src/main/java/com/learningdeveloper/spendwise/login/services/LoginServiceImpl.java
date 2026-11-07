package com.learningdeveloper.spendwise.login.services;

import com.learningdeveloper.spendwise.base.constants.SignUpConstants;
import com.learningdeveloper.spendwise.jwt.dao.JwtDao;
import com.learningdeveloper.spendwise.jwt.services.JWTServices;
import com.learningdeveloper.spendwise.login.dao.LoginDao;
import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;
    private final JwtDao jwtDao;
    private final JWTServices jwtServices;

    public LoginServiceImpl(LoginDao loginDao, JWTServices jwtServices, JwtDao jwtDao) {
        this.loginDao = loginDao;
        this.jwtServices = jwtServices;
        this.jwtDao = jwtDao;
    }

    @Override
    public Map<String, String> login(SignupDTO signupDTO) throws Exception {
        User user = loginDao.login(signupDTO);
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", jwtServices.generateToken(user));
        tokens.put("refreshToken", jwtServices.generateToken(user));
        jwtDao.insertRefreshToken(user.getUserId(), tokens.get("refreshToken"));
        return tokens;
    }

    @Override
    public Integer signUp(SignupDTO signupDTO) throws Exception {
        signupDTO.setRoles(Collections.singletonList(SignUpConstants.USER));
        return loginDao.signUp(signupDTO);
    }
}
