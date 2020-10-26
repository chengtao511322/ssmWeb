package com.ct.controller;

import com.ct.Role;
import com.ct.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色查询
 */
@Controller
@RequestMapping(path = "/role")
public class RoleController {

    //调用roleService
    @Autowired
    IRoleService roleService;

    @RequestMapping(path = "/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
}
