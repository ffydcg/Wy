<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
		<style>
		body{
			width: 1440px;
			height: 730px;
			margin: auto;
			background-color: #ECFFFF;
		}
		
		#a{
				position: absolute;
				top: 24px;
				right: 0px;
				width: 800px;
				height: 86px;
			}
		.a{
			text-decoration: none;
			color: #999999;
			font-size: 32px;
			margin: 50px;

		}
		.A{
			font-size: 13px;
			color: #999999;
			position: absolute;
			left: 338px;
			border: 1px solid gray;
			height: 40px;
			width: 350px;
		}
		.c{
			font-size: 16px;
			position: absolute;
			left: 204px;
			color: gray;
		}
		button{
			position: absolute;
			top: 430px;
			left: 430px;
			width: 120px;
			height: 50px;
			font-size: 16px;
			background-color: #808080;
			font-weight: bold;

		}
		button:hover{
			background-color: #999999;
		}
		

		</style>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.md5.js"></script>
<script type="text/javascript">
	function restPwd() {
		var userName = $("#userName").val();
		var passwdO = $("#passwdO").val();
		var passwdN = $("#passwdN").val();
		var passwdN1 = $("#passwdN1").val();
		if (passwdN != passwdN1) {
			alert("新密码与确认密码不同");
			return;
		}
		if (passwdO == "" || passwdN == "" || passwdN1 == "") {
			alert("密码不能为空");
			return;
		}
		var ctx = "${ctx}";
		$.ajax({
			type : "POST",
			url : ctx + "/resetPwd.do",
			data : {
				userName : userName,
				password : $.md5(passwdO),
				passwdN : $.md5(passwdN1)
			},
			success : function(msg) {
				if (msg == '0000') {
					alert("密码修改成功");
				} else {
					alert("原始密码不正确");
				}
			}
		});
	}
</script>
</head>
	<body>
		
		<div style="background-color: lightblue">
			<p style="font-size: 42px;font-weight: bold;margin:auto;height: 100px;width: 1440px;">物业管理系统</p>
			<a href="${ctx}/logout.do" style="position: absolute;top: 48px;left: 1300px;font-size: 24px;width: 100px;">退出登录</a>
		</div>
		<!--<img src="../img/top.png" style="width: 1920px;height: 86px;" />-->
		<!--<img src="../img/solo.png" style="position: absolute;top: 18px;left: 54px;width: 106px;height: 51px;" />-->
		<div style="background-color: #BBDDFF;;position: absolute;top:100px;left: 300px;width: 910px;height: 480px;">

			<input style="position: absolute;top: 100px;color: #000000;" class="A"  type="password" name="passwdO" id="passwdO"/>
			<input style="position: absolute;top: 180px;color: #000000;" class="A"  type="password"  name="passwdN" id="passwdN"/>
			<input style="position: absolute;top: 260px;color:#000000;" class="A" type="password" name="passwdN1" id="passwdN1"/>
			<input type="hidden" name="userName" id="userName" value="${sessionScope.userInfo.userName}"/>
			<button type="button" onclick="restPwd()" style="height: 28px;width: 70px; font-size: 12px;color: #000000; position: absolute;top: 390px;left: 390px;">保存修改</button>
			<p class="c" style="position: absolute;top: 140px;color: #000000;">原始密码:</p>
			<p class="c" style="position: absolute;top: 220px;color: #000000;">新密码:</p>
			<p class="c" style="position: absolute;top: 300px;color: #000000;">确认密码:</p>

		</div>
			<a href="${ctx}/listOwner.do" style="color: #999999; position: absolute;top: 110px;left: 1240px;font-size: 36px;">返回</a>

	</body>
</html>