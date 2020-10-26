package com.ct.dao;

import com.ct.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select(value = "select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result (id = true,property = "id",column = "id"),
            @Result (id = true,property = "roleName",column = "roleName"),
            @Result (id = true,property = "roleDesc",column = "roleDesc"),
            @Result (id = true,property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ct.dao.IPermissionDao.findPermissonByRoleId")),

    })
    List<Role> findByUserId(String userId);

    /**
     * 查询所有角色
     * @return
     */
    @Select(value = "select * from role")
    @Results({
            @Result (id = true,property = "id",column = "id"),
            @Result (id = true,property = "roleName",column = "roleName"),
            @Result (id = true,property = "roleDesc",column = "roleDesc"),
            @Result (id = true,property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ct.dao.IPermissionDao.findPermissonByRoleId")),

    })
    List<Role> findAll();
}
