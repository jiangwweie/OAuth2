package com.jiangwei.authserver.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RolePermission {
    private Long id;

    private String roleId;

    private String permissionId;
}