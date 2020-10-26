package com.ct.service;

import com.ct.Orders;

import java.util.List;


public interface IOrdersService {

    /**
     * 查询所有订单
     */
    List<Orders> findAll(int page,int size);

    /**
     * 根据订单Id查询详细信息
     * @return
     */
    Orders findById(String id);
}
