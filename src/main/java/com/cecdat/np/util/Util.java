package com.cecdat.np.util;

import com.alibaba.fastjson.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA
 *
 * @author: liuzihao@cecdat.com
 * Date: 2018/6/25
 * Time: 21:12
 */
public class Util {
    public static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");


    public static JSONArray getRandomColor(){
        JSONArray COLOR = new JSONArray();
        for(int i =0 ; i<3 ; i++) {
            Integer r = new Random().nextInt(255 - 16 + 1) + 16;
            Integer g = new Random().nextInt(255 - 16 + 1) + 16;
            Integer b = new Random().nextInt(255 - 16 + 1) + 16;
            String hexR = r.toHexString(r);
            String hexG = g.toHexString(g);
            String hexB = b.toHexString(b);
            COLOR.add("#"+ hexR + hexG + hexB);
        }
        return COLOR;
    }
    /**
     * 格式化日期时间
     *
     * @param date
     * @return 返回 2016-2-23 10:23:43 格式的日期时间
     */
    public static String getDateTimeWithDate(Date date) {
        return simpledateformat.format(date);
    }

    /**
     *
     * @Description: 时间字符串转时间格式,传入字符串格式
     *
     * @param:
     * @return:
     */
    public final static Date parseDate(String aDate, String formatStr){
        if (aDate == null || aDate.equals(""))
            return null;
        if(formatStr == null || formatStr == ""){
            return parseDate(aDate);
        }
        Date xdate = null;
        java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat(formatStr);
        try {
            xdate = formatter3.parse(aDate);
            if (xdate != null) {
                return xdate;
            }
        } catch (Exception ee) {
        }
        return xdate;
    }


    public final static Date parseDate(String aDate){
        if (aDate == null || aDate.equals(""))
            return null;
        return parseDateFormat(aDate);
    }

    public final static Date parseDateFormat(String aDate){
        Date xdate = null;
        if (aDate.length() == 19 && aDate.charAt(4) == '-' && aDate.charAt(7) == '-' && aDate.charAt(13) == '-' && aDate.charAt(16) == '-') {
            java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                xdate = formatter3.parse(aDate);
                if (xdate != null) {
                    return xdate;
                }
            } catch (Exception ee) {
            }
        }
        if (aDate.length() == 8 && aDate.indexOf('/') == -1 && aDate.indexOf('-') == -1 && aDate.indexOf('_') == -1) {
            java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat("yyyyMMdd");
            try {
                xdate = formatter3.parse(aDate);
                if (xdate != null) {
                    return xdate;
                }
            } catch (Exception ee) {
            }
        }
        if (aDate.length() == 10 && aDate.charAt(4) == '/' && aDate.charAt(7) == '/') {
            java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat("yyyy/MM/dd");
            try {
                xdate = formatter3.parse(aDate);
                if (xdate != null) {
                    return xdate;
                }
            } catch (Exception ee) {
            }
        }
        if (aDate.length() == 10 && aDate.charAt(4) == '-' && aDate.charAt(7) == '-') {
            java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat("yyyy-MM-dd");
            try {
                xdate = formatter3.parse(aDate);
                if (xdate != null) {
                    return xdate;
                }
            } catch (Exception ee) {
            }
        }
        if (aDate.length() == 7 && aDate.charAt(4) == '-') {
            java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat("yyyy-MM");
            try {
                xdate = formatter3.parse(aDate);
                if (xdate != null) {
                    return xdate;
                }
            } catch (Exception ee) {
            }
        }

        return xdate;
    }

    /**
     *
     * @Description: 由起始时间,获得mapper的Map<String,Date>参数,用于数据库字段为date的between
     *
     * @param:
     * @return:
     */
    public static Map<String,Date> getParamMapByStartAndEndDate(String startDate, String endDate) {

        return new HashMap<String,Date>(){
            {
                put("startDate", Util.parseDate(startDate));
                put("endDate", Util.parseDate(endDate));
            }
        };
    }

    /**
     *
     * @Description: 由起始时间,获得mapper的Map<String,String>参数,用于数据库字段为varchar的between
     *
     * @param:
     * @return:
     */
    public static Map<String,String> getStringParamMapByStartAndEndDate(String startDate, String endDate) {

        return new HashMap<String,String>(){
            {
                put("startDate", startDate);
                put("endDate", endDate);
            }
        };
    }

    public static Map<String,Object> getParamMapOfBootStrapTable(String startDate, String endDate,int pageSize, int pageNumber, String sortName, String sortOrder, String searchText){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("startDate", Util.parseDate(startDate));
        paramMap.put("endDate", Util.parseDate(endDate));
        paramMap.put("pageSize", pageSize);
        paramMap.put("pageStartIndex", (pageNumber - 1) * pageSize);
        paramMap.put("sortName", sortName);
        paramMap.put("sortOrder", sortOrder);
        paramMap.put("searchText", searchText);

        return paramMap;
    }
}
