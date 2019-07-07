package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/6/30 0030 16:26
 */
public interface IProductDao {
    /**
     * 查询所有的产品信息
     * @return
     */
    List<Product> findAll();

    /**
     * 保存产品信息
     * @param product
     */
    void save(Product product);
}
