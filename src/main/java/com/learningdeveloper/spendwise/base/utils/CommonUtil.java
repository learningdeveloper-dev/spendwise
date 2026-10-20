package com.learningdeveloper.spendwise.base.utils;

import com.learningdeveloper.spendwise.base.dto.BaseDto;

import java.time.Instant;

public class CommonUtil {

    public static void setCreationAudit(BaseDto baseDto, String createdBy) {
        baseDto.setCreatedBy(createdBy);
        baseDto.setCreatedOn(Instant.now());
        baseDto.setModifiedBy(createdBy);
        baseDto.setModifiedOn(Instant.now());
    }

    public static void setModifiedAudit(BaseDto baseDto, String modifiedBy) {
        baseDto.setModifiedBy(modifiedBy);
        baseDto.setModifiedOn(Instant.now());
    }
}
