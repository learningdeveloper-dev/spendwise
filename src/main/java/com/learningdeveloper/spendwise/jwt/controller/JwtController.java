package com.learningdeveloper.spendwise.jwt.controller;

import com.learningdeveloper.spendwise.jwt.services.JWTServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    JWTServices jwtServices;

    public JwtController(JWTServices jwtServices) {
        this.jwtServices = jwtServices;
    }

    @PostMapping("/refresh-token")
    public Map<String, String> refreshToken(@RequestBody Map<String, String> payload) {
        return jwtServices.refreshToken(payload);
    }

}
