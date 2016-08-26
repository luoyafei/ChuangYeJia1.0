<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<title>
			版本声明
		</title>
		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
		<link href="<%=path%>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">

		<!-- Bootstrap core JavaScript
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
		
		<script src="<%=path%>/assets/uikit/uikit.js"></script>
		<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>
		
		<style>
		body {
			font-family: "微软雅黑";
			padding-bottom: 0px;
		}
		
		li a {
			color: snow;
		}
		
		.row .img {
			margin-right: 5px;
		}
		
		.nav .active a {
			border-bottom: solid #398BE5 3px;
			color: #398BE5;
			font-weight: bold;
		}
		
		#navbar ul a:hover {
			border-bottom: solid #398BE5 3px;
			color: #398BE5;
			background-color: transparent;
		}
		
		#choicelabel a {
			color: black;
		}
		
		#choicelabel .active {
			color: #398BE5;
		}
		
		#inputSearch {
			border-radius: 20px;
			background-color: #A9A9A9;
		}
		
		.col-lg-3 {
			margin: 0 0;
			padding: 0 0;
		}
		
		.col-lg-4 {
			margin: 0 0;
			padding: 0 0;
		}
		
		.marketing .col-lg-4 {
			margin-bottom: 0px;
		}
		
		.alert {
			padding: 0;
			margin-bottom: 0px;
		}

</style>
		
</head>
	<body style="background-color: #F5F5F5;">
		
		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			<!-- Indicators -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="../../assets/img/user/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span>
									<img src="../../assets/img/user/logo.png" style="width: 18%;height: 6%; margin-bottom: 0px;padding-bottom: 0px;">
								</span>
								<span>
									<a style="font-size: 22px;text-decoration: none;">
										<span style="display: block;">创业加</span>
										<br />
									</a>
								</span>
							</div>
							<p style="margin-bottom: 0px;font-size: 44px;">
								版本声明
							</p>
							<span style="border-top: solid white 2px;" style="font-family: sans-serif;">Hello!Welcome to Enterperse Plus</span>
							<br />
							<br />
							<br />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 68%;">
			<!-- Three columns of text below the carousel -->
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">
						ABOUT&nbsp;&nbsp;OUR
					</p>
					<p style="float: right;">
						随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
					</p>
					<h2 style="margin-top: 0;" style="color: black;">
						版本声明
					</h2>
				</div>
			</div>
			<div class="content-main" style="width: 100%;height: 100%;padding-bottom: 50px;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
				<div class="content-main-top" style="height: 27%;">
					<div style="width: 80%;height: 100%;margin: 0 auto;">
						
						<br /><strong>版本声明</strong><br />
						&nbsp;&nbsp;&nbsp;&nbsp;
						
						 创业加网站，chuangyejia.pub依法独立享有该软件之所有权利，本平台为商业网站，该网站使用者（含个人、法人或其他组织）：
						
						<ol>
							<li>非经chuangyejia.pub授权许可，不得将之用于盈利或非盈利性的任何用途。</li>
							<li>为适应实际的计算机应用环境，对其功能、性能、界面，可以进行必要的修改；未经chuangyejia.pub书面授书，不得向第三方提供修改后的软件。</li>
							<li>使用该软件必须保留chuangyejia.pub的版权声明，将该软件从原有自然语言文字转换成另一自然语言文字的，仍应注明出处，并不得向任何第三方提供修改后的软件</li>
							<li>不得有其他侵犯chuangyejia.pub软件版本权之行为。</li>
						</ol>
						
						    凡有上述侵权行为的个人、法人或其它组织，必须立即停止侵权并对其侵权造成的一切不良后果承担全部责任。对此前，尤其是此后侵犯chuangyejia.pub版权的行为。chuangyejia.pub将依据《著作权法》、《计算机软件保护条例》等相关法律、法规追究其经济责任和法律责任。
						
						<br />
						<br />
						<strong>
							创业+协同创业系统软件 版权信息：
							<ul>
								<li>登记号：2016SR101911</li>
								<li>分类号：30200-0000</li>
								<li>软件全程：创业加协同创业系统软件</li>
								<li>软件简称：协同创业系统</li>
								<li>版本号：V1.0</li>
								<li>著作权人：严晨光 赵杰 马诗 刘燕 杨润雪</li>
								<li>登记日期：2016-05-11		</li>
							</ol>
						</strong>				
					</div>
				</div>
			</div>
		</div>
	
	<jsp:include page="../module/bottom.jsp" flush="true" />			
		
	</body>
	<script>

	$(document).ready(function() {
		$("td").attr("style", "border-top: solid #333333 1px;");
	});
</script>
</html>