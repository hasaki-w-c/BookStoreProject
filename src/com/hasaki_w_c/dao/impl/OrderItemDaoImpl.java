package com.hasaki_w_c.dao.impl;

import com.hasaki_w_c.dao.OrderItemDao;
import com.hasaki_w_c.pojo.OrderItem;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 19:56
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`totalPrice`,`orderId`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select * from t_order_item where orderId=?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
