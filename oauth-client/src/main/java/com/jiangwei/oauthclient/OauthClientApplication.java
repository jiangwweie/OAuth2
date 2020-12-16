package com.jiangwei.oauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class OauthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthClientApplication.class, args);
    }


    @GetMapping("hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();

        String loginUrl = "<a href=\"http://192.168.86.21:6160/portal?access_token=" + token + " \" target=\"_blank\"  >点击登录门户</a>";
        String loginUrlMg = "<a href=\"http://192.168.86.21:6160/manager?access_token=" + token + " \" target=\"_blank\"  >点击登录云管</a>";
        String logoutUrl = "<a href=\"http://192.168.86.23:7080/oauth/me/logout?access_token=" + token + " \"  target=\"_blank\"   >点击退出德清CIM</a>";
        return "姓名 :" + authentication.getName() + "\n\r "
                + "             权限 : "
                + Arrays.toString(authentication.getAuthorities().toArray()) + "\n\r "
                + "token:                " + token
                + "             门户：" + loginUrl
                + "             云管：" + loginUrlMg
                + "              点击退出： " + logoutUrl;

    }


}
