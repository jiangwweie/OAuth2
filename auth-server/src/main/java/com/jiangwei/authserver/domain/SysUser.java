package com.jiangwei.authserver.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
    * user
    */
@Getter
@Setter
@ToString
@Data
public class SysUser {
    /**
    * id
    */
    private Integer id;

    /**
    * username
    */
    private String username;

    /**
    * sex
    */
    private String sex;

    /**
    * birthday
    */
    private Date birthday;

    /**
    * address
    */
    private String address;

    /**
    * password
    */
    private String password;

    private String userType;

    private String createTime;

    private List<Role> roleList;
}