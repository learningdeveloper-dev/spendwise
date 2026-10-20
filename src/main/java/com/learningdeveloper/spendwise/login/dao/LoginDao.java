package com.learningdeveloper.spendwise.login.dao;

import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.users.dto.User;

public interface LoginDao {
    User login(SignupDTO signupDTO) throws Exception;

    Integer signUp(SignupDTO signupDTO) throws Exception;
}
