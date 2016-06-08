package com.gcloud.shop.api.utils.json;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JSONValidatingWriter
 * @Package com.gcloud.shop.api.utils.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:49
 */
public class JSONValidatingWriter extends JSONWriter {

    private JSONValidator validator;

    public JSONValidatingWriter(JSONValidator validator, boolean emitClassName) {
        super(emitClassName);
        this.validator = validator;
    }

    public JSONValidatingWriter(JSONValidator validator) {
        this.validator = validator;
    }

    public JSONValidatingWriter(JSONErrorListener listener, boolean emitClassName) {
        this(new JSONValidator(listener), emitClassName);
    }

    public JSONValidatingWriter(JSONErrorListener listener) {
        this(new JSONValidator(listener));
    }

    public JSONValidatingWriter() {
        this((JSONErrorListener)(new StdoutStreamErrorListener()));
    }

    public JSONValidatingWriter(boolean emitClassName) {
        this((JSONErrorListener)(new StdoutStreamErrorListener()), emitClassName);
    }

    private String validate(String text) {
        this.validator.validate(text);
        return text;
    }

    public String write(Object object) {
        return this.validate(super.write(object));
    }

    public String write(long n) {
        return this.validate(super.write(n));
    }

    public String write(double d) {
        return this.validate(super.write(d));
    }

    public String write(char c) {
        return this.validate(super.write(c));
    }

    public String write(boolean b) {
        return this.validate(super.write(b));
    }
}
