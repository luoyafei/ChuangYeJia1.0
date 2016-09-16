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
			创业加登陆
		</title>
		
		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
		
		<script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
		
		<script src="<%=path%>/assets/manualSource/js/login.js"></script>	
			
	</head>
	<body style="background-color: #F5F5F5;">
	
		<div class="container marketing" style="background-color: #F5F5F5; padding:0px 0px;width: 100%;">
			<h2 align="center">登录</h2>
				<div class="content-main-top" style="height: 27%;">
					<div style="width: 80%;height: 100%;margin: 50px auto;">
					
					<div style="text-align: center; color:red;"><s:property value="errors.error[0]" /></div>
					
						<form action="userSignIn!execute.action" method="post" onsubmit="return checkdata()">
                            <div class="form-group">
							    <label for="email" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;箱</label>
							    <div class="col-sm-10">
							    	<input type="email" class="form-control" name="ud.email" maxlength="16" id="email" placeholder="邮箱" onblur="checkemail()">
							    
								    <div class="alert alert-danger alert-email" role="alert" style="display: none">
										请输入您的邮箱
									</div>
									<div class="alert alert-danger alert-check-email" role="alert" style="display:none;">
										<span class="email-error">
										</span>
									</div>
							    	<hr />
							    </div>
							</div>
							 <div class="form-group">
							    <label for="password" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码</label>
							    <div class="col-sm-10">
							    	<input type="password" class="form-control" name="ud.password" id="password" maxlength="16" placeholder="密码" onblur="checkpassword()">
							    	<div class="alert alert-danger alert-password" role="alert" style="display: none;">
										请输入您的密码
									</div>
								    <hr />
							    </div>
							</div>
							
							<div class="form-group">
									
								<div class="row">
									<label for="email" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">验证码</label>
									
									<div class="col-sm-5">
								    	<input type="text" onblur="checkIdentifyCode()" maxlength="5" class="form-control" name="ud.identifyCode" id="identifyCode" placeholder="请直接输入数字结果，如:8">
								    </div>
								    <div class="col-sm-2">
										<div class="alert alert-danger alert-identifycode" role="alert" style="display: none">
											请输入验证码
										</div>
										<div class="alert alert-danger alert-check-identifycode" role="alert" style="display:none;">
											<span class="identifycode-error">
												输入错误
											</span>
										</div>
									</div>
									<div class="col-sm-3" onclick="changeImg()">
										<span class="badge" id="regetIdentify">
											<img alt="看不清，换一张" id="validateCodeImg" src="userSignIn!identifyCode.action" style="width:100%;height:100%;">
										</span>

									</div>
								</div>
																
							</div>
                                  
                            <div class="form-group">
                            	<div class="row">
                            		<div class="col-sm-2"></div>
                            		<div class="col-sm-8">
										<input type="checkbox" checked="checked" />下次自动登陆
									</div>
									<div class="col-sm-2"><a href="#">忘记密码</a></div>
                            	</div>
								
							</div>
							
							<div style="text-align: center;">
								<button type="submit" class="btn btn-default" style="color: #398BE5;" name="login" value="登陆">
									登陆
								</button>
								<a class="btn btn-default" style="color: #398BE5;" href="register.jsp">注册</a>
							</div>
							<input type="hidden" name="backUrl" value='<s:property value="#parameters.backUrl"/>'  />
							
						</form>
					</div>
				</div>
			</div>
	</body>
</html>
