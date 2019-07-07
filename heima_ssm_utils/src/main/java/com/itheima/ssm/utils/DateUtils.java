package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangyangkun
 * @date 2019/7/1 0001 15:45
 */
public class DateUtils {
    /**
     * 日期转换为字符串
     * @param date
     * @param patt
     * @return
     */
    public static String date2String(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    public static Date string2Date(String s,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(s);
        return parse;
    }
}
