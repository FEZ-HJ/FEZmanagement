package com.fez.security.core.properties;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties{

    public ImageCodeProperties(){
        setLength(4);
    }

    private int width = 67;
    private int height = 23;
}
