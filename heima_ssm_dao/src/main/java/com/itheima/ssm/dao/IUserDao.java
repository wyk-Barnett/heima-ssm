package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/4 0004 15:11
 */
public interface IUserDao {
    /**
     * 根据用户名查找用户
     * @param  username 用户名
     * @return UserInfo
     */
    UserInfo findByUsername(String username);

    /**
     * 查询所有用户
     * @return List<UserInfo>
     */
    List<UserInfo> findAll();

    /**
     * 添加用户
     * @param userInfo 用户对象
     */
    void save(UserInfo userInfo);

    /**
     * 根据id查找用户
     * @param id 用户id
     * @return 用户对象
     */
    UserInfo findById(String id);

    /**
     * 根据用户id查询用户所具有的角色
     * @param userId 用户id
     * @return 用户所具有的角色
     */
    List<Role> findAllRoleById(String userId);

    /**
     * 给用户添加角色
     * @param userId 用户id
     * @param roleId 角色id
     */
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
