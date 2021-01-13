package com.hasaki_w_c.service.impl;

import com.hasaki_w_c.dao.UserDao;
import com.hasaki_w_c.dao.impl.UserDaoImpl;
import com.hasaki_w_c.pojo.User;
import com.hasaki_w_c.service.UserService;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/24 17:24
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassWord(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            //等于 null ，说明没查到，没查到表示可用
            return false;
        }else {
            return true;
        }
    }
}
