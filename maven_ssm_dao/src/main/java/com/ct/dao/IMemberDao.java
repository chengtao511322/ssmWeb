package com.ct.dao;

import com.ct.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * membereDao
 */
@Repository
public interface IMemberDao {

    /**
     * 查询所有会员信息
     */
    public List<Member> findAll();

    /**
     * 通过id查询会员信息
     */
    @Select(value = "select * from member where id = #{memberId}")
    public Member findById(String memberId);

}
