package com.fez.security.core.validate.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public ImageCode(BufferedImage image,String code,int expireIn){
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
}
