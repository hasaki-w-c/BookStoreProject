package com.hasaki_w_c.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 18:13
 */
public class UserServletTest {
    public void login() {
        System.out.println("这是 login 方法调用");
    }
    public void register() {
        System.out.println("这是 register 方法调用");
    }
    public void updateUser() {
        System.out.println("这是 updateUser 方法调用");
    }
    public void updateUserPassword() {
        System.out.println("这是 updateUserPassword 方法调用");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            // 获取 action 业务鉴别字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);

            //调用目标业务方法
            method.invoke(new UserServletTest());

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
