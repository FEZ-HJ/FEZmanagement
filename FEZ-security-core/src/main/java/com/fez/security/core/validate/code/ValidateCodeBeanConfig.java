package com.fez.security.core.validate.code;

import com.fez.security.core.properties.SecurityProperties;
import com.fez.security.core.validate.code.image.ImageCodeGenerator;
import com.fez.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.fez.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by H.J
 * 2018/10/7
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")//是否已经有imageCodeGenerator这个bean，如果有，下面的bean不加载
    public ValidateCodeGenerator imageValidateCodeGenerator(){
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)//是否有SmsCodeSender接口的实现，如果有，下面的bean不加载
    public SmsCodeSender smsCodeGenerator(){
        return new DefaultSmsCodeSender();
    }
}
