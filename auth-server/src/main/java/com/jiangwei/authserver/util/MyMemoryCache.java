package com.jiangwei.authserver.util;


import com.jiangwei.authserver.entity.ResultDto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: jiangwei
 * @Date: 2020-12-04
 * @Version: 1.0
 * @Description:
 */
public class MyMemoryCache {

    private static final ConcurrentHashMap<String, Long> tokens = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, String> ids = new ConcurrentHashMap<>();

    public static void setToken(String token,String userId) {
        tokens.put(token, 7200l);
        ids.put(token,userId);
    }

    public static Long getTokenExpiresIn(String token) {
        return tokens.getOrDefault(token, 0L);
    }

    public static void refeshToken(String token) {
        tokens.put(token, 7200l);
    }

    public static ResultDto validToken(String access_token) {
        Long tokenExpiresIn = getTokenExpiresIn(access_token);
        Map map = new HashMap<>();
        map.put("expires_in", tokenExpiresIn);
        map.put("status", tokenExpiresIn > 0 ? 1 : 0);
        map.put("message", tokenExpiresIn > 0 ? "令牌有效" : "令牌无效");
       return ResultDto.builder().code(0).success(true).msg("成功").data(map).build();
    }


}
