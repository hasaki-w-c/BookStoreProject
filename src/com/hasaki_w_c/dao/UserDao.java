package com.hasaki_w_c.dao;

import com.hasaki_w_c.pojo.User;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/24 16:37
 */
public interface UserDao {



    /**
     * 根据 用户名查询用户信息
     * @param username 用户名
     * @return 如果返回 null ，说明没有这个用户，反之，则有
     */
    User queryUserByUsername(String username);

    /**
     * 根据 用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回 null ，说明用户名或密码错误，反之亦然
     */
    User queryUserByUsernameAndPassWord(String username, String password);

    /**
     * 保存 用户信息
     * @param user 用户
     * @return 返回 -1 表示操作失败，其他是 sql 语句影响的行数
     */
    int saveUser(User user);
}
