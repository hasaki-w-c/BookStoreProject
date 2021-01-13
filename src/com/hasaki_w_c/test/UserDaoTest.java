package com.hasaki_w_c.test;

import com.hasaki_w_c.dao.UserDao;
import com.hasaki_w_c.dao.impl.UserDaoImpl;
import com.hasaki_w_c.pojo.User;
import org.junit.Test;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/24 16:54
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if ( userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassWord() {
        if (userDao.queryUserByUsernameAndPassWord("admin","admin") == null) {
            System.out.println("登陆失败！用户名或密码错误！");
        }else {
            System.out.println("登陆成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"张三","123456","123456@qq.com")));
    }
}