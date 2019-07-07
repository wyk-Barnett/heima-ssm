package com.itheima.ssm.dao;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 16:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class TestDao {
    @Autowired
    private IOrdersDao ordersDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Test
    public void test5() {
        List<Role> list = userDao.findAllRoleById("BDEC310990F14A6D8F5B5B3EA1C72A19");
        System.out.println(list);
    }

    @Test
    public void test4() {
        List<Role> all = roleDao.findAll();
        System.out.println(all);
    }


    @Test
    public void test3() {
        UserInfo userInfo = userDao.findById("F55DC1C642CF4CE989A4F69789DC59E0");
        System.out.println(userInfo);
    }

    @Test
    public void test2() {
        UserInfo userInfo = userDao.findByUsername("zhang");
        System.out.println(userInfo);
    }

    @Test
    public void test() {
        PageHelper.startPage(1, 4);
        List<Orders> all = ordersDao.findAll();
        System.out.println(all.size());
    }
    @Test
    public void test1() {
        Orders orders = ordersDao.findById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(orders);
        System.out.println(orders.getMember());
        System.out.println(orders.getProduct());
        System.out.println(orders.getTravellers());
    }
}
