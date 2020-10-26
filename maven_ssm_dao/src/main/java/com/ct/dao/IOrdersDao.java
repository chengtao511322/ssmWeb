package com.ct.dao;

import com.ct.Member;
import com.ct.Orders;
import com.ct.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository//吧代理对象放入容器当中
public interface IOrdersDao {

    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    //设置result相当于xml配置文件中的resultMap 让实体类和数据库字段一一对应
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderTimeStr",column = "orderTimeStr"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",one = @One(select = "com.ct.dao.IProductDao.findById"))
    })
    List<Orders> findAll();

    /**
     * 根据Id查询订单详细信息
     *
     * @return
     */
    @Select("select * from orders where id =#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderTimeStr",column = "orderTimeStr"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",one = @One(select = "com.ct.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",one = @One(select = "com.ct.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",many = @Many(select = "com.ct.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId);
}
