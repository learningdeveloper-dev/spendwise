package com.learningdeveloper.spendwise.login.dao;

import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;

public interface LoginDao {
    User login(SignupDTO signupDTO) throws Exception;

    User signUp(SignupDTO signupDTO) throws Exception;
}
