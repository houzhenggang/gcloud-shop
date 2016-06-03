package com.gcloud.shop.domain.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * 罗马数字转中文简体数字
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class Numeric2ChineseStr {

    // 单位数组
    final static String[] units = new String[]{"十", "百", "千", "万", "十", "百", "千", "亿"};

    // 中文大写数字数组
    final static String[] numeric = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static String toDo(String temp) {

        if (!StringUtils.isNumeric(temp)) throw new IllegalArgumentException("格式化错误,不是数字");

        String res = "";

        // 遍历一行中所有数字
        for (int k = -1; temp.length() > 0; k++) {
            // 解析最后一位
            int j = Integer.parseInt(temp.substring(temp.length() - 1, temp.length()));
            String rtemp = numeric[j];

            // 数值不是0且不是个位 或者是万位或者是亿位 则去取单位
            if (j != 0 && k != -1 || k % 8 == 3 || k % 8 == 7) {
                rtemp += units[k % 8];
            }

            // 拼在之前的前面
            res = rtemp + res;

            // 去除最后一位
            temp = temp.substring(0, temp.length() - 1);
        }

        // 去除后面连续的零零..
        while (res.endsWith(numeric[0])) {
            res = res.substring(0, res.lastIndexOf(numeric[0]));
        }

        // 将零零替换成零
        while (res.contains(numeric[0] + numeric[0])) {
            res = res.replaceAll(numeric[0] + numeric[0], numeric[0]);
        }

        // 将 零+某个单位 这样的窜替换成 该单位 去掉单位前面的零
        for (int m = 1; m < units.length; m++) {
            res = res.replaceAll(numeric[0] + units[m], units[m]);
        }

        return res;
    }

}
