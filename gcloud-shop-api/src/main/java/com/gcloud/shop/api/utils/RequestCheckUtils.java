package com.gcloud.shop.api.utils;

import com.gcloud.shop.api.FileItem;
import com.gcloud.shop.api.exception.GcloudRuleException;
import com.gcloud.shop.api.utils.json.JSONValidatingReader;

import java.io.IOException;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: RequestCheckUtils
 * @Package com.gcloud.shop.api.utils
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:34
 */
public class RequestCheckUtils {

    public RequestCheckUtils() {

    }

    public static final String ERROR_CODE_ARGUMENTS_MISSING = "40";
    public static final String ERROR_CODE_ARGUMENTS_INVALID = "41";


    public static void checkNotEmpty(Object value, String fieldName) throws GcloudRuleException {
        if(value == null) {
            throw new GcloudRuleException("40", "client-error:Missing required arguments:" + fieldName + "");
        } else if(value instanceof String && ((String)value).trim().length() == 0) {
            throw new GcloudRuleException("40", "client-error:Missing required arguments:" + fieldName + "");
        }
    }

    public static void checkMaxLength(String value, int maxLength, String fieldName) throws GcloudRuleException {
        if(value != null && value.length() > maxLength) {
            throw new GcloudRuleException("41", "client-error:Invalid arguments:the string length of " + fieldName + " can not be larger than " + maxLength + ".");
        }
    }

    public static void checkMaxLength(FileItem fileItem, int maxLength, String fieldName) throws GcloudRuleException {
        try {
            if(fileItem != null && fileItem.getContent() != null && fileItem.getContent().length > maxLength) {
                throw new GcloudRuleException("41", "client-error:Invalid arguments:the file size of " + fieldName + " can not be larger than " + maxLength + ".");
            }
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static void checkMaxListSize(String value, int maxSize, String fieldName) throws GcloudRuleException {
        if(value != null) {
            String[] list = value.split(",");
            if(list != null && list.length > maxSize) {
                throw new GcloudRuleException("41", "client-error:Invalid arguments:the array size of " + fieldName + " must be less than " + maxSize + ".");
            }
        }

    }

    public static void checkObjectMaxListSize(String value, int maxSize, String fieldName) throws GcloudRuleException {
        if(value != null) {
            JSONValidatingReader reader = new JSONValidatingReader();
            Object obj = reader.read(value);
            if(obj instanceof List && ((List)obj).size() > maxSize) {
                throw new GcloudRuleException("41", "client-error:Invalid arguments:the array size of " + fieldName + " must be less than " + maxSize + ".");
            }
        }

    }

    public static void checkMaxValue(Long value, long maxValue, String fieldName) throws GcloudRuleException {
        if(value != null && value.longValue() > maxValue) {
            throw new GcloudRuleException("41", "client-error:Invalid arguments:the value of " + fieldName + " can not be larger than " + maxValue + ".");
        }
    }

    public static void checkMinValue(Long value, long minValue, String fieldName) throws GcloudRuleException {
        if(value != null && value.longValue() < minValue) {
            throw new GcloudRuleException("41", "client-error:Invalid arguments:the value of " + fieldName + " can not be less than " + minValue + ".");
        }
    }

}
