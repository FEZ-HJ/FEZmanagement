package com.fez.security.core.properties;


import lombok.Data;

/**
 * Created by H.J
 * 2018/10/8
 */
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    private String appId ="";

    private String appSecret="";

}
