<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缴费信息添加</title>
		<style>
		body{
			width: 1440px;
			height: 746px;
			margin: auto;
		}
       #a{
			background-color: #ECFFFF;
			height: 635px;
			width: 1140px;
			position: absolute;
			top: 99px;
			left: 300px;
		}
		#b{
			font-size: 22px;
			position: absolute;
			top: 80px;
			left: 87px;
		}
		#c{
			position: absolute;
			top: 179px;
			left: 87px;
		}
		#d{
			position: absolute;
			top:250px ;
			left: 87px;
		}
		#e{
			position: absolute;
			top: 316px;
			left: 87px;
		}
		#f{
			position: absolute;
			top: 389px;
			left: 87px;
		}
		#g{
			position: absolute;
			top: 464px;
			left: 87px;
		}
		#h{
			position: absolute;
			top:539px ;
			left: 187px;
		}
		#i{
			position: absolute;
			top: 617px;
			left: 187px;
		}
		#j{
			position: absolute;
			top:746px ;
			left: 179px;
			background-color: #00BFFF;
			opacity: 0.8;
			border-radius: 0px;
			border-width: 0px;
			width: 152px;
			height: 50px;
			font-size: 28px;


		}
		#B{
			position: absolute;
			left: 87px;
			top: 145px;
			width: 160px;
		}
		#C
		{
			position: absolute;
			left: 87px;
			top:220px ;
			width: 160px;
		}
		#D{
			position: absolute;
			left: 87px;
			top:295px ;
			width: 160px;
		}
		#E{
			position: absolute;
			left: 87px;
			top: 370px;
			width: 160px;
		}
		#F{
			position: absolute;
			left: 87px;
			top: 445px;
			width: 160px;
		}
		#G{
			position: absolute;
			left: 87px;
			top: 520px;
			width: 160px;
		}
		#H{
			position: absolute;
			left: 168px;
			top:595px;
		}
		#I{
			position: absolute;
			left: 168px;
			top:670px;
		}

		a{
			text-decoration: none;
			font-size: 20px;
			color:#000000;

		}
			.g{
				position: absolute;
				top: 721px;
				left: 0px;
				width:1400px;
				height: 160px;

			}
			hr{
				width: 460px;
				position: absolute;
			}
			#A{
				width: 1400px;
				position: absolute;
				top: 76px;
				height: 1px;
			}
			#k{
				position: absolute;
				top: 5px;
				left: 8px;
			}
			td{
				border: 1px solid #000000;
				height: 56px;
			}
			table{
				border: 1px solid #000000;
				border-spacing: 0px;
				text-align: center;
				opacity: 0.7;
				font-size: 20px;
			}
			button{
				height: 40px;
				width: 100px;
				border-radius: 5px;
				font-size: 18px;
				border: 1px solid #000000;
			}
			button:hover{
				background-color: #D0FFFF;
			}
			.A{
			font-size: 13px;
			color: #999999;

			border: 1px solid gray;
			height: 30px;
			width: 300px;
		}

		</style>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function addPayment() {
		var ctx = "${ctx}"
		$.ajax({
			type : "POST",
			url : ctx + "/pAdd.do",
			data : $("form").serialize(),
			success : function(msg) {
				if (msg == '0000') {
					alert("缴费信息新增成功");
				} else {
					alert("缴费信息新增失败");
				}
			}
		});
	}

	function mdPayment(){
	var ctx = "${ctx}"
		$.ajax({
			type : "POST",
			url : ctx + "/pMode.do",
			data : $("form").serialize(),
			success : function(msg) {
				if (msg == '0000') {
					alert("缴费信息修改成功");
				} else {
					alert("缴费信息修改失败");
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
		
		<!--<hr id="A"/>-->
		<div style="height: 635px;width: 300px;position: absolute;top: 99px; background-color:#F7FFFF ;opacity: 0.8;">
				<p id="b">${sessionScope.userInfo.userName}管理员<hr id="B"/></p>
				<p id="c"><a  href="${ctx}/listOwner.do">住户资料管理<hr id="C"/></a> </p>
				<p id="d"> <a  href="${ctx}/listComplainer.do">投诉管理<hr id="D"/></a> </p>
				<p id="e"><a  href="${ctx}/listRepair.do">维修管理<hr id="E"/></a> </p>
				<p id="f"> <a  href="${ctx}/listPayment.do">缴费管理<hr id="F"/></a> </p>
				<p id="g"><a  href="${ctx}/toResetPwd.do">修改密码<hr id="G" /></a> </p>


				<!--<button id="j">退出登录</button>-->

		</div >
		<div id="a">
			<form>



			<p style="position: absolute;top: 52px;left: 200px;font-size: 28px;">业主编号：</p>
			<p style="position: absolute;top: 132px;left: 200px;font-size: 28px;"> 业主姓名：</p>
			<p style="position: absolute;top: 212px;left: 200px;font-size: 28px;">缴费项目：</p>
			<p style="position: absolute;top: 292px;left: 200px;font-size: 28px;">缴纳费用：</p>
			<p style="position: absolute;top: 372px;left: 200px;font-size: 28px;">未缴纳费用：</p>
			<input type="text" style="height: 24px;width: 500px;position: absolute;top: 84px;left: 340px;" name="paymentOwnerNo" value="${payment.paymentOwnerNo}"/>
			<input type="text" style="height: 24px;width: 500px;position: absolute;top: 164px;left: 340px;" name="paymentOwnerName" value="${payment.paymentOwnerName}"/>
			<input type="text" style="height: 24px;width: 500px;position: absolute;top: 244px;left: 340px;" name="paymentCategory" value="${payment.paymentCategory}"/>
			<input type="text" style="height: 24px;width: 500px;position: absolute;top: 324px;left: 340px;" name="paymentFee" value="${payment.paymentFee}"/>
			<input type="text" style="height: 24px;width: 480px;position: absolute;top: 404px;left: 360px;" name="paymentContent" value="${payment.paymentContent}"/>

			<c:if test="${m=='1'}">
			<input type="hidden" value="${payment.id}" name="id"/>
			<button type="button" onclick="mdPayment();" style="height: 28px;width: 90px;position: absolute;top: 500px;left: 520px;">
			确定修改</button></c:if>
			<c:if test="${m!=1}"><button type="button" onclick="addPayment();" style="height: 28px;width: 70px;position: absolute;top: 500px;left: 550px;">确定</button></c:if>


			</form>
		</div>
	</body>
</html>