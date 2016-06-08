package com.gcloud.shop.api.internal.util.json;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JSONValidatingReader
 * @Package com.gcloud.shop.api.internal.util.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:39
 */
public class JSONValidatingReader extends JSONReader {

    public static final Object INVALID = new Object();
    private JSONValidator validator;

    public JSONValidatingReader(JSONValidator validator) {
        this.validator = validator;
    }

    public JSONValidatingReader(JSONErrorListener listener) {
        this(new JSONValidator(listener));
    }

    public JSONValidatingReader() {
        this((JSONErrorListener)(new StdoutStreamErrorListener()));
    }

    public Object read(String string) {
        return !this.validator.validate(string)?INVALID:super.read(string);
    }
}
