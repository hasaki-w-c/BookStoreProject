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

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/1 22:11
 */
@WebServlet("/client/bookServlet")
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

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

        page.setUrl("client/bookServlet?action=page");

        // 3.保存 page 对象到 Request 域中
        request.setAttribute("page",page);
        // 4.请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    /**
     * 根据价格分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);


        // 2.调用 BookService.pageByPrice(pageNo, pageSize, min, max) : 返回 page 对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        // 如果有最小价格的参数，追加到分页条的地址参数中
        if (request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }
        // 如果有最大价格的参数，追加到分页条的地址参数中
        if (request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(sb.toString());

        // 3.保存 page 对象到 Request 域中
        request.setAttribute("page",page);
        // 4.请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
