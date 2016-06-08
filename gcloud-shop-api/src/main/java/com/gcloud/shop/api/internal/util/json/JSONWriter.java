package com.gcloud.shop.api.internal.util.json;

import com.gcloud.shop.api.internal.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.*;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JSONWriter
 * @Package com.gcloud.shop.api.internal.util.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:40
 */
public class JSONWriter {

    private StringBuffer buf;
    private Stack<Object> calls;
    private boolean emitClassName;
    private boolean useApiStyle;
    private DateFormat format;
    static char[] hex = "0123456789ABCDEF".toCharArray();

    public JSONWriter(boolean emitClassName) {
        this.buf = new StringBuffer();
        this.calls = new Stack();
        this.emitClassName = true;
        this.useApiStyle = false;
        this.emitClassName = emitClassName;
    }

    public JSONWriter(boolean emitClassName, boolean useApiStyle) {
        this(emitClassName);
        this.useApiStyle = useApiStyle;
    }

    public JSONWriter() {
        this(false);
    }

    public JSONWriter(DateFormat format) {
        this(false);
        this.format = format;
    }

    public String write(Object object) {
        this.buf.setLength(0);
        this.value(object);
        return this.buf.toString();
    }

    public String write(long n) {
        return String.valueOf(n);
    }

    public String write(double d) {
        return String.valueOf(d);
    }

    public String write(char c) {
        return "\"" + c + "\"";
    }

    public String write(boolean b) {
        return String.valueOf(b);
    }

    private void value(Object object) {
        if(object != null && !this.cyclic(object)) {
            this.calls.push(object);
            if(object instanceof Class) {
                this.string(object);
            } else if(object instanceof Boolean) {
                this.bool(((Boolean)object).booleanValue());
            } else if(object instanceof Number) {
                this.add(object);
            } else if(object instanceof String) {
                this.string(object);
            } else if(object instanceof Character) {
                this.string(object);
            } else if(object instanceof Map) {
                this.map((Map)object);
            } else if(object.getClass().isArray()) {
                this.array(object);
            } else if(object instanceof Iterator) {
                this.array((Iterator)object);
            } else if(object instanceof Collection) {
                this.array(((Collection)object).iterator());
            } else if(object instanceof Date) {
                this.date((Date)object);
            } else {
                this.bean(object);
            }

            this.calls.pop();
        } else {
            this.add((Object)null);
        }

    }

    private boolean cyclic(Object object) {
        Iterator it = this.calls.iterator();

        Object called;
        do {
            if(!it.hasNext()) {
                return false;
            }

            called = it.next();
        } while(object != called);

        return true;
    }

    private void bean(Object object) {
        this.add("{");
        boolean addedSomething = false;

        try {
            BeanInfo info = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] ie = info.getPropertyDescriptors();

            for(int ff = 0; ff < ie.length; ++ff) {
                PropertyDescriptor i = ie[ff];
                String field = i.getName();
                Method value = i.getReadMethod();
                if((this.emitClassName || !"class".equals(field)) && value != null) {
                    if(!value.isAccessible()) {
                        value.setAccessible(true);
                    }

                    Object value1 = value.invoke(object, (Object[])null);
                    if(value1 != null) {
                        if(addedSomething) {
                            this.add(',');
                        }

                        if(this.useApiStyle) {
                            field = StringUtils.toUnderlineStyle(field);
                        }

                        this.add(field, value1);
                        addedSomething = true;
                    }
                }
            }

            Field[] var13 = object.getClass().getFields();

            for(int var14 = 0; var14 < var13.length; ++var14) {
                Field var15 = var13[var14];
                Object var16 = var15.get(object);
                if(var16 != null) {
                    if(addedSomething) {
                        this.add(',');
                    }

                    this.add(var15.getName(), var16);
                    addedSomething = true;
                }
            }
        } catch (IllegalAccessException var10) {
            var10.printStackTrace();
        } catch (InvocationTargetException var11) {
            var11.getCause().printStackTrace();
            var11.printStackTrace();
        } catch (IntrospectionException var12) {
            var12.printStackTrace();
        }

        this.add("}");
    }

    private void add(String name, Object value) {
        this.add('\"');
        this.add(name);
        this.add("\":");
        this.value(value);
    }

    private void map(Map<?, ?> map) {
        this.add("{");
        Iterator it = map.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            this.value(e.getKey());
            this.add(":");
            this.value(e.getValue());
            if(it.hasNext()) {
                this.add(',');
            }
        }

        this.add("}");
    }

    private void array(Iterator<?> it) {
        this.add("[");

        while(it.hasNext()) {
            this.value(it.next());
            if(it.hasNext()) {
                this.add(",");
            }
        }

        this.add("]");
    }

    private void array(Object object) {
        this.add("[");
        int length = Array.getLength(object);

        for(int i = 0; i < length; ++i) {
            this.value(Array.get(object, i));
            if(i < length - 1) {
                this.add(',');
            }
        }

        this.add("]");
    }

    private void bool(boolean b) {
        this.add(b?"true":"false");
    }

    private void date(Date date) {
        if(this.format == null) {
            this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        }

        this.add("\"");
        this.add(this.format.format(date));
        this.add("\"");
    }

    private void string(Object obj) {
        this.add('\"');
        StringCharacterIterator it = new StringCharacterIterator(obj.toString());

        for(char c = it.first(); c != '\uffff'; c = it.next()) {
            if(c == 34) {
                this.add("\\\"");
            } else if(c == 92) {
                this.add("\\\\");
            } else if(c == 47) {
                this.add("\\/");
            } else if(c == 8) {
                this.add("\\b");
            } else if(c == 12) {
                this.add("\\f");
            } else if(c == 10) {
                this.add("\\n");
            } else if(c == 13) {
                this.add("\\r");
            } else if(c == 9) {
                this.add("\\t");
            } else if(Character.isISOControl(c)) {
                this.unicode(c);
            } else {
                this.add(c);
            }
        }

        this.add('\"');
    }

    private void add(Object obj) {
        this.buf.append(obj);
    }

    private void add(char c) {
        this.buf.append(c);
    }

    private void unicode(char c) {
        this.add("\\u");
        int n = c;

        for(int i = 0; i < 4; ++i) {
            int digit = (n & '\uf000') >> 12;
            this.add(hex[digit]);
            n <<= 4;
        }

    }
}

