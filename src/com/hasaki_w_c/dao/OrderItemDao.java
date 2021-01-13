package com.hasaki_w_c.dao;

import com.hasaki_w_c.pojo.OrderItem;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 18:56
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem 订单项对象
     * @return 受影响的行数
     */
    int saveOrderItem(OrderItem orderItem);

    /***
     * 根据订单号查询订单
     * @param orderId 订单号
     * @return 订单列表
     */
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
