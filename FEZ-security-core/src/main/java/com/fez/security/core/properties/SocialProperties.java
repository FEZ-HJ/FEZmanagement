package com.fez.security.core.properties;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/8
 */
@Data
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

//    private WeixinProperties weixin = new WeixinProperties();


}
