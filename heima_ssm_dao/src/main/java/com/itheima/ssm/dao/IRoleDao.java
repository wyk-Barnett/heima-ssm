package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/5 0005 14:51
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return 角色集合
     */
    List<Role> findAll();

    /**
     * 添加角色
     * @param role 角色对象
     */
    void save(Role role);

    /**
     *  根据角色id查询角色所具有的权限
     * @param roleId 角色id
     * @return 权限集合
     */
    List<Permission> findPermissionByRoleId(String roleId);

    /**
     * 给角色添加权限
     * @param roleId 角色id
     * @param permissionId 权限id
     */
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
