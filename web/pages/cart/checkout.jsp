<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>

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
			<span class="wel_word">结算</span>

		<%-- 静态包含，登陆成功后的菜单 --%>
		<%@include file="/pages/common/login_sucess_menu.jsp"%>

	</div>

	<div id="main">

		<h1>您的订单已结算，订单号为:${sessionScope.orderId}</h1>


	</div>

	<%-- 静态包含页脚内容 --%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>