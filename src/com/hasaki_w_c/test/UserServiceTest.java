package com.hasaki_w_c.test;

import com.hasaki_w_c.pojo.User;
import com.hasaki_w_c.service.UserService;
import com.hasaki_w_c.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/24 18:48
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"李四","123456","654321@qq.com"));
        userService.registerUser(new User(null,"王五","123456","123321@qq.com"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null,"李四","123456","null")));

    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("张三")) {
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用");
        }
    }
}