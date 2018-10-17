package com.fez.security.browser;

import com.fez.security.browser.session.FezExpiredSessionStrategy;
import com.fez.security.core.authentication.AbstractChannelSecurityConfig;
import com.fez.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.fez.security.core.properties.SecurityConstants;
import com.fez.security.core.properties.SecurityProperties;
import com.fez.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * Created by H.J
 * 2018/10/7
 */
@Configuration
public class BrowserSecurityConfig  extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer springSocialConfigurer;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        applyPasswordAuthenticationConfig(http);

        http
            .apply(validateCodeSecurityConfig)
                .and()
            .apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .apply(springSocialConfigurer)
                .and()
            .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
            .sessionManagement()
                .invalidSessionUrl(SecurityConstants.DEFAULT_SESSION_INVALID_URL)
                .maximumSessions(10)
//                .maxSessionsPreventsLogin(true)
                .expiredSessionStrategy(new FezExpiredSessionStrategy("/index.html"))
                .and()
                .and()
            .logout()
                .logoutUrl("/logout")
//                .logoutSuccessUrl("/fez-logout.html")
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies()
                .and()
            .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        securityProperties.getBrowser().getSignOutUrl(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        "/user/register",
                        "/session/invalid")
                    .permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .csrf().disable();
    }
}
