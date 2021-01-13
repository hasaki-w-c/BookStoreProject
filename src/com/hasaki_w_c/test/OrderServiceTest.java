package com.hasaki_w_c.test;

import com.hasaki_w_c.pojo.Cart;
import com.hasaki_w_c.pojo.CartItem;
import com.hasaki_w_c.service.OrderService;
import com.hasaki_w_c.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 22:27
 */
public class OrderServiceTest {

    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"无缝E教程",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(200),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"无缝E教程",1,new BigDecimal(100),new BigDecimal(100)));

        System.out.println("订单号是：" + orderService.createOrder(cart,1));
    }

    @Test
    public void showAllOrders() {
        System.out.println(orderService.showAllOrders());
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("16100890822511");
    }

    @Test
    public void showOrderDetail() {
        System.out.println(orderService.showOrderDetail("16098572948421"));
    }

    @Test
    public void showMyOrders() {
        System.out.println(orderService.showMyOrders(1));
    }

    @Test
    public void receiverOrder() {
        orderService.receiverOrder("16098572948421");
    }
}