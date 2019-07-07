package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/5 0005 15:19
 */
public interface IPermissionDao {

    /**
     * 查询所有权限
     * @return Permission集合
     */
    List<Permission> findAll();

    /**
     * 添加权限
     * @param permission 权限对象
     */
    void save(Permission permission);
}
