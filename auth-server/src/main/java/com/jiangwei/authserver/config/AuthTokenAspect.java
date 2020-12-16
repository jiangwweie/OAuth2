package com.jiangwei.authserver.config;

import com.jiangwei.authserver.entity.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jiangwei
 * @Date: 2020-12-10
 * @Version: 1.0
 * @Description:
 */
@Component
@Aspect
@Slf4j
public class AuthTokenAspect {

    /// @Around是可以改变controller返回值的
    @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String remoteHost = request.getRemoteHost();
        log.info("remoteHost ： " + remoteHost);
        // 放行
        ResultDto response = new ResultDto();
        Object proceed = pjp.proceed();
        if (proceed != null) {
            ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>) proceed;
            if (remoteHost.equals("127.0.0.1")|remoteHost.equals("localhost")||remoteHost.equals("192.168.86.23")){
                return responseEntity ;
            }
            OAuth2AccessToken body = responseEntity.getBody();
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                response.setCode(1);
                response.setMsg("成功");
                response.setSuccess(true);
                response.setData(body);
            } else {
                log.error("error:{}", responseEntity.getStatusCode().toString());
                response.setCode(0);
                response.setMsg("失败");
                response.setSuccess(false);
            }
        }
        return ResponseEntity
                .status(200)
                .body(response);
    }
}
