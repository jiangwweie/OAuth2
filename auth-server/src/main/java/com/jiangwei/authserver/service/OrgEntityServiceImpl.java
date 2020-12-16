package com.jiangwei.authserver.service;

import com.jiangwei.authserver.dao.OrgEntityMapper;
import com.jiangwei.authserver.domain.OrgEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class OrgEntityServiceImpl implements OrgEntityService{

    @Resource
    private OrgEntityMapper orgEntityMapper;

    @Override
    public int deleteByPrimaryKey(Long orgId) {
        return orgEntityMapper.deleteByPrimaryKey(orgId);
    }

    @Override
    public int insert(OrgEntity record) {
        return orgEntityMapper.insert(record);
    }

    @Override
    public int insertSelective(OrgEntity record) {
        return orgEntityMapper.insertSelective(record);
    }

    @Override
    public OrgEntity selectByPrimaryKey(Long orgId) {
        return orgEntityMapper.selectByPrimaryKey(orgId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrgEntity record) {
        return orgEntityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrgEntity record) {
        return orgEntityMapper.updateByPrimaryKey(record);
    }

}
