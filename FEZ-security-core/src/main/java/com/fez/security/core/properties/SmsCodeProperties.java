package com.fez.security.core.properties;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class SmsCodeProperties {

    private int length = 4;
    private int expireIn = 60;
    private String url;
}
