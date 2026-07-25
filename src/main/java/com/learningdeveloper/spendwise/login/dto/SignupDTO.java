package com.learningdeveloper.spendwise.login.dto;

import com.learningdeveloper.spendwise.users.dto.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SignupDTO extends User {
    private String password;
}
