package com.jiangwei.authserver.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Permission {
    private String id;

    private String permission;

    private String description;

}