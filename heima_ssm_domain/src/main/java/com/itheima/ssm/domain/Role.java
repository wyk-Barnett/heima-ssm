package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * 角色类
 * @author wangyangkun
 * @date 2019/7/4 0004 15:00
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<UserInfo> users;
    private List<Permission> permissions;
}
