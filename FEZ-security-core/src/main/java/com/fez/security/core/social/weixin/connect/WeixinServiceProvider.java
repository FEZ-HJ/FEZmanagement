package com.fez.security.core.social.weixin.connect;

import com.fez.security.core.social.weixin.api.Weixin;
import com.fez.security.core.social.weixin.api.WeixinImpl;
import com.fez.security.core.social.weixin.api.WeixinUserInfo;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Created by H.J
 * 2018/10/16
 */
public class WeixinServiceProvider extends AbstractOAuth2ServiceProvider<Weixin> {

    /**
     * 微信获取授权码的url
     */
    private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
    /**
     * 微信获取accessToken的url
     */
    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * @param appId
     * @param appSecret
     */
    public WeixinServiceProvider(String appId, String appSecret) {
        super(new WeixinOAuth2Template(appId, appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
    }


    /* (non-Javadoc)
     * @see org.springframework.social.oauth2.AbstractOAuth2ServiceProvider#getApi(java.lang.String)
     */
    @Override
    public Weixin getApi(String accessToken) {
        return new WeixinImpl(accessToken);
    }
}
