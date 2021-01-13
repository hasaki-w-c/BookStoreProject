<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>

	<%-- 静态包含 css样式、jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.jpg" >
			<span class="wel_word">订单详情</span>

		<div>
			<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临hasaki书城</span>
			<a href="orderServlet?action=showMyOrders">我的订单</a>
			<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
			<a href="../../index.jsp">返回</a>
		</div>

	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>商品单价</td>
				<td>商品总金额</td>
			</tr>
			<c:forEach items="${requestScope.orderItems}" var="orderItem">
				<tr>
					<td>${orderItem.orderId}</td>
					<td>${orderItem.name}</td>
					<td>${orderItem.count}</td>
					<td>${orderItem.price}</td>
					<td>${orderItem.totalPrice}</td>
				</tr>
			</c:forEach>

		</table>
		
	
	</div>

	<%-- 静态包含页脚内容 --%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>