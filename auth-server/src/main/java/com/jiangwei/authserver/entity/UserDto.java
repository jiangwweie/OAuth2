package com.jiangwei.authserver.entity;

import com.jiangwei.authserver.domain.SysUser;
import lombok.Data;

/**
 * @Author: jiangwei
 * @Date: 2020-12-10
 * @Version: 1.0
 * @Description:
 */
@Data
public class UserDto {

    private static final long serialVersionUID = -754511820185370896L;

    /**
     * userId
     */
    private String userId;

    /**
     * userName
     */
    private String userName;

    /**
     * userPhone
     */
    private String userPhone;

    /**
     * orgId
     */
    private Long orgId;

    /**
     * head
     */
    private String head;

    /**
     * workNum
     */
    private String workNum;

    /**
     * status
     */
    private Integer status;

    /**
     * userType
     */
    private String userType;

    public UserDto(SysUser user) {
        this.userId = String.valueOf(user.getId());
        this.userType = user.getUserType();
        this.userPhone = "18271458826";
        this.orgId = 11L;
        this.status = 1;
        this.workNum = "64048";
        this.head = "";
        this.userName = user.getUsername();
    }

}
