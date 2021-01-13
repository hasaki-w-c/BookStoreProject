package com.hasaki_w_c.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 18:40
 */
public class WebUtils {

    /**
     * 把 Map 中的值注入到对应的 JavaBean 属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            //System.out.println("注入之前：" + bean);
            // 把所有请求的参数都注入到 user 对象中
            BeanUtils.populate(bean,value);
            //System.out.println("注入之后：" + bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为 int 类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return  defaultValue;
    }

}
