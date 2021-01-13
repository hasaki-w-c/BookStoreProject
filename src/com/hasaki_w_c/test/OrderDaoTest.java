package com.hasaki_w_c.test;

import com.hasaki_w_c.dao.OrderDao;
import com.hasaki_w_c.dao.impl.OrderDaoImpl;
import com.hasaki_w_c.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/5 20:02
 */
public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        //orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));
        //orderDao.saveOrder(new Order("0987654321",new Date(),new BigDecimal(150),0,1));
        orderDao.saveOrder(new Order("1122334455",new Date(),new BigDecimal(200),0,3));
    }

    @Test
    public void queryOrder() {
        for (Order queryOrder : orderDao.queryOrder()) {
            System.out.println(queryOrder);
        }
    }

    @Test
    public void changeOrderStatus() {
        System.out.println(orderDao.changeOrderStatus("1234567890",1));
    }

    @Test
    public void queryOrderByUserId() {
        System.out.println(orderDao.queryOrderByUserId(1));
    }
}