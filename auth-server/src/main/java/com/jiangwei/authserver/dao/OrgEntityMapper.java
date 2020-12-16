package com.jiangwei.authserver.dao;


import com.jiangwei.authserver.domain.OrgEntity;

public interface OrgEntityMapper {
    int deleteByPrimaryKey(Long orgId);

    int insert(OrgEntity record);

    int insertSelective(OrgEntity record);

    OrgEntity selectByPrimaryKey(Long orgId);

    int updateByPrimaryKeySelective(OrgEntity record);

    int updateByPrimaryKey(OrgEntity record);
}