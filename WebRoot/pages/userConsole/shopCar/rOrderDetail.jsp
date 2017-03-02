<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			订单详情
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
		
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path %>/assets/img/content_detail/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<p style="margin-bottom: 0px;font-size: 32px;">
								<br> 订单详情页面
							</p>
							<br />
							<br />
							<br />
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 68%;">
			
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">
						WHAT&nbsp;&nbsp;&nbsp;&nbsp;IS&nbsp;&nbsp;&nbsp;&nbsp;IT
					</p>
					<p style="float: right;">
						随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
					</p>
					<h2 style="margin-top: 0;" style="color: black;">
						订单详情
					</h2>
				</div>
			</div>

			<div class="marketing-nav">
				<ul class="nav nav-tabs marketing-nav-content" role="tablist" id="myTab">
					<li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab" style="color: #398BE5;">具体订单</a></li>
				</ul>
			</div>

			<div class="tab-content" style="background-color: white;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
				<div role="tabpanel" class="tab-pane active" id="home">
					<div class="tab-content-1" style="width: 80%;height: 100%;margin: 0 auto; background-color: white;overflow: hidden;">
						<div role="form" style="margin-left: 0px;padding-top: 20px;">

							<div class="panel panel-default">
							  <div class="panel-heading">
							    <h3 class="panel-title">产品名称：<s:property value="#request.ritem.productId.productName"/></h3>
							  </div>
							  
							  <div class="panel-heading">
							    <h3 class="panel-title">产品单价：<s:property value="#request.ritem.unitPrice"/></h3>
							  </div>
							  <div class="panel-heading">
							    <h3 class="panel-title">产品个数：<s:property value="#request.ritem.productCount"/></h3>
							  </div>
							   <div class="panel-heading">
							    <h3 class="panel-title">所属公司：<s:property value="#request.ritem.startupsId.startupsName"/></h3>
							  </div>

							  <div class="panel-heading">
							    <h3 class="panel-title">寄送地址：<s:property value="#request.ritem.addr"/></h3>
							  </div>

							  <div class="panel-heading">
							    <h3 class="panel-title">订单状态：<s:property value="#request.ritem.status"/></h3>
							  </div>

							  <div class="panel-heading">
							    <h3 class="panel-title">创建时间：<s:property value="#request.ritem.orderDate"/> </h3>
							  </div>
							  
							  <div class="panel-heading">
							    <h3 class="panel-title">服务是否结束：
							    	<s:if test="#request.ritem.isSigned == 0">
							    	
			    						<input type="file" id="picture" style="display:inline;" name="picture" accept="image/*"/>
										<button id="uploadBtn" type="button" class="uk-button uk-button-danger" onclick="uploadService()">
											<span id="uploadInfo">上传服务凭证</span>
											<span id="uploadOk" class="" aria-hidden="true" style="display: none;"></span>
										</button>
							    		<script type="text/javascript">
							    		
							    		function uploadService() {
				                        	if($("#picture").val().trim() === "")
				                        		alert("请选择图片后进行上传");
				                        	else {
				                        		$("#uploadBtn").attr("disabled", "true");
				                        		$("#uploadInfo").text("图片正在玩命上传！请稍后...");
				                        		var fd = new FormData();
				                        		fd.append("picture", $("#picture").get(0).files[0]);
				                        		fd.append("receivedOrderId", "<s:property value='#request.ritem.orderId'/>");
				                        		$.ajax({
				                        			url: "dealOrder!uploadCertificate.action",
				                        			type: "POST",
				                        			dataType: "json",
				                        			processData: false,
				                        			contentType: false,
				                        			data: fd,
				                        			success: function(data) {
				                        				$("#uploadBtn").removeAttr("disabled");
				                        				if(data.status) {
				                        					$("#userImg").attr("src", data.pictureUrl);
				                        					$("#uploadInfo").text("上传成功！");
				                        					$("#uploadOk").attr("style", "display: inline;");
				                        					$("#uploadOk").attr("class", "glyphicon glyphicon-ok");
				                        				} else {
				                        					$("#uploadInfo").text("上传失败！");
				                        					$("#uploadOk").attr("style", "display: inline;");
				                        					$("#uploadOk").attr("class", "glyphicon glyphicon-remove");
				                        				}
				                        			},
				                        			 error: function(XMLHttpRequest, textStatus, errorThrown) {
				                        				$("#uploadBtn").removeAttr("disabled");
				                        				$("#uploadInfo").text("上传失败！");
				                        				$("#uploadOk").attr("style", "display: inline;");
				                        				$("#uploadOk").attr("class", "glyphicon glyphicon-remove");
				                        			}
				                        		});
				                        	}
				                        }	
							    		</script>
							    	</s:if>
							    	<s:elseif test="#request.ritem.isSigned == 2">
							    		<label>已上传结束服务凭证</label>
							    	</s:elseif>
							    	<s:elseif test="#request.ritem.isSigned == 1">
							    		<label>服务已结束</label>
							    	</s:elseif>
							    
							    </h3>
							  </div>
							  
							  
							</div>
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
