package com.itheima.ssm.domain;

import lombok.Data;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 10:52
 */
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    /**
     * 证件类型 0身份证 1护照 2军官照
     */
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    /**
     * 旅客类型 0成人 1儿童
     */
    private Integer travellerType;
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if (credentialsType == 0){
            credentialsTypeStr = "身份证";
        }else if (credentialsType == 1){
            credentialsTypeStr = "护照";
        }else if (credentialsType == 2){
            credentialsTypeStr = "军官照";
        }
        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if (travellerType == 0){
            travellerTypeStr = "成人";
        }else if (travellerType == 1){
            travellerTypeStr = "儿童";
        }
        return travellerTypeStr;
    }
}
