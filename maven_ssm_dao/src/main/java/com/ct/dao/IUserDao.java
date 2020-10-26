package com.ct.dao;

import com.ct.Role;
import com.ct.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户验证
 */
@Repository
public interface IUserDao {

    /**
     * 通过姓名查询用户信息
     * @param username
     * @return
     */
    @Select(value = "select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ct.dao.IRoleDao.findByUserId"))
    })
    public UserInfo findByUsername(String username);

    /**
     * 查询所有用户
     * @return
     */
    @Select(value = "select * from users")
    List<UserInfo> findAll();

    /**
     * 添加用户信息
     */
    @Insert(value = "insert into users (email,username,password,phoneNum,status) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    /**
     * 根据id查询用户,并把用户对应的角色查询出来
     * @param id
     * @return
     */
    @Select(value = "select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ct.dao.IRoleDao.findByUserId"))
    })
    UserInfo findById(String id);

    /**
     * 根据用户id查询出用户还可以添加的角色信息,
     * 根据userId先从中间表查出用户已经有的角色，再查role表查询出用户可以添加的角色
     * @param userId
     * @return
     */
    @Select(value = "select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);


    @Insert(value = "insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
