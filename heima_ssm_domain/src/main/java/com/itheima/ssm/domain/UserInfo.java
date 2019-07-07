package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * 用户类
 * @author wangyangkun
 * @date 2019/7/4 0004 14:58
 */
@Data
public class UserInfo {
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status == 0){
            statusStr = "未开启";
        }else if (status == 1){
            statusStr = "开启";
        }
        return statusStr;
    }
}
