package com.jiangwei.authserver.service;



import com.jiangwei.authserver.domain.Role;
import com.jiangwei.authserver.domain.SysUser;
import com.jiangwei.authserver.entity.ResultDto;

import java.util.List;

public interface UserEntityService{


    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    SysUser selectByName(String userName);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    ResultDto validToken(String access_token);

    ResultDto logout(String access_token);

    List<SysUser> selectAll(String userType);


    List<Role> selectRolePermission(Integer uid);
}
