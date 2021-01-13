package com.hasaki_w_c.service;

import com.hasaki_w_c.pojo.User;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/24 17:18
 */
public interface UserService {

    /**
     * 注册用户
     * @param user 用户对象
     */
    void registerUser(User user);

    /**
     * 登陆
     * @param user 用户对象
     * @return 如果返回 null, 说明登陆失败，返回有值，是登陆成功
     */
    User login(User user);

    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return 返回 true 表示用户名已存在，返回 false 表示用户名可用
     */
    boolean existsUsername(String username);
}
