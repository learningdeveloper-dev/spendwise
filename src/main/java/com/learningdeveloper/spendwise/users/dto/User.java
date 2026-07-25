package com.learningdeveloper.spendwise.users.dto;

import com.learningdeveloper.spendwise.base.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.authentication.jaas.JaasGrantedAuthority;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseDto {
    private Long userId;
    private String displayName;
    private String emailId;
    private String mobileNumber;
    private List<JaasGrantedAuthority> roles;
}
