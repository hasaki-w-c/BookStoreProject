package com.hasaki_w_c.dao.impl;

import com.hasaki_w_c.dao.OrderDao;
import com.hasaki_w_c.pojo.Order;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 18:58
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`orderId`,`createTime`,`price`,`status`,`userId`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrder() {
        String sql = "select `orderId`,`createTime`,`price`,`status`,`userId` from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set `status` = ? where `orderId` = ?";
        return update(sql, status,orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select * from t_order where `userId` = ?";
        return queryForList(Order.class,sql,userId);
    }
}
