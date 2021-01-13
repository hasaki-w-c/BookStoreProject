package com.hasaki_w_c.test;

import com.hasaki_w_c.dao.OrderItemDao;
import com.hasaki_w_c.dao.impl.OrderItemDaoImpl;
import com.hasaki_w_c.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 21:36
 */
public class OrderItemDaoTest {

    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"无缝E教程",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"光速QA教程",2,new BigDecimal(100),new BigDecimal(200),"1234567890"));
    }

    @Test
    public void queryOrderItemByOrderId() {
        System.out.println(orderItemDao.queryOrderItemByOrderId("1234567890"));
    }
}