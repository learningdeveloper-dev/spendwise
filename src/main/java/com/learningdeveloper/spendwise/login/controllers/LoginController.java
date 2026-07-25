package com.learningdeveloper.spendwise.login.controllers;

import com.learningdeveloper.spendwise.login.dto.SignupDTO;
import com.learningdeveloper.spendwise.login.services.LoginService;
import com.learningdeveloper.spendwise.users.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/v1/login")
    public User login(@RequestBody SignupDTO signupDTO) throws Exception {
        return loginService.login(signupDTO);
    }

    @PostMapping("/v1/signUp")
    public User signup(@RequestBody SignupDTO signupDTO) throws Exception {
        return loginService.signUp(signupDTO);
    }
}
