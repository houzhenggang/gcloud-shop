package com.gcloud.shop.domain.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 省市简称
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class Provice2ShortUtils {

    static final Logger logger = LogManager.getLogger(Provice2ShortUtils.class);

    public static String convert(String province) {
        if (StringUtils.isEmpty(province)) return "";
        else if (province.contains("北京"))
            return province.replaceAll("北京(?!市)", "京-");
        else if (province.contains("天津"))
            return province.replaceAll("天津(?!市)", "津-");
        else if (province.contains("重庆"))
            return province.replaceAll("重庆(?!市)", "渝-");
        else if (province.contains("上海"))
            return province.replaceAll("上海(?!市)", "沪-");
        else if (province.contains("河北省"))
            return province.replace("河北省", "冀-");
        else if (province.contains("山西省"))
            return province.replace("山西省", "晋-");
        else if (province.contains("辽宁省"))
            return province.replace("辽宁省", "辽-");
        else if (province.contains("吉林省"))
            return province.replace("吉林省", "吉-");
        else if (province.contains("黑龙江省"))
            return province.replace("黑龙江省", "黑-");
        else if (province.contains("江苏省"))
            return province.replace("江苏省", "苏-");
        else if (province.contains("浙江省"))
            return province.replace("浙江省", "浙-");
        else if (province.contains("安徽省"))
            return province.replace("安徽省", "皖-");
        else if (province.contains("福建省"))
            return province.replace("福建省", "闽-");
        else if (province.contains("江西省"))
            return province.replace("江西省", "赣-");
        else if (province.contains("山东省"))
            return province.replace("山东省", "鲁-");
        else if (province.contains("河南省"))
            return province.replace("河南省", "豫-");
        else if (province.contains("湖北省"))
            return province.replace("湖北省", "鄂-");
        else if (province.contains("湖南省"))
            return province.replace("湖南省", "湘-");
        else if (province.contains("广东省"))
            return province.replace("广东省", "粤-");
        else if (province.contains("海南省"))
            return province.replace("海南省", "琼-");
        else if (province.contains("四川省"))
            return province.replace("四川省", "川/蜀-");
        else if (province.contains("贵州省"))
            return province.replace("贵州省", "黔/贵-");
        else if (province.contains("云南省"))
            return province.replace("云南省", "云/滇-");
        else if (province.contains("陕西省"))
            return province.replace("陕西省", "陕/秦-");
        else if (province.contains("甘肃省"))
            return province.replace("甘肃省", "甘/陇-");
        else if (province.contains("青海省"))
            return province.replace("青海省", "青-");
        else if (province.contains("台湾省"))
            return province.replace("台湾省", "台-");
        else if (province.contains("内蒙古自治区"))
            return province.replace("内蒙古自治区", "内蒙古-");
        else if (province.contains("广西壮族自治区"))
            return province.replace("广西壮族自治区", "桂-");
        else if (province.contains("宁夏回族自治区"))
            return province.replace("宁夏回族自治区", "宁-");
        else if (province.contains("新疆维吾尔自治区 "))
            return province.replace("新疆维吾尔自治区", "新-");
        else if (province.contains("西藏自治区"))
            return province.replace("西藏自治区", "藏-");
        else if (province.contains("香港特别行政区"))
            return province.replace("香港特别行政区", "港-");
        else if (province.contains("澳门特别行政区"))
            return province.replace("澳门特别行政区", "澳-");
        else return province;
    }
}
