package com.ct.dao;

import com.ct.Province;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinceDao {

    /**
     * 查询所有
     */
    @Select(value = "select * from province")
    List<Province> findAll();


}
