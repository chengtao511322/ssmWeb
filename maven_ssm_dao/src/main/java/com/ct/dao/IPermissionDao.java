package com.ct.dao;

import com.ct.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限Dao
 */
@Repository//把代理dao放入spring的容器当中
public interface IPermissionDao {

    /**
     * 通过角色ID,查询出该角色所具有的权限
     * @param roleId
     * @return
     */
    @Select(value = "select * from permission where id  in (select permissionId from role_permission where roleId = #{id} )" )
    public List<Permission> findPermissonByRoleId(String roleId);

    /**
     * 查询所有权限的信息
     * @return
     */
    @Select(value = "select * from permission")
    List<Permission> findAll();

}
