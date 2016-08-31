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
			创建公司
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
		<script src="<%=path%>/assets/uikit/lightbox.js"></script>
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

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path %>/assets/img/project/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<s:if test="#session.user != null">
									<span>
										<img data-holder-rendered="true" src="<s:property value='#session.user.userPhoto'/>" style="width: 100px; height: 100px;" class="img-circle" />
									</span>
										<a style="font-size: 14px;text-decoration: none;">
												<span style="display: block;">
													昵称：<s:property value="#session.user.userNickName"/>
												</span>
										</a>
								</s:if>
								<s:else>
									<span><img src="<%=path %>/assets/img/project/head.png" style="width: 12%;height: 5%; margin-bottom: 0px;padding-bottom: 0px;"></span>
									<span>
										<a style="font-size: 14px;text-decoration: none;">
												<span style="display: block;">
													请先进行登陆再进行创建公司！
												</span>
										</a>
									</span>
								</s:else>
								
							</div>

							<p style="margin-bottom: 0px;font-size: 32px;">
								<br> 个人创业历程
							</p>

						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 100%;">

			<div class="marketing-nav">
				<ul class="nav nav-tabs marketing-nav-content" role="tablist" id="myTab">
					<li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab" style="color: #398BE5;">创建公司</a></li>
				</ul>
			</div>

			
				<div role="tabpanel" class="tab-pane active" id="home">
				
					<div class="tab-content-1" style="width: 80%;height: 100%;margin: 0 auto; ">
						<form class="form-horizontal" action="createStartups" role="form" id="submitForm" style="margin-left: 0px;" method="post" enctype="multipart/form-data">
							
							<div class="form-group" style="margin-right: 0px;margin-left: -10px;">
							
								<s:if test="#session.user == null">
									<div class="alert alert-danger" role="alert" style="text-align: center;">
								      <strong>注意！请您</strong> <a href="/ChuangYeJia/pages/signIn/login.jsp?backUrl=<%=request.getRequestURI() %>" class="alert-link">登录</a>
								      后再进行创业公司的发布，如果您还没有注册，欢迎您<a href="/ChuangYeJia/pages/signIn/register.jsp?backUrl=<%=request.getRequestURI() %>" class="alert-link">点击这里</a>进行注册！
								    </div>
								</s:if>
								
								<p style="color:red;text-align: center;">
									<span id="errorBack">
										<s:property value="errors.error[0]" />
									</span>
								</p>
							
								<div style="margin-top: 23px;">
									<label for="name" class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">公司名称</label>
									<div class="col-sm-12">
										<input type="text" maxlength="16" class="form-control" name="sd.name" style="background-color: #F5F5F5;" id="name" />
									</div>
								</div>
								<hr class="featurette-divider" style="padding-bottom: 0px; margin-bottom: 0px;">
							</div>
							<h4>服务类型</h4>
							<div class="choicelabel" style="border-bottom: dashed #A9A9A9 1px;padding-bottom: 10px;">
								
								<div class="btn-group" data-toggle="buttons">
								  <label class="btn btn-default active">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" checked value="1">移动互联网
								  </label>
								  <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="2">电子商务
								  </label>
								  <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="3">文化艺术
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="4">教育体育
								  </label>
								  <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="5">汽车
								  </label>
								  <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="6">旅游户外
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="7">房产
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="8">营销广告
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="9">硬件
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="10">工具软件
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="11">企业服务
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="12">搜索安全
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="13">医疗健康
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="14">媒体资讯
								  </label>
								  <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="15">生活消费
								  </label>
								   <label class="btn btn-default">
								    <input type="radio" name="sd.type" class="type" autocomplete="off" value="0">其他
								  </label>
								</div>
							</div>

							<h4>合伙人需求</h4>
							
							<div class="choicelabel" style="border-bottom: dashed #A9A9A9 1px;padding-bottom: 10px;">
								<div class="btn-group" data-toggle="buttons">
								  <label class="btn btn-default active">
								    <input type="checkbox" name="sd.require" class="require" autocomplete="off" value="1" checked />资金
								  </label>
								  <label class="btn btn-default">
								    <input type="checkbox" name="sd.require" class="require" autocomplete="off" value="2" />技术
								  </label>
								  <label class="btn btn-default">
								    <input type="checkbox" name="sd.require" class="require" autocomplete="off" value="3" />推广
								  </label>
								  <label class="btn btn-default">
								    <input type="checkbox" name="sd.require" class="require" autocomplete="off" value="4" />运营
								  </label>
								  <label class="btn btn-default">
								    <input type="checkbox" name="sd.require" class="require" autocomplete="off" value="0" />其他
								  </label>
								</div>
							</div>

							<h4>运营阶段</h4>
							<div class="choicelabel" style="border-bottom: dashed #A9A9A9 1px;padding-bottom: 10px;">
								
								<div class="btn-group" data-toggle="buttons">
									  <label class="btn btn-default active">
									    <input type="radio" name="sd.stage" class="stage" autocomplete="off" checked value="1">概念阶段
									  </label>
									  <label class="btn btn-default">
									    <input type="radio" name="sd.stage" class="stage" autocomplete="off" value="2">产品研发中
									  </label>
									  <label class="btn btn-default">
									    <input type="radio" name="sd.stage" class="stage" autocomplete="off" value="3">产品已经上线
									  </label>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -10px;;padding-top: 15px;">
									<label for="address" class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">所属高校</label>
									<div class="col-sm-12">
										<input type="text" class="form-control" name="sd.address" maxlength="50" style="background-color: #F5F5F5;" id="address">
									</div>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -10px;;padding-top: 15px;">
									<label for="brief" class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">公司简介&nbsp;&nbsp;</label>
									<div class="col-sm-12">
										<input type="text" class="form-control" name="sd.brief" style="background-color: #F5F5F5;" id="brief" />
									</div>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -10px;padding-top:15px;">
									<label for="detail" class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">详细内容&nbsp;&nbsp;</label>
									<div class="col-sm-12">
										<textarea id="detail" name="sd.detail" style="width:100%;height:200px;"></textarea>
									</div>
								</div>
							</div>

							<div style="border-bottom: dashed #A9A9A9 1px;">
							
								<div class="form-group" style="margin-right: 0px;margin-left: -10px;padding-top:15px;">
									<label class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">上传封面(logo)</label>
									<div class="col-sm-12">
										<input type="file" class="upload_img" style="display: inline;" name="img" accept="image/*" />
									</div>
								</div>
								
							
							</div>
							

							<div style="border-bottom: dashed #A9A9A9 1px;">
							
								<div class="form-group" style="margin-right: 0px;margin-left: -10px;padding-top:15px;">
									<label class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">上传公司照片</label>
									<div class="col-sm-12">
										<input type="file" class="upload_img" style="display: inline;" name="img" accept="image/*" />
										<input type="file" class="upload_img" style="display: inline;" name="img" accept="image/*" />
										<input type="file" class="upload_img" style="display: inline;" name="img" accept="image/*" />
									</div>
								</div>
							
							</div>
							
							
							<div style="border-bottom: dashed #A9A9A9 1px;">
								<div class="form-group" style="margin-right: 0px;margin-left: -10px;;padding-top: 15px;">
									<label for="video" class="col-sm-2 control-label" style="font-size: 18px;width: 100%;text-align: left;font-weight: normal;">介绍视频&nbsp;&nbsp;</label>
									<div class="col-md-8">
										<input type="text" id="video" name="sd.video" placeholder="请点击右侧的视频说明按钮，了解如何进行这一步的操作！" class="form-control" style="background-color: #F5F5F5;" />
									</div>
									<div class="col-md-2">
		                            	<a class="uk-button" href="<%=path %>/assets/manualSource/img/videoExplain.png" data-uk-lightbox="" title="视频说明">视频说明</a>
									</div>
								</div>
							</div>
							
							<div class="uk-cover iframeDiv" style="display: none;">
							    <iframe src="" class="iframeSrc" style="width: 100%; height: 100%;" frameborder=0 allowfullscreen></iframe>
							</div>
						</form>

							<div style="margin: 50px auto;">
								<div class="form-group" style="margin: 0 auto; text-align: center;">
									<p style="color:red;text-align: center;"><span id="errorSpan"></span></p>
									<button  id="testClick" class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;">点击测试视频</button>
									<button id="sendStartups" class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;">发送</button>
								</div>
							</div>
					</div>
				</div>

			</div>

	<jsp:include page="../module/bottom.jsp" flush="true" />	

	</body>
	<script>
		$(document).ready(function() {
			$("td").attr("style", "border-top: solid #333333 1px;");
			$("#testClick").bind('click',function() {
				if($("#video").val().trim() !== "") {
					$(".iframeDiv").attr("style", "display: inline;");
					var videoTemp = $("#video").val().trim().split("src=")[1];
					var videoUrl = videoTemp.split('"')[1];
					$(".iframeSrc").attr("src", videoUrl);
				} else {
					alert("请先输入地址！");
				}
			});
			$("#sendStartups").bind('click', function() {
				var name = $("#name").val().trim();
				var type = $(".type").val().trim();
				var require = $(".require").val().trim();
				var stage = $(".stage").val().trim();
				var address = $("#address").val().trim();
				var brief = $("#brief").val().trim();
				var detail = $("#detail").val().trim();
				var img = $(".upload_img");
				var isOk = true;
				
				if(name === "") {
					$("#errorSpan").text("请填写公司名称！");
					isOk = false;
				}
				if(address === "") {
					$("#errorSpan").text("请填写公司归属地！");
					isOk = false;
				}
				if(brief === "") {
					$("#errorSpan").text("请填写公司简介！");
					isOk = false;
				}
				if(detail === "") {
					$("#errorSpan").text("请填写公司详细内容！");
					isOk = false;
				}
				
				for(var i = 0; i < 4; i++) {
					if(img.eq(i).val().trim() === "") {
						$("#errorSpan").text("请选择图片！");
						isOk = false;
					}
				}
				if(isOk) {
					$("#submitForm").submit();
				}
			});
		});
	</script>

</html>