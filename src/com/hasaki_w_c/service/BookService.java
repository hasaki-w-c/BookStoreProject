package com.hasaki_w_c.service;

import com.hasaki_w_c.pojo.Book;
import com.hasaki_w_c.pojo.Page;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 20:18
 */
public interface BookService {
    /**
     * 添加
     * @param book 图书对象
     */
    void addBook(Book book);

    /**
     * 删除
     * @param id 图书编号
     */
    void deleteBookById(Integer id);

    /**
     * 修改
     * @param book 图书对象
     */
    void updateBook(Book book);

    /**
     * 查询单条
     * @param id 图书编号
     * @return 图书信息
     */
    Book queryBookById(Integer id);

    /**
     * 查询多条
     * @return 图书列表
     */
    List<Book> queryBooks();

    /**
     * 得到分页对象
     * @param pageNo 当前页
     * @param pageSize 当前页显示的数量
     * @return 图书分页页面
     */
    Page<Book> page(int pageNo, int pageSize);

    /**
     * 通过价钱分页
     * @param pageNo 页码
     * @param pageSize 当前页码数据量
     * @param min 最小价格
     * @param max 最大价格
     * @return 图书分页页面
     */
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
