//package com.jiangwei.authserver.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @Author: jiangwei
// * @Date: 2020-12-07
// * @Version: 1.0
// * @Description:
// */
//
////因为资源服务器和授权服务器在一起
////所以我们需要一个 @Order 注解来提升 Spring Security 配置的优先级。
//@Configuration
//@Order(1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * 加密方式
//     *
//     * @return
//     */
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity webSecurity) {
//        webSecurity.ignoring()
//                .antMatchers("/login.html", "css/**", "/js/**", "/images/**");
//    }
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.requestMatchers()
//                .antMatchers("/login")
//                .antMatchers("/oauth/authorize")
//                .and()
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login")
//                .permitAll()
//                .and()
//                .csrf().disable();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.inMemoryAuthentication()
//                .withUser("jiangwei")
//                .password(passwordEncoder().encode("691216"))
//                .roles("admin");
//    }
//
//}
