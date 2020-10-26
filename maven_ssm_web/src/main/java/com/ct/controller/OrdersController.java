package com.ct.controller;

import com.ct.Orders;
import com.ct.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ordersController
 */
@RequestMapping(path = "/orders")
@Controller
public class OrdersController {

    //注入orders service对象来调用方法
    @Autowired//自动按类型注入
    private IOrdersService ordersService;

    //使用modelAndView查询出所有数据，并返回至前台显示
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10")int size){
        ModelAndView mv = new ModelAndView();
        //返回分页对象
        List<Orders> ordersList = ordersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    //查询订单详情
    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
