package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wangyangkun
 * @date 2019/7/2 0002 10:52
 */
@Data
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    /**
     * 出行人数
     */
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    /**
     * 产品描述
     */
    private String orderDesc;

    public String getOrderTimeStr() {
        if (orderTime != null){
            orderTimeStr = DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    /**
     * //订单状态 0未支付 1已支付
     * @return orderStatusStr
     */
    public String getOrderStatusStr() {

        if (orderStatus == 0){
            orderStatusStr = "未支付";
        }
        if (orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    /**
     * 支付方式 0支付宝 1微信 2其他
     * @return payTypeStr
     */
    public String getPayTypeStr() {
        if (payType == 0){
            payTypeStr = "支付宝";
        }else if (payType == 1){
            payTypeStr = "微信";
        }else if (payType == 2){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }
}
