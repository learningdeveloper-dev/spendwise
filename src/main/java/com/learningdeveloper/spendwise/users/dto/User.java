package com.learningdeveloper.spendwise.users.dto;

import com.learningdeveloper.spendwise.base.dto.BaseDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User extends BaseDto {
    private Long userId;
    private String displayName;
    private String emailId;
    private String mobileNumber;
}
