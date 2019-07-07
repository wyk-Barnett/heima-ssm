package com.itheima.ssm.domain;

import lombok.Data;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 10:52
 */
@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
