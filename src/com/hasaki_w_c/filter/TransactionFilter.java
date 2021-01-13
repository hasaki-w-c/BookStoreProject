package com.hasaki_w_c.filter;

import com.hasaki_w_c.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/1/9 14:53
 */
@WebFilter("/*")
public class TransactionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req,resp);
            //提交事务
            JDBCUtils.commitAndClose();
        } catch (IOException | ServletException e) {
            //回滚事务
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            //把异常抛给 Tomcat 服务器，管理展示友好的错误页面
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
