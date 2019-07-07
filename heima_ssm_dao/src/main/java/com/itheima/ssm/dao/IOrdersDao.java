package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 10:57
 */
public interface IOrdersDao {
    /**
     * 查询所有订单
     * @return 订单集合
     */
    List<Orders> findAll();

    /**
     * 通过订单id查询订单详情
     * @param ordersId 订单id
     * @return 订单对象
     */
    Orders findById(String ordersId);
}
