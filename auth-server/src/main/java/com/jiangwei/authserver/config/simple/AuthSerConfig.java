//package com.jiangwei.authserver.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//
///**
// * @Author: jiangwei
// * @Date: 2020-12-07
// * @Version: 1.0
// * @Description:
// */
////授权服务器注解
//@EnableAuthorizationServer
//@Configuration
//public class AuthSerConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//        configurer.inMemory()
//                .withClient("loop")
//                .secret(passwordEncoder.encode("691216"))
//                .autoApprove(true)
//                .redirectUris("http://localhost:7081/login")
//                .scopes("user")
//                .accessTokenValiditySeconds(7200)
//                .authorizedGrantTypes("authorization_code");
//    }
//
//}
