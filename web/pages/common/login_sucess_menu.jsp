<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/12/28
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临hasaki书城</span>
    <a href="orderServlet?action=showMyOrders">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="javascript:history.back()">返回</a>
</div>
