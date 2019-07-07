package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/4 0004 15:08
 */
public interface IUserService extends UserDetailsService {
    /**
     * 与dao层交互,根据用户名查找用户
     * @param username 用户名
     * @return UserDetails
     * @throws UsernameNotFoundException 用户名未找到异常
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * 分页查询所有用户
     * @param pageNum 页码
     * @param pageSize 每页显示条数
     * @return 用户集合
     */
    List<UserInfo> findAll(int pageNum,int pageSize);

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
     * @param roleIds 角色id数组
     */
    void addRoleToUser(String userId, String[] roleIds);
}
