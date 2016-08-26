<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">

	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

		<title>发布产品页面</title>

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
		<script src="<%=path%>/assets/uikit/form-select.js"></script>
		<link href="<%=path%>/assets/uikit/form-select.css" rel="stylesheet"/>


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
					<img class="" src="<%=path %>/assets/img/project/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span>
									<img data-holder-rendered="true" src="<s:property value='#session.user.userPhoto'/>" style="width: 100px; height: 100px;" class="img-circle" />
								</span>
							</div>
							<p style="margin-bottom: 0px;font-size: 32px;">
								<br>发布产品
							</p>
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
					<p style="margin-bottom: 4px;">HOW&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;&nbsp;&nbsp;&nbsp;CREATE</p>
					<p style="float: right;">随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。</p>
					<h2 style="margin-top: 0;" style="color: black;">产品分类</h2>
				</div>
			</div>

			<div class="marketing-nav">
				<ul class="nav nav-tabs marketing-nav-content" role="tablist" id="myTab">
					<li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab" style="color: #398BE5;">发布产品</a></li>
				</ul>
			</div>

			<div class="tab-content" style="background-color: white;padding-top: 40px;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
		
				<div role="tabpanel" class="tab-pane active" id="home">
					<div class="tab-content-1" style="width: 80%;height: 100%;margin: 0 auto; background-color: white;">
						<form id="productForm" action="createProduct!createProduct.action" class="form-horizontal" role="form" style="margin-left: 0px;" method="post" enctype="multipart/form-data">


							<label style="text-align: center;color: #398BE5; width: 100%;"><s:property value="errors.error[0]" /></label>
							<label id="productSendError" style="text-align: center;color: #398BE5; width: 100%;"></label>
						
							
							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -28px;;padding-top: 15px;">
									<label for="startups" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">选择公司</label>
									<div class="col-sm-10">
										 <div class="uk-button uk-form-select uk-active" data-uk-form-select="">
			                                <span></span>
			                                <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
			                                <select id="selectFlag" name="pd.startups">
			                                	<option value="0">选择您要创建产品的公司</option>
			                                </select>
			                            </div>
									</div>
								</div>
							</div>


							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -28px;;padding-top: 15px;">
									<label for="name" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">产品名称</label>
									<div class="col-sm-10">
										<input type="text" maxlength="18" class="form-control" name="pd.name" style="background-color: #F5F5F5;" id="name" />
									</div>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -28px;;padding-top: 15px;">
									<label for="address" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">归属地</label>
									<div class="col-sm-10">
										<input type="text" maxlength="50" class="form-control" name="pd.address" style="background-color: #F5F5F5;" id="address" />
									</div>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -28px;;padding-top: 15px;">
									<label for="brief" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">产品简介&nbsp;&nbsp;</label>
									<div class="col-sm-10">
										<input type="text" maxlength="255" class="form-control" name="pd.brief" style="background-color: #F5F5F5;" id="brief" />
									</div>
								</div>
							</div>


							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -30px;padding-top:15px;">
									<label for="detail" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">详细内容&nbsp;&nbsp;</label>
									<div class="col-sm-10">
										<textarea id="detail" name="pd.detail" style="width:100%;height:200px;"></textarea>
									</div>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -45px;padding-top: 15px;">
									<label for="picture" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">上传封面</label>
									<div class="col-sm-10">
										<div>
											<input type="file" class="picture" style="display: none;" id="picture" name="picture"></input>
										</div>
										<div style="text-align: center;">
											<a class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;" onclick="product_upload()">立即上传</a>
											<span>&nbsp;(1张图片)</span>
										</div>

										<script>
											function product_upload() {
												$("#picture").attr("style", "display: inline;");
											}
										</script>
									</div>
								</div>
							</div>
							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -28px;;padding-top: 15px;">
									<label for="price" class="col-sm-2 control-label" style="font-size: 18px;font-weight: normal;">售价(元)&nbsp;&nbsp;</label>
									<div class="col-sm-10">
										<input type="number" maxlength="12" class="form-control" name="pd.price" placeholder="如若暂不售卖，请不要填写" style="background-color: #F5F5F5;" id="price" />
									</div>
								</div>
							</div>
							
						</form>
							<div style="margin: 50px auto;">
								<div class="form-group" style="margin: 0 auto; text-align: center;">
									<button id="sendProduct" class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;">发送</button>
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
			
			
	        $.post('getMyLeaderForInvite!justDoIt.action', {}, function(data, textStatus) {
            	if(textStatus == "success") {
            		if(data.leaderS.length == 0) {
            			$("#productSendError").text("您还没有自己的公司！请先创建属于自己的公司后，再进行发布产品吧！");
            		} else {
            			for(var i = 0; i < data.leaderS.length; i++) {
            				var option = $('<option></option>');
            				option.attr("value", data.leaderS[i].startupsId);
            				option.text(data.leaderS[i].startupsName);
            				option.appendTo($("#selectFlag"));
            			}
            		}
            		
            	} else {
            		alert("网络出错！请刷新重试！");
            	}
            }, 'json');
			
			
			$("#sendProduct").bind('click', function() {
				
				var isOk = true;
				
				var img = $("#picture");
				var name = $("#name").val().trim();
				var address = $("#address").val().trim();
				var brief = $("#brief").val().trim();
				var startups = $("#selectFlag").val().trim();
				var detail = $("#detail").val().trim();
				var price = $("#price").val().trim();
				
				if(startups == 0) {
                	$("#productSendError").text("您还没有选择您自己的公司！如果没有，请先创建属于自己的公司后，再进行发布产品吧！");
                	isOk = false;
                } else if(name === "" || name > 18){
                	$("#productSendError").text("请正确填写您要发布的产品名称！");
                	isOk = false;
                } else if(address === "") {
                	$("#productSendError").text("请正确填写您要发布的产品的归属地！");
                	isOk = false;
                } else if(brief === "") {
                	$("#productSendError").text("请正确填写您要发布的产品的简介！");
                	isOk = false;
                } else if(detail === "") {
                	$("#productSendError").text("请正确填写您要发布的产品的详细内容！");
                	isOk = false;
                } else if(img.val().trim() === "") {
					$("#productSendError").text("请选择图片！");
					isOk = false;
				}
                
                if(isOk) {
                	$("#productForm").submit();
                }
				
			});
		});
	</script>

</html>
