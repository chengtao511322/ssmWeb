package com.ct.service;

import com.ct.Role;
import com.ct.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 添加用户
     */
    void save(UserInfo userInfo);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    UserInfo findById(String id);

    /**
     * 通过用户Id查询出其他角色信息
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    void addRole(String userId, String[] roleIds);
}
