package com.fez.security.core.validate.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
}
