package com.fez.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by H.J
 * 2018/10/7
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String detail) {
        super(detail);
    }
}
