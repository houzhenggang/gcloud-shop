package com.gcloud.shop.api.internal.parser.xml;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.internal.mapping.Converter;
import com.gcloud.shop.api.internal.mapping.Converters;
import com.gcloud.shop.api.internal.mapping.Reader;
import com.gcloud.shop.api.response.GcloudResponse;
import com.gcloud.shop.api.utils.XmlUtils;
import org.w3c.dom.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: XmlConverter
 * @Package com.gcloud.shop.api.internal.parser.xml
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 14:11
 */
public class XmlConverter implements Converter {
    
    public XmlConverter() {
    }

    public <T extends GcloudResponse> T toResponse(String rsp, Class<T> clazz) throws GcloudException {
        Element root = XmlUtils.getRootElementFromString(rsp);
        return (T)this.getModelFromXML(root, clazz);
    }

    private <T> T getModelFromXML(final Element element, Class<T> clazz) throws GcloudException {
        return element == null?null: Converters.convert(clazz, new Reader() {
            public boolean hasReturnField(Object name) {
                Element childE = XmlUtils.getChildElement(element, (String)name);
                return childE != null;
            }

            public Object getPrimitiveObject(Object name) {
                return XmlUtils.getChildElementValue(element, (String)name);
            }

            public Object getObject(Object name, Class<?> type) throws GcloudException {
                Element childE = XmlUtils.getChildElement(element, (String)name);
                return childE != null?XmlConverter.this.getModelFromXML(childE, type):null;
            }

            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType) throws GcloudException {
                ArrayList list = null;
                Element listE = XmlUtils.getChildElement(element, (String)listName);
                if(listE != null) {
                    list = new ArrayList();
                    List itemEs = XmlUtils.getChildElements(listE, (String)itemName);
                    Iterator i$ = itemEs.iterator();

                    while(i$.hasNext()) {
                        Element itemE = (Element)i$.next();
                        Object obj = null;
                        String value = XmlUtils.getElementValue(itemE);
                        if(String.class.isAssignableFrom(subType)) {
                            obj = value;
                        } else if(Long.class.isAssignableFrom(subType)) {
                            obj = Long.valueOf(value);
                        } else if(Integer.class.isAssignableFrom(subType)) {
                            obj = Integer.valueOf(value);
                        } else if(Boolean.class.isAssignableFrom(subType)) {
                            obj = Boolean.valueOf(value);
                        } else if(Date.class.isAssignableFrom(subType)) {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                            try {
                                obj = format.parse(value);
                            } catch (ParseException var13) {
                                throw new GcloudException(var13);
                            }
                        } else {
                            obj = XmlConverter.this.getModelFromXML(itemE, subType);
                        }

                        if(obj != null) {
                            list.add(obj);
                        }
                    }
                }

                return list;
            }
        });
    }
}
