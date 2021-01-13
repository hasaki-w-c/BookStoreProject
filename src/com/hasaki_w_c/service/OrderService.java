package com.hasaki_w_c.service;

import com.hasaki_w_c.pojo.Cart;
import com.hasaki_w_c.pojo.Order;
import com.hasaki_w_c.pojo.OrderItem;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 21:48
 */
public interface OrderService {
    /**
     * 生成订单
     * @param cart 购物车对象
     * @param userId 用户编号
     * @return 订单号
     */
    String createOrder(Cart cart, Integer userId);

    /**
     * 查询全部订单
     * @return 订单列表
     */
    List<Order> showAllOrders();

    /**
     * 发货（修改订单 status 值）
     * @param orderId 订单编号
     */
    void sendOrder(String orderId);

    /**
     * 查看订单详情
     * @param orderId 订单编号
     * @return 订单项列表
     */
    List<OrderItem> showOrderDetail(String orderId);

    /**
     * 查看我的订单
     * @param userId 用户标号
     * @return 订单列表
     */
    List<Order> showMyOrders(Integer userId);

    /**
     * 签收订单/确认收获
     * @param orderId 用户编号
     */
    void receiverOrder(String orderId);
}
