package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 10:56
 */
public interface IOrdersService {

    /**
     * 分页查询所有订单信息
     * @param pageNum 页码
     * @param pageSize 每页显示条数
     * @return 所有订单
     */
    List<Orders> findAll(int pageNum,int pageSize);

    /**
     通过订单id查询订单详情
     * @param ordersId 订单id
     * @return 订单对象
     */
    Orders findById(String ordersId);
}
