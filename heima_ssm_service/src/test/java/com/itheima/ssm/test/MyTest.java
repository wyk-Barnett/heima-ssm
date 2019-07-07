package com.itheima.ssm.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wangyangkun
 * @date 2019/7/5 0005 9:57
 */
public class MyTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String encode = bc.encode("123");
        System.out.println(encode);
    }
}
