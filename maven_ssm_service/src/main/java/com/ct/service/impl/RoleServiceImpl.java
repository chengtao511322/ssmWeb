package com.ct.service.impl;

import com.ct.Role;
import com.ct.dao.IRoleDao;
import com.ct.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * RoleService实现类
 */
@Service
@Transactional//添加事务管理
public class RoleServiceImpl implements IRoleService {

    //service调用dao接口的findAll方法
    @Autowired
    IRoleDao roleDao ;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
