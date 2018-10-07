package com.fez.security.core.validate.code.sms;

/**
 * Created by H.J
 * 2018/10/7
 */
public interface SmsCodeSender {

    void send(String mobile,String code);
}
