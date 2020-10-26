package com.ct.service.impl;

import com.ct.Orders;
import com.ct.dao.IOrdersDao;
import com.ct.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ordersService实现类
 */
@Service
@Transactional//配置事务
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;


    /**
     * 查询所有订单信息
     * @return
     */
    /*@Override
    public List<Orders> findAll() {
        List<Orders> ordersList = ordersDao.findAll();
        return ordersList;
    }*/

    /**
     * 分页查询订单，使用mybatis pageHelper分页插件
     */
    @Override
    public List<Orders> findAll(int page,int size) {
        //查询之前，先调用分页插件的startPage
        PageHelper.startPage(page, size);
        List<Orders> ordersList = ordersDao.findAll();
        return ordersList;
    }

    /**
     * 根据id查询订单信息信息
     * @param id
     * @return
     */
    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
