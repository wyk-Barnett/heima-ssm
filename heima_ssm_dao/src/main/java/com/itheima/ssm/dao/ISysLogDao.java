package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/6 0006 19:24
 */
public interface ISysLogDao {
    /**
     *  查询所有日志信息
     * @return 日志信息集合
     */
    List<SysLog> findAll();

    /**
     * 保存日志信息
     * @param sysLog 日志对象
     */
    void save(SysLog sysLog);
}
