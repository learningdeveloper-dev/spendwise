package com.learningdeveloper.spendwise.users.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private Long userId;
    private String displayName;
    private String emailId;
    private String mobileNumber;
}
