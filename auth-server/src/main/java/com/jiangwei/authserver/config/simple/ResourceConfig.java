//package com.jiangwei.authserver.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
///**
// * @Author: jiangwei
// * @Date: 2020-12-08
// * @Version: 1.0
// * @Description:
// */
//@Configuration
//public class ResourceConfig extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(ResourceServerSecurityConfigurer configurer) {
//        configurer.resourceId("rs1").stateless(true);
//    }
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers("/admin/*").hasRole("admin")
//                .antMatchers("/user/*").hasRole("user")
//                .anyRequest().authenticated();
//    }
//}
