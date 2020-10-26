package com.ct.controller;

import com.ct.Role;
import com.ct.UserInfo;
import com.ct.dao.IUserDao;
import com.ct.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {



    @Autowired
    private IUserService userService;

    /**
     * 查询所有用户
     */
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 添加用户
     */
    @RequestMapping(path = "/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 查询指定id的用户
     */
    @RequestMapping(path = "/findById")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 用户关联角色,查询用户和用户现有的角色
     */
    @RequestMapping(path = "/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
        ModelAndView mv = new ModelAndView();

        //1.根据用户id查询用户信息
        UserInfo userInfo = userService.findById(userId);

        //根据用户ID查询出该用户可以添加的其他角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 角色与用户绑定
     * @return
     */
    @RequestMapping(path = "/addRoleToUser.do")
    public String addRole(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){

        userService.addRole(userId,roleIds);
        return "redirect:findAll.do";
    }
}
