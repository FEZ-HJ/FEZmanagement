package com.fez.security.browser.support;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/16
 */
@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;
}
