package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wangyangkun
 * @date 2019/6/30 0030 16:22
 *  产品信息
 */
@Data
public class Product {
    /**
     * id 主键 无任何意义
     */
    private String id;
    /**
     * 编号 唯一
     */
    private String productNum;
    /**
     * 名称
     */
    private String productName;
    /**
     * 出发城市
     */
    private String cityName;
    /**
     * 出发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    /**
     * 产品价格
     */
    private double productPrice;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 状态 0 关闭 1 开启
     */
    private Integer productStatus;
    private String productStatusStr;

    public String getDepartureTimeStr() {
        if (productStatus != null){
            departureTimeStr = DateUtils.date2String(departureTime,"yyyy-MM-dd HH:mm");
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {
        if (productStatus==0){
            productStatusStr = "关闭";
        }
        if (productStatus==1){
            productStatusStr = "开启";
        }
        return productStatusStr;
    }

}
