package com.learningdeveloper.spendwise.login.services;

import com.learningdeveloper.spendwise.login.dao.LoginDao;
import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public User login(SignupDTO signupDTO) throws Exception {
        return loginDao.login(signupDTO);
    }

    @Override
    public User signUp(SignupDTO signupDTO) throws Exception {
        return loginDao.signUp(signupDTO);
    }
}
