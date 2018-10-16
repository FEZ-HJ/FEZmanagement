package com.fez.security.core.properties;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class BrowserProperties {

    private String signUpUrl = "/fez-signUp.html";

    private String loginPage = "/fez-signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;
}
