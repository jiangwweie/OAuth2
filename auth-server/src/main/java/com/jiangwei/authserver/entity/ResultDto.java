package com.jiangwei.authserver.entity;

import lombok.*;

/**
 * @Author: com.jiangwei
 * @Date: 2020-12-02
 * @Version: 1.0
 * @Description:
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto<T> {
    private String msg;
    private boolean success;
    private T data;
    private int code;
}
