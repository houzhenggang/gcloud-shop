package com.gcloud.shop.api.internal.util;

import com.gcloud.shop.api.ApiRuleException;
import com.gcloud.shop.api.FileItem;
import com.gcloud.shop.api.internal.util.json.JSONValidatingReader;

import java.io.IOException;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: RequestCheckUtils
 * @Package com.gcloud.shop.api.internal.util
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:43
 */
public class RequestCheckUtils {
    public static final String ERROR_CODE_ARGUMENTS_MISSING = "40";
    public static final String ERROR_CODE_ARGUMENTS_INVALID = "41";

    public RequestCheckUtils() {
    }

    public static void checkNotEmpty(Object value, String fieldName) throws ApiRuleException {
        if(value == null) {
            throw new ApiRuleException("40", "client-error:Missing required arguments:" + fieldName + "");
        } else if(value instanceof String && ((String)value).trim().length() == 0) {
            throw new ApiRuleException("40", "client-error:Missing required arguments:" + fieldName + "");
        }
    }

    public static void checkMaxLength(String value, int maxLength, String fieldName) throws ApiRuleException {
        if(value != null && value.length() > maxLength) {
            throw new ApiRuleException("41", "client-error:Invalid arguments:the string length of " + fieldName + " can not be larger than " + maxLength + ".");
        }
    }

    public static void checkMaxLength(FileItem fileItem, int maxLength, String fieldName) throws ApiRuleException {
        try {
            if(fileItem != null && fileItem.getContent() != null && fileItem.getContent().length > maxLength) {
                throw new ApiRuleException("41", "client-error:Invalid arguments:the file size of " + fieldName + " can not be larger than " + maxLength + ".");
            }
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static void checkMaxListSize(String value, int maxSize, String fieldName) throws ApiRuleException {
        if(value != null) {
            String[] list = value.split(",");
            if(list != null && list.length > maxSize) {
                throw new ApiRuleException("41", "client-error:Invalid arguments:the array size of " + fieldName + " must be less than " + maxSize + ".");
            }
        }

    }

    public static void checkObjectMaxListSize(String value, int maxSize, String fieldName) throws ApiRuleException {
        if(value != null) {
            JSONValidatingReader reader = new JSONValidatingReader();
            Object obj = reader.read(value);
            if(obj instanceof List && ((List)obj).size() > maxSize) {
                throw new ApiRuleException("41", "client-error:Invalid arguments:the array size of " + fieldName + " must be less than " + maxSize + ".");
            }
        }

    }

    public static void checkMaxValue(Long value, long maxValue, String fieldName) throws ApiRuleException {
        if(value != null && value.longValue() > maxValue) {
            throw new ApiRuleException("41", "client-error:Invalid arguments:the value of " + fieldName + " can not be larger than " + maxValue + ".");
        }
    }

    public static void checkMinValue(Long value, long minValue, String fieldName) throws ApiRuleException {
        if(value != null && value.longValue() < minValue) {
            throw new ApiRuleException("41", "client-error:Invalid arguments:the value of " + fieldName + " can not be less than " + minValue + ".");
        }
    }
}
