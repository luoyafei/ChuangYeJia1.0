<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<title>
			用户注册页面
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
		
		<script src="<%=path%>/assets/manualSource/js/register.js"></script>
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
		<%
		//out.println("<script type='text/javascript'>if(document.body.offsetWidth < 684) {window.location.href = '/ChuangYeJia/pages/signIn/register_phone.jsp';}</script>");
		%>
		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path %>/assets/img/user/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span>
									<img src="<%=path %>/assets/img/user/logo.png" style="width: 18%;height: 6%; margin-bottom: 0px;padding-bottom: 0px;">
								</span>
								<span>
									<a style="font-size: 22px;text-decoration: none;">
										<span style="display: block;">创业加</span>
										<br />
									</a>
								</span>
							</div>
							<p style="margin-bottom: 0px;font-size: 34px;">
								个人注册页
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
		
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">
						REGISTRATION&nbsp;&nbsp;INFORMATION
					</p>
					<p style="float: right;">
						随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
					</p>
					<h2 style="margin-top: 0;" style="color: black;">
						注册信息
					</h2>
				</div>
			</div>
			<div class="content-main" style="width: 100%;height: 850px;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
				
				<div class="content-main-top" style="height: 27%;">
					<div style="width: 80%;height: 100%;margin: 0 auto;">
						<div class="main">
							<div class="main-login">
							
								<div style="text-align: center; color:red;"><s:property value="errors.error[0]" /></div>
								<form action="/ChuangYeJia/userSignIn!register_micro.action" method="post" name="form" enctype="multipart/form-data" onsubmit="return checkdata()" >
								
									<div class="form-group" style="margin-top: 30px;">
										<input type="text" class="form-control" name="ud.nickname" id="nickname" placeholder="昵称" maxlength="30" onblur="checknickname()">
										<div class="alert alert-danger alert-nickname" role="alert" style="display: none">
											请输入您的昵称，昵称必须在2~16个长度之间
										</div>
									</div>
									
									<hr style="width: 100%; color: black;font-size: 2px;" />
									<div class="form-group" style="margin-top: 30px;">
										上传头像(大小限制在2M内)<input type="file" id="picture" style="display:inline;" name="picture" accept="image/*"/>
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									<%-- <div class="form-group">
										<input type="email" class="form-control" name="ud.email" id="email" maxlength="30" placeholder="邮箱" onblur="checkemail()">
										<div class="alert alert-danger alert-email" role="alert" style="display: none">
											请输入您的邮箱
										</div>
										<div class="alert alert-danger alert-check-email" role="alert" style="display:none;">
											<span class="email-error">
											</span>
										</div>
									</div> --%>
									<div class="form-group">
										<label for="profile" class="col-sm-2 control-label">个人经历&nbsp;&nbsp;</label>
										<div class="col-sm-12">
											<textarea id="profile" name="profile" placeholder="个人经历" style="width:100%;height:150px;">
											</textarea>
										</div>
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									<div class="form-group">
										<input type="text" class="form-control" name="address" id="address" placeholder="所属高校">
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									
									<div class="form-group">
										<input type="tel" class="form-control" name="ud.tel" id="tel" maxlength="11" placeholder="电话号码" onblur="checktel()">
										<div class="alert alert-danger alert-tel" role="alert" style="display: none">
											请输入您的电话号码
										</div>
										<div class="alert alert-danger alert-check-tel" role="alert" style="display:none;">
											<span class="tel-error">
											</span>
										</div>
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									
									<div class="form-group">
										<div class="row">
											<div class="col-md-8">
										    	<input type="number" maxlength="6" class="form-control" name="registerTelCode" id="telCode" placeholder="请直接输入验证码">
										    </div>
											<div class="col-md-4">
												<a class="btn" id="clickSend">点击获取手机验证码</a>
											</div>
										</div>
									</div>
									
									<hr style="width: 100%; color: black;font-size: 2px;" />
									<div class="form-group">
										<input type="password" class="form-control" name="ud.password" id="password" maxlength="16" placeholder="密码" onblur="checkpassword()">
										<div class="alert alert-danger alert-password" role="alert" style="display: none;">
											请输入您的密码,密码必须在6~16个长度之间
										</div>
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									
									
									
									<div class="form-group">
										<input type="password" class="form-control" name="ud.validatePassword" id="repassword" placeholder="确认密码" onblur="checkrepassword()">
										<div class="alert alert-danger alert-repassword" role="alert" style="display: none;">
											请核实密码与确认密码是一致的
										</div>
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									<div class="form-group">
									
										<div class="row">
											<div class="col-md-8">
										    	<input type="text" onblur="checkIdentifyCode()" maxlength="5" class="form-control" name="ud.identifyCode" id="identifyCode" placeholder="请直接输入数字结果，如:8">
										    </div>
										    <div class="col-md-2">
												<div class="alert alert-danger alert-identifycode" role="alert" style="display: none">
													请输入验证码
												</div>
												<div class="alert alert-danger alert-check-identifycode" role="alert" style="display:none;">
													<span class="identifycode-error">
														输入错误
													</span>
												</div>
											</div>
											<div class="col-md-2" onclick="changeImg()">
												<span class="badge" id="regetIdentify">
													<img alt="看不清，换一张" id="validateCodeImg" src="userSignIn!identifyCode.action" style="width:100%;height:100%;">
												</span>
												<script type="text/javascript">
													function changeImg(){
					 									document.getElementById("validateCodeImg").src = "userSignIn!identifyCode.action?i="+Math.random();
													}
												</script>
											</div>
										</div>
																		
									</div>
									<hr style="width: 100%; color: black;font-size: 2px;" />
									<div class="checkbox form-group">
										<label>
											<input type="checkbox" checked="checked">
											我已阅读并同意</input>
											<a data-toggle="modal" data-target="#myModalProtocol">
												《创业加用户协议》
											</a>
										</label>
									</div>
									<button type="submit" class="btn btn-success btn-l btn-block" name="register" value="注册">
										注册
									</button>
									<input type="hidden" name="backUrl" value='<s:property value="#parameters.backUrl"/>'  />
								</form>
								<!-- Modal -->
								<div class="modal fade" id="myModalProtocol" tabindex="-1" role="dialog" aria-labelledby="myModalProtocolLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
								        <h4 class="modal-title" id="myModalLabel">请上传您的材料</h4>
								      </div>
								      <div class="modal-body">
								        <br/><br /><strong>用户协议</strong><br />
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								      </div>
								    </div>
								  </div>
								</div>
							</div>
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
	});
</script>
</html>
