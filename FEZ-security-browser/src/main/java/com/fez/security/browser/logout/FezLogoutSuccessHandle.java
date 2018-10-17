package com.fez.security.browser.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fez.security.browser.support.SimpleResponse;
import com.fez.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by H.J
 * 2018/10/17
 */
public class FezLogoutSuccessHandle implements LogoutSuccessHandler {
    Logger logger = LoggerFactory.getLogger(getClass());

    public FezLogoutSuccessHandle(SecurityProperties securityProperties){
        this.securityProperties = securityProperties;
    }

    private SecurityProperties securityProperties;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        logger.info("退出成功");

        String signOutUrl = securityProperties.getBrowser().getSignOutUrl();

        if (StringUtils.isBlank(signOutUrl)) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        }else{
            httpServletResponse.sendRedirect(signOutUrl);
        }
    }
}
