package com.hasaki_w_c.web;

import com.google.gson.Gson;
import com.hasaki_w_c.pojo.User;
import com.hasaki_w_c.service.UserService;
import com.hasaki_w_c.service.impl.UserServiceImpl;
import com.hasaki_w_c.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/29 16:53
 */
@WebServlet("/userServlet")
public class  UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 处理登陆的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于 null,说明登录 失败!
        if (loginUser == null) {
            // 把错误的信息，和回显的表单项信息，保存到 Request 域中
            req.setAttribute("msg", "用户名或密码错误!");
            req.setAttribute("username", username);
            // 跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 登录 成功
            // 保存用户登陆后的信息到 Session 域中
            req.getSession().setAttribute("user", loginUser);
            //跳到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 Session 中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session 中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        // 2、检查 验证码是否正确 === 写死,要求验证码为:abcde
        if (token != null || token.equalsIgnoreCase(code)) {
            // 3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                // 把回显信息保存在 Request 域中
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                // 跳回注册页面
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
                // 可用
                // 调用 Service 保存到数据库
                userService.registerUser(new User(null, username, password, email));
                // 保存用户登陆后的信息到 Session 域中
                req.getSession().setAttribute("user", username);
                //跳到成功页面 login_success.jsp
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息保存在 Request 域中
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //调用 userService.existsUsername()
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成为 Map 对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }
    /**
     * 注销用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
        // 2、跳回登陆界面
        req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

    }
}