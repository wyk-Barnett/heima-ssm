package com.itheima.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 9:39
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                @RequestParam(name = "pageSize",defaultValue = "4")Integer pageSize){
        ModelAndView mav = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("orders-list");
        return mav;
    }

    @RequestMapping("findById")
    public ModelAndView findAllById(@RequestParam(name = "id")String ordersId){
        ModelAndView mav = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mav.addObject("orders",orders);
        mav.setViewName("orders-show");
        return mav;
    }

}
