package com.fez.security.core.validate.code.sms;

/**
 * Created by H.J
 * 2018/10/7
 */
public class DefaultSmsCodeSender implements SmsCodeSender{

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机发送短信验证码" + mobile + ":" + code);
    }
}
