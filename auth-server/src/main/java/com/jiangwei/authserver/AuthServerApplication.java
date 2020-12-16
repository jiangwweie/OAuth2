package com.jiangwei.authserver;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//资源服务器注解
@RestController
@Slf4j
@MapperScan("com.jiangwei.authserver.dao")
@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }


    @GetMapping("user/info")
    public Principal getCurrentUser(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("用户信息:{}",authentication);
        return principal;
    }

    @GetMapping("admin/info")
    public Principal getCurrentUserAdmin(Principal principal) {
        return principal;
    }

}
