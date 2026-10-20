package com.learningdeveloper.spendwise.login.services;

import com.learningdeveloper.spendwise.login.dto.SignupDTO;

public interface LoginService {
    String login(SignupDTO signupDTO) throws Exception;

    Integer signUp(SignupDTO signupDTO) throws Exception;
}
