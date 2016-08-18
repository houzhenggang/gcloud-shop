package com.gcloud.shop.web.util;

import java.text.DecimalFormat;

/**
 * 基于位置的服务工具类
 * Created by za on 16/7/5.
 */
public class LBSUtil {

    /**
     * 地球半径
     */
    public static final double EARTH_REDIUS = 6378137d;

    public static double calculateDistance(double lng1, double lat1, double lng2, double lat2) {
        double a, b;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (lng1 - lng2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * EARTH_REDIUS * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /**
     * 计算距离 保留两位数
     * @param lng1
     * @param lat1
     * @param lng2
     * @param lat2
     * @return
     */
    public static String calculateKm(double lng1, double lat1, double lng2, double lat2) {

        String kmStr = "";
        double km = calculateDistance(lng1, lat1, lng2, lat2);
        DecimalFormat decimalFormat = new DecimalFormat("######0.0");
        if( km> 1000){
            km = km /1000;
            kmStr = decimalFormat.format(km) + "km";
        } else {
            kmStr = decimalFormat.format(km) + "m";
        }
        return kmStr;
    }

}
