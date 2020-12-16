package com.jiangwei.authserver.service;

import com.jiangwei.authserver.dao.PermissionMapper;
import com.jiangwei.authserver.dao.RoleMapper;
import com.jiangwei.authserver.dao.UserMapper;
import com.jiangwei.authserver.domain.Role;
import com.jiangwei.authserver.domain.SysUser;
import com.jiangwei.authserver.entity.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Resource
    private UserMapper userEntityMapper;


    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userEntityMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(SysUser record) {
        return userEntityMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return userEntityMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userId) {
        SysUser SysUser = userEntityMapper.selectByPrimaryKey(userId);
        return SysUser;
    }

    @Override
    public SysUser selectByName(String userName) {
        return userEntityMapper.selectByName(userName);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return userEntityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return userEntityMapper.updateByPrimaryKey(record);
    }


    @Override
    public ResultDto validToken(String token) {
        Map map = new HashMap<>();
        map.put("expires_in", 7200);
        map.put("status", 1);
        map.put("msg", "令牌有效");
        return ResultDto.builder().code(0).success(true).data(map).msg("成功").build();
    }

    @Override
    public ResultDto logout(String token) {
        return ResultDto.builder().code(0).success(true).msg("成功").build();
    }

    @Override
    public List<SysUser> selectAll(String userType) {
        return userEntityMapper.selectAll(userType);
    }

    @Override
    public List<Role> selectRolePermission(Integer uid) {
        List<Role> roles = roleMapper.selectRoleByUid(uid);
        roles.forEach(role -> role.setPermissionList(permissionMapper.selectByRid(role.getId())));
        return roles;
    }

}
