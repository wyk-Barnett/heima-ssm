package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/5 0005 14:39
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mav.addObject("roleList",roleList);
        mav.setViewName("role-list");
        return mav;
    }

    @RequestMapping("/save.do")
    public String findAll(Role role){
        ModelAndView mav = new ModelAndView();
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndPermission.do")
    public ModelAndView findRoleByIdAndPermission(@RequestParam(name = "id") String roleId){
        ModelAndView mav = new ModelAndView();
        List<Permission> permissionList = roleService.findPermissionByRoleId(roleId);
        mav.addObject("permissionList",permissionList);
        mav.addObject("roleId",roleId);
        mav.setViewName("role-permission-add");
        return mav;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId")String roleId,@RequestParam(name = "ids")String[] permissionIds){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
}

