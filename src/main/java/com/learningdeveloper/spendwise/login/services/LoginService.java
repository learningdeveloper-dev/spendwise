package com.learningdeveloper.spendwise.login.services;

import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;

public interface LoginService {
    User login(SignupDTO signupDTO) throws Exception;

    User signUp(SignupDTO signupDTO) throws Exception;
}
