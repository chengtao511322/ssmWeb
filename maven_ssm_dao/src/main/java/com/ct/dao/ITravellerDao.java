package com.ct.dao;

import com.ct.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 旅客信息Dao
 */
@Repository
public interface ITravellerDao {

    /**
     * 所有旅客信息
     * @return
     */
    @Select(value = "select * from traveller ")
    public List<Traveller> findAll();

    /**
     * 通过orders 的id查询旅客信息
     */
    @Select(value = "SELECT * FROM traveller WHERE id IN( SELECT travellerId FROM order_traveller WHERE orderId = #{ordersId} )")
    public List<Traveller> findByOrdersId(String ordersId);
}
