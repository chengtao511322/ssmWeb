package com.ct.service;

import com.ct.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 查询所有的权限信息
     */
    List<Permission> findAll();
}
