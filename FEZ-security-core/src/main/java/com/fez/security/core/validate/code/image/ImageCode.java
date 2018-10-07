package com.fez.security.core.validate.code.image;

import com.fez.security.core.validate.code.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        super(code,expireTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image,String code,int expireIn){
        super(code,expireIn);
        this.image = image;
    }
}
