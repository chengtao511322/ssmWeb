package com.ct.service.impl;

import com.ct.Permission;
import com.ct.dao.IPermissionDao;
import com.ct.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * permission service 实现类
 */
@Service(value = "permissionService")
@Transactional
public class PermissionService implements IPermissionService {

    @Autowired
    IPermissionDao permissionDao;

    /**
     * 查询所有方法
     * @return
     */
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }
}
