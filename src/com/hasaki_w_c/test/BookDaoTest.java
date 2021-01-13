package com.hasaki_w_c.test;

import com.hasaki_w_c.dao.BookDao;
import com.hasaki_w_c.dao.impl.BookDaoImpl;
import com.hasaki_w_c.pojo.Book;
import com.hasaki_w_c.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 20:07
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"亚索是怎样练成的","hasaki",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"无缝E教程","hasaki",new BigDecimal(9999),1100000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDao.queryForPageItems(0, 4)) {
            System.out.println(queryForPageItem);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book queryForPageItemByPrice : bookDao.queryForPageItemsByPrice(1, Page.PAGE_SIZE,10,50)) {
            System.out.println(queryForPageItemByPrice);
        }
    }
}