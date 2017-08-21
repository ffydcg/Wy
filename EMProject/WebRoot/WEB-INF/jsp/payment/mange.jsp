<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>缴费管理</title>
		<style>
		body{
			width: 1440px;
			height: 746px;
			margin: auto;
		}
		#a{
			background-color: #ECFFFF;
			height: 671px;
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
			left: 87px;
		}
		#i{
			position: absolute;
			top: 617px;
			left: 87px;
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
			left: 87px;
			top:595px;
			width: 160px;
		}
		#I{
			position: absolute;
			left: 87px;
			top:670px;
			width: 160px;
		}

		a{
			text-decoration: none;
			font-size: 20px;
			color:#000000;
			cursor: pointer;

		}
			.g{
				position: absolute;
				top: 921px;
				left: 0px;
				width:1440px;
				height: 160px;

			}
			hr{
				width: 460px;
				position: absolute;
			}
			#A{
				width: 1440px;
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
	var ctx = "${ctx}";
	function modify(id) {
		window.location.href = ctx + "/toPaymentMdf.do?id=" + id;
	}
	function del(id) {
		var ctx = "${ctx}"
		$.ajax({
			type : "POST",
			url : ctx + "/delP.do",
			data : {id:id},
			success : function(msg) {
				if (msg == '0000') {
					alert("缴费信息删除成功");
					window.location.href = ctx +"/listPayment.do";
				} else {
					alert("缴费信息删除失败");
					window.location.href = ctx +"/listPayment.do";
				}
			}
		});

	}
	function showPages(num){
	window.location.href = ctx + "/listPaymentByNum.do?num=" + num;
	}
	function queryInfo(){
	var name=$("#queryName").val().trim();
	var url=ctx +"/queryPaymentByName.do?name="+name;  //queryPaymentByName
	var url1=encodeURI(url);
	window.location.href = url;
	}
</script>
</head>
	<body>
		<div style="background-color: lightblue">
			<p style="font-size: 42px;font-weight: bold;margin:auto;height: 100px;width: 1440px;">物业管理系统</p>
			<a href="${ctx}/logout.do" style="position: absolute;top: 48px;left: 1300px;font-size: 24px;width: 100px;">退出登录</a>
		</div>
		
		<!--<hr id="A"/>-->
		<div style="height: 665px;width: 300px;position: absolute;top: 100px; background-color:#F7FFFF ;opacity: 0.8;">
				<p id="b">${sessionScope.userInfo.userName}管理员<hr id="B"/></p>
				<p id="c"><a  href="${ctx}/listOwner.do">住户资料管理<hr id="C"/></a> </p>
				<p id="d"> <a  href="${ctx}/listComplainer.do">投诉管理<hr id="D"/></a> </p>
				<p id="e"><a  href="${ctx}/listRepair.do">维修管理<hr id="E"/></a> </p>
				<p id="f"> <a  href="${ctx}/listPayment.do">缴费管理<hr id="F"/></a> </p>
				<p id="g"><a  href="${ctx}/toResetPwd.do">修改密码<hr id="G" /></a> </p>


				<!--<button id="j">éåºç»å½</button>-->

		</div >
		<div id="a">
			<table style="position: absolute;top: 139px;left: 150px;">
				<p style="position: absolute;top: 10px;left: 160px;font-size: 24px;color: #000000;">业主查询：</p>
				<input type="text" style="position: absolute;top: 30px;left: 280px;width: 350px;" class="A" name="ownerName" id="queryName"/>
				<button type="submit" style="position: absolute;top: 30px;left: 660px;height: 32px;width: 70px;" onclick="queryInfo();" >查询</button>
				<caption style="font-size: 24px;color: #000000;position: absolute;top: -60px;left: 4px;">缴费列表:</caption>
				<thead>
			         	
					<td style="width: 100px;">业主编号</td>
					<td style="width: 150px;">业主姓名</td>
					<td style="width: 140px;">缴费项目</td>
					<td style="width: 150px;">缴纳费用</td>
					<td style="width: 150px;">未缴纳费用</td>
					<td style="width: 150px;">操作</td>

				</thead>
				<tbody>
				<c:forEach items="${page.list}" var="payment">
				<tr class="a">
					<td>${payment.paymentOwnerNo}</td>
					<td>${payment.paymentOwnerName}</td>
					<td>${payment.paymentCategory}</td>
					<td>${payment.paymentFee}</td>
					<td>${payment.paymentContent }</td>
					<td><a style="color: blue;font-size: 18px;" href="javascript:void(0);" onclick="modify('${payment.id}')">修改</a><span>|</span><a style="color: blue;font-size: 18px;" href="javascript:void(0);" onclick="del('${payment.id}')">删除</a></td>
				</tr>
				</c:forEach>
				</tbody>

			</table>
			<p>
				<button type="button" style="position: absolute;top: 590px;left: 400px;height: 22px;width: 40px;font-size: 10px;" onclick="showPages('${page.firstPage}')">首页</button>
				<button type="button" style="position: absolute;top: 590px;left: 460px;height: 22px;width: 50px;font-size: 10px;" onclick="showPages('${page.prePage}')">上一页</button>
				<button type="button" style="position: absolute;top: 590px;left: 520px;height: 22px;width: 50px;font-size: 10px;" onclick="showPages('${page.nextPage}')">下一页</button>
				<button type="button" style="position: absolute;top: 590px;left: 590px;height: 22px;width: 40px;font-size: 10px;" onclick="showPages('${page.lastPage}')">尾页</button>
			</p>
			<p style="position: absolute;left: 411px;top: 602px;font-size: 16px;">
				总共${page.total}条，共${page.pages}页，当前第${page.pageNum }页
			</p>
			<a href="${ctx}/toPAdd.do" style="position: absolute;top: 100px;right: 250px" href="æ·»å ä¸ä¸»èµæ.html"><img src="${ctx }/image/add.png"></a>
		</div>

	</body>
</html>

