<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

		<title>创建成功</title>

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
		</style>


	</head>

	<body style="background-color: #F5F5F5;">

		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;height: 100%;">
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path %>/assets/img/indexpage/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span><img src="<%=path %>/assets/img/logo.png" style="width: 18%;height: 8%; margin-bottom: 0px;padding-bottom: 0px;"></span>
							</div>

							<h1 style="margin-top: 0px; margin-bottom: 0px;">创建成功！</h1>
							
							<p style="margin-bottom: 0px;">
								<br> 通过创建创业公司，发布资金，技术，运营和产品，您可以参与多项创业活动，期待您在创业加中寻找到满意的工作！
							</p>
							<p style="padding-top: 10px;margin-bottom: 0px;">
								<a class="btn btn-primary" href="getProductItem?item=<s:property value='productId' />" role="button" style="border-radius: 20px;">查看已发布产品信息</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="../../module/bottom.jsp" flush="true" />
	</body>
	<script>
		$(document).ready(function() {
			$("td").attr("style", "border-top: solid #333333 1px;");
		});
	</script>

</html>