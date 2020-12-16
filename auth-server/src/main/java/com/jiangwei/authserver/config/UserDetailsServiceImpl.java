package com.jiangwei.authserver.config;

import com.jiangwei.authserver.domain.Role;
import com.jiangwei.authserver.domain.SysUser;
import com.jiangwei.authserver.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangwei
 * @Date: 2020-12-09
 * @Version: 1.0
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityService tbUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser tbUser = tbUserService.selectByName(username);
        if (tbUser == null) {
            throw new RuntimeException("无效用户");
        }
//通过用户id 查询对应的权限数据
        List<Role> roles = tbUserService.selectRolePermission(tbUser.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        roles.forEach(p -> {
            if (p != null && p.getName() != null) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(p.getName());
                grantedAuthorities.add(simpleGrantedAuthority);
            }
        });
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}