package com.jiangwei.authserver.service;

import com.jiangwei.authserver.domain.Permission;
public interface PermissionService{


    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

}
