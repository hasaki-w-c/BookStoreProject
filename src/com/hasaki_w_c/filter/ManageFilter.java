package com.hasaki_w_c.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/7 20:20
 */
@WebFilter({"/pages/manager/*", "/manage/bookServlet"})

public class ManageFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        Object user = httpServletRequest.getSession().getAttribute("user");

        if (user == null) {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config){

    }

}
