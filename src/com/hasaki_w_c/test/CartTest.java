package com.hasaki_w_c.test;

import com.hasaki_w_c.pojo.Cart;
import com.hasaki_w_c.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/4 19:12
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"无缝E教程",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到入土",1,new BigDecimal(200),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"无缝E教程",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"无缝E教程",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"无缝E教程",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"无缝E教程",1,new BigDecimal(100),new BigDecimal(100)));

        cart.deleteItem(1);

        cart.clear();

        cart.addItem(new CartItem(1,"无缝E教程",1,new BigDecimal(1000),new BigDecimal(1000)));

        cart.updateCount(1,10);

        System.out.println(cart);
    }
}