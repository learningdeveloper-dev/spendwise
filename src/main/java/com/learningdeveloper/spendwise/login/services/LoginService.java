package com.learningdeveloper.spendwise.login.services;

import com.learningdeveloper.spendwise.login.dto.SignupDTO;

import java.util.Map;

public interface LoginService {
    Map<String, String> login(SignupDTO signupDTO) throws Exception;

    Integer signUp(SignupDTO signupDTO) throws Exception;
}
