<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.md5.js"></script>
<script type="text/javascript">
		function submit_form(){
	    var user_name=$("#userName").val();
	    var password=$("#password1").val();
		if(user_name==""||password==""){
		alert("用户名或密码不能为空");
		return;
		}
		$("#password").val($.md5(password));
		$("form").submit();
		}
		</script>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style>
body {
	height: 763px;
	width: 1440px;
	margin: auto;
}

div.a {
	position: absolute;
	top: 120px;
	left: 480px;
	background-color: #BBDDFF;
	height: 500px;
	width: 480px;
	opacity: 0.8;
}

.b {
	height: 40px;
	width: 365px;
	border: 1px solid #000000;
	position: absolute;
	left:610px;
	background-color: white;
}

button {
	position: absolute;
	top: 564px;
	left: 623px;
	height: 35px;
	width: 100px;
	background-color: #999999;
	border: 1px solid #000000;
	border-radius: 5px;
}

button:hover {
	background-color: #BBDDFF;
}
</style>
</head>
<body>
	<div style="background-color:rgb(53,136,198);">
		<p style="font-size: 44px;margin:auto;color: lightblue;">欢迎登录后台管理界面平台</p>
	</div>

	<!--<img src="../img/solo.png" style="position: absolute;top: 18px;left: 54px;width: 106px;height: 51px;" />-->
	<img src="./image/copywrite.png"
		style="position: absolute;top:  640px;width: 1440px;height: 128px;" />

	<img src="./image/img1.png"
		style="top: 86px;height: 604px;width: 1440px; " />
	<div class="a"></div>
	<form action="${ctx}/login.do" name="user">
		<input class="b" name="userName" id="userName"
			style="position: absolute;top: 348px;width: 210px;" type="text" placeholder="" />
		<input class="b" name="password1" id="password1"
			style="position: absolute;top: 415px;width: 210px;" type="password" />
			<input name="password" type="hidden" id="password">
		<button onclick="submit_form()" type="button" style="font-size: 20px;">
			登录</button>
		<p style="color: red;position: absolute;top: 578px;right:450px">${errMsg}</p>
		<p
			style="font-size: 28px; position: absolute;top: 180px;left: 592px;">小区物业管理系统</p>
		<p
			style="font-size: 20px; position: absolute;top: 280px;left: 542px;">管理员登录</p>
		<p
			style="font-size: 20px; position: absolute;top: 334px;left: 542px;">用户名</p>
		<p style="font-size: 20px; position: absolute;top: 402px;left: 558px;">密码</p>
		<!--<p style="font-size: 28px; position: absolute;top: 520px;left: 1142px;">éªè¯ç </p>-->
		<!--<img src="../img/yanxhen5.png" style="position: absolute;top: 527px;left: 1443px;height: 60px;width: 130px;" />-->
	</form>
</body>
</html>
