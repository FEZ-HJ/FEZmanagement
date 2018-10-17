package com.fez.security.core.properties;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class BrowserProperties {

    private String signUpUrl = "/fez-signUp.html";

    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;

    private SessionProperties session = new SessionProperties();
}
