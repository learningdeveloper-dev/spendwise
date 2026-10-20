package com.learningdeveloper.spendwise.users.dto;

import com.learningdeveloper.spendwise.base.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseDto {
    private String userId;
    private String displayName;
    private String emailId;
    private String mobileNumber;
    private List<String> roles;
}
