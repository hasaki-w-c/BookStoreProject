<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

	<%-- 静态包含 css样式、jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//给 发货 绑定单击事件
			$("a.receiver").click(function () {
				return confirm("您确定要签收吗？")
			})
		})
	</script>

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
			<span class="wel_word">我的订单</span>

		<div>
			<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临hasaki书城</span>
			<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
			<a href="../../index.jsp">返回</a>
		</div>

	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.myOrders}" var="order">
				<tr>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<td>
						<c:if test="${order.status == 0}">
							未发货
						</c:if>
						<c:if test="${order.status == 1}">
							已发货<br><a class="receiver" href="orderServlet?action=receiverOrder&orderId=${order.orderId}">点击签收</a>
						</c:if>
						<c:if test="${order.status == 2}">
							已签收
						</c:if>
					</td>
					<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
				</tr>
			</c:forEach>


		</table>
		
	
	</div>

	<%-- 静态包含页脚内容 --%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>