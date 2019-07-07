package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/4 0004 20:29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                @RequestParam(name = "pageSize",defaultValue = "4")Integer pageSize){
        ModelAndView mav = new ModelAndView();
        List<UserInfo> userList = userService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(userList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("user-list");
        System.out.println(pageInfo);
        return mav;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView mav = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mav.addObject("userInfo",userInfo);
        mav.setViewName("user-show");
        return mav;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id") String userId){
        ModelAndView mav = new ModelAndView();
        List<Role> otherRoles = userService.findAllRoleById(userId);
        mav.addObject("roleList",otherRoles);
        mav.addObject("userId",userId);
        mav.setViewName("user-role-add");
        return mav;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") String userId,@RequestParam(name = "ids")String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
