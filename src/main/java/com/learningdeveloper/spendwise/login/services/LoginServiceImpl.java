package com.learningdeveloper.spendwise.login.services;

import com.learningdeveloper.spendwise.jwt.services.JWTServices;
import com.learningdeveloper.spendwise.login.dao.LoginDao;
import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;
    private final JWTServices jwtServices;

    public LoginServiceImpl(LoginDao loginDao, JWTServices jwtServices) {
        this.loginDao = loginDao;
        this.jwtServices = jwtServices;
    }

    @Override
    public String login(SignupDTO signupDTO) throws Exception {
        if (loginDao.login(signupDTO) != null) {
            return jwtServices.generateToken(signupDTO);
        } else {
            return null;
        }
    }

    @Override
    public User signUp(SignupDTO signupDTO) throws Exception {
        // TODO: Add a default role to the user
        return loginDao.signUp(signupDTO);
    }
}
