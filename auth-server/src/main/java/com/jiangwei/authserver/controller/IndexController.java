//package com.jiangwei.authserver.controller;
//
//
//import com.jiangwei.authserver.domain.SysUser;
//import com.jiangwei.authserver.entity.ResultDto;
//import com.jiangwei.authserver.service.UserEntityService;
//import com.jiangwei.authserver.util.Constans;
//import com.jiangwei.authserver.util.MyMemoryCache;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//
///**
// * @Author: com.jiangwei
// * @Date: 2020-12-02
// * @Version: 1.0
// * @Description:
// */
//@RestController
//@RequestMapping("oauth")
//@Slf4j
//public class IndexController {
//
//    @Autowired
//    private UserEntityService userEntityService;
//
//
//    @PostMapping("token")
//    public ResultDto token(@RequestBody String sign) {
//        log.debug("sign: {}", sign);
//        UUID uuid = UUID.randomUUID();
//        Map map = new HashMap();
//        map.put("access_token", uuid.toString());
//        map.put("token_type", "bearer");
//        map.put("expires_in", 7200);
//        map.put("scope", "select");
//        return ResultDto.builder().code(0).success(true).msg("成功").data(map).build();
//    }
//
//    @GetMapping("user/validToken")
//    public ResultDto valid(@RequestParam String access_token) {
//        return MyMemoryCache.validToken(access_token);
//    }
//
//    @GetMapping("me/logout")
//    public ResultDto logout(@RequestParam String access_token) {
//        return userEntityService.logout(access_token);
//    }
//
//    @GetMapping("/me/user")
//    public ResultDto info(@RequestParam String access_token) {
//        log.debug("access_token : {}", access_token);
//        SysUser userEntity = userEntityService.selectByName(access_token);
//        if (userEntity != null) {
//            return ResultDto.builder().code(0).success(true).msg("成功").data(userEntity).build();
//        }
//        return ResultDto.builder().code(1).success(false).msg("失败").build();
//    }
//
//    @GetMapping("syncInnerUsers")
//    public ResultDto innerUsers(@RequestParam String access_token, String startTime, String endTime) {
//        log.debug(" access_token : {} , startTime : {} , endTime: {}  ", access_token, startTime, endTime);
//        List<SysUser> users = userEntityService.selectAll(Constans.INNER_USER_TYPE);
//        Map map = new HashMap<>();
//        map.put("added", users);
//        return ResultDto.builder().code(0).success(true).msg("成功").data(map).build();
//    }
//
//    @GetMapping("syncPublicUsers")
//    public ResultDto publishUsers(@RequestParam String access_token, String startTime, String endTime) {
//        log.debug(" access_token : {} , startTime : {} , endTime: {}  ", access_token, startTime, endTime);
//        List<SysUser> users = userEntityService.selectAll(Constans.PUBLIC_USER_TYPE);
//        Map map = new HashMap<>();
//        map.put("added", users);
//        return ResultDto.builder().code(0).success(true).msg("成功").data(map).build();
//    }
//}
