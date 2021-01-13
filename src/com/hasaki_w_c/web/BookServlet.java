package com.hasaki_w_c.web;

import com.hasaki_w_c.pojo.Book;
import com.hasaki_w_c.pojo.Page;
import com.hasaki_w_c.service.BookService;
import com.hasaki_w_c.service.impl.BookServiceImpl;
import com.hasaki_w_c.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 20:52
 */
@WebServlet("/manage/bookServlet")
public class BookServlet extends BaseServlet {

    private final BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2.调用 BookService.page(pageNo, pageSize) : 返回 page 对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("manage/bookServlet?action=page");

        // 3.保存 page 对象到 Request 域中
        request.setAttribute("page",page);
        // 4.请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    /**
     * 添加图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),0);
        pageNo += 1;
        // 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());
        // 2、调用 BookService.addBook()保存图书
        bookService.addBook(book);
        // 3、跳到图书列表页面 /manage/bookServlet?action=list
        // req.getRequestDispatcher("/manage/bookServlet?action=list").forward(req, resp); 此行代码会有 Bug，按 F5会有重复提交的Bug
        response.sendRedirect(request.getContextPath() + "/manage/bookServlet?action=page&action=page&pageNo=" + pageNo);
    }

    /**
     * 删除图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求的参数 id，图书编程
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 2、调用 bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        // 3、重定向回图书列表管理页面
        // /book/manage/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/manage/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());
        // 2、调用 BookService.updateBook( book );修改图书
        bookService.updateBook(book);
        // 3、重定向回图书列表管理页面
        // 地址：/工程名/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/manage/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 获取要修改图书的信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2 调用 bookService.queryBookById 查询图书
        Book book = bookService.queryBookById(id);
        //3 保存到图书到 Request 域中
        request.setAttribute("book", book) ;
        //4 请求转发到。pages/manager/book_edit.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    /**
     * 展示图书列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过 BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到 Request 域中
        request.setAttribute("books", books);
        //3.请求转发到 /pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

}
