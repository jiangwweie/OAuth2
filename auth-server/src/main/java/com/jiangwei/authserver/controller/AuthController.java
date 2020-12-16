package com.jiangwei.authserver.controller;

import com.jiangwei.authserver.domain.SysUser;
import com.jiangwei.authserver.entity.ResultDto;
import com.jiangwei.authserver.entity.UserDto;
import com.jiangwei.authserver.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @Author: jiangwei
 * @Date: 2020-12-10
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("oauth")
@Slf4j
public class AuthController {

    @Autowired
    UserEntityService userEntityService;

    @GetMapping("/me/user")
    public ResultDto me(Principal principal) {
        String userName = principal.getName();
        SysUser sysUser = userEntityService.selectByName(userName);
        if (sysUser != null) {
            UserDto userDto = new UserDto(sysUser);
            return ResultDto.builder().code(0).success(true).msg("成功").data(userDto).build();
        }
        return ResultDto.builder().code(1).success(false).msg("失败").build();
    }
    @Resource
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/me/logout")
    public ResultDto wuJinLogout(@RequestParam("access_token")String accessToken){
        if (consumerTokenServices.revokeToken(accessToken)) {
            return ResultDto.builder().success(true).msg("退出成功").build();
        }
        return ResultDto.builder().success(false).msg("退出失败").build();
    }

}
