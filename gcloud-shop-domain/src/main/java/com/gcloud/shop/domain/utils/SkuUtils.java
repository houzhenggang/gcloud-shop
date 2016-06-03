package com.gcloud.shop.domain.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * SKU 处理工具类
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class SkuUtils {

  final static Logger logger = LogManager.getLogger(SkuUtils.class);

  public static String[] formatProprotyNameArray(String propertiesName){
    if (StringUtils.isEmpty(propertiesName)) return  new String[]{};

    String[] wapper= StringUtils.split(propertiesName, ";");
    for (int i = 0; i <wapper.length ; i++) {
      String element=wapper[i];
      String[] _element=StringUtils.split(element, ":");
      if (_element.length==0) return new String[]{};
      else if (_element.length==2) element=_element[1];
      else{
        List<String> newElement=new LinkedList<String>();
        int left=_element.length/2;
        newElement.addAll(Arrays.asList(_element).subList(left, _element.length));
        element=StringUtils.join(newElement,":");
      }
      wapper[i]=element;
    }
    return wapper;
  }

  public static Map<String,String> formatProprotyNameDict(String propertiesName){
    Map<String,String> dictMap=new HashMap<String, String>();

    if (StringUtils.isEmpty(propertiesName)) return  dictMap;

    String[] wapper= StringUtils.split(propertiesName, ";");
    for (String _wapper : wapper) {
      String[] _element=StringUtils.split(_wapper, ":");
      if (_element.length==0) return dictMap;
      else if (_element.length==2) dictMap.put("other",_element[1]);
      else{
        List<String> newElement=new LinkedList<String>();
        int left=_element.length/2;
        newElement.addAll(Arrays.asList(_element).subList(left, _element.length));

        if (newElement.size()==2){
          dictMap.put(newElement.get(0),newElement.get(1));
        }else if (newElement.size()==1){
          dictMap.put("other",newElement.get(0));
        }
      }
    }
    return dictMap;
  }

  public static String formatProprotyName(String propertiesName,String spilit){
    return StringUtils.join(formatProprotyNameArray(propertiesName),spilit);
  }

}
