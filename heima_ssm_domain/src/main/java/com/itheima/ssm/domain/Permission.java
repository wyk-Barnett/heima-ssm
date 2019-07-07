package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * 权限类
 * @author wangyangkun
 * @date 2019/7/4 0004 15:03
 */
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
