package com.jiangwei.authserver.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Role {
    private Integer id;

    private String tenantId;

    private String name;

    private Date updateTime;

    private String description;

    private List<Permission> permissionList;
}