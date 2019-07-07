package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangyangkun
 * @date 2019/7/4 0004 15:10
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo dbuser = userDao.findByUsername(username);
        if (dbuser == null){
            throw new UsernameNotFoundException(username + "用户未查找到异常");
        }
        User user = new User(username,dbuser.getPassword(),dbuser.getStatus()==0?false:true,true,true,true,getAuthorities(dbuser.getRoles()));
        return user;
    }

    @Override
    public List<UserInfo> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userDao.findAll();
    }

    /**
     * 添加新用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
//        System.out.println(userInfo.getPassword());
        userDao.save(userInfo);
    }

    /**
     * 根据id查询用户详情
     * @param  id
     * @return UserInfo
     */
    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findAllRoleById(String userId) {
        return userDao.findAllRoleById(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }


    /**
     * 获取权限
     * @param  roles
     * @return list
     */
    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){

        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRoleName())).collect(Collectors.toList());
        /*
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
        */
    }
}