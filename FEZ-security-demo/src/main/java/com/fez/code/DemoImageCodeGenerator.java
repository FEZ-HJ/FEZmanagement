package com.fez.code;

import com.fez.security.core.validate.code.ImageCode;
import com.fez.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by H.J
 * 2018/10/7
 */
//以下注解会覆盖ImageCodeGenerator该类
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图像验证码");
        return null;
    }
}
