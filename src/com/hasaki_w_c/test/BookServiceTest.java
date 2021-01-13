package com.hasaki_w_c.test;

import com.hasaki_w_c.pojo.Book;
import com.hasaki_w_c.pojo.Page;
import com.hasaki_w_c.service.BookService;
import com.hasaki_w_c.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 20:23
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"瑞文教程","瑞文",new BigDecimal(10000),10000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"光速QA教程","瑞文",new BigDecimal(10000),10,111110,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,Page.PAGE_SIZE,10,50));
    }
}