package com.fez.security.core.social.weixin.api;

/**
 * Created by H.J
 * 2018/10/16
 */
public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);
}
