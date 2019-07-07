package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @author wangyangkun
 */
public interface IProductService {
    /**
     * 查询所有产品对象
     * @param pageNum 页码
     * @param pageSize 每页显示条数
     * @return 产品对象集合
     */
    List<Product> findAll(int pageNum,int pageSize);

    /**
     * 保存产品信息
     * @param product 产品对象
     */
    void save(Product product);
}
