package com.fez.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by H.J
 * 2018/10/7
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request);
}
