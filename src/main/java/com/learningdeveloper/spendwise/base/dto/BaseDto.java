package com.learningdeveloper.spendwise.base.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class BaseDto {
    private String createdBy;
    private String modifiedBy;
    private Instant createdOn;
    private Instant modifiedOn;
}
