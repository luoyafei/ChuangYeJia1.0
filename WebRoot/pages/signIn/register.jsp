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
			<!-- Three columns of text below the carousel -->
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
			<div class="content-main" style="width: 100%;height: 650px;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
				<div class="content-main-top" style="height: 27%;">
					<div style="width: 80%;height: 100%;margin: 0 auto;">
						<div class="main">
						
							<div class="main-login">
							
								<form action="userSignIn!register.action" method="post" name="form" onsubmit="return checkdata()" >
								
									<div class="form-group" style="margin-top: 30px;">
										<input type="text" class="form-control" name="ud.nickname" id="nickname" placeholder="昵称" maxlength="16" onblur="checknickname()">
										<div class="alert alert-danger alert-nickname" role="alert" style="display: none">
											请输入您的昵称，昵称必须在2~16个长度之间
										</div>
									</div>

									<hr style="width: 100%; color: black;font-size: 2px;" />
									<div class="form-group">
										<input type="email" class="form-control" name="ud.email" id="email" maxlength="30" placeholder="邮箱" onblur="checkemail()">
										<div class="alert alert-danger alert-email" role="alert" style="display: none">
											请输入您的邮箱
										</div>
										<div class="alert alert-danger alert-check-email" role="alert" style="display:none;">
											<span class="email-error">
											</span>
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
								        <h4 class="modal-title" id="myModalLabel">创业加用户协议</h4>
								      </div>
								      <div class="modal-body">
								        <br/><br /><strong>用户协议</strong><br />
访问者在接受本网站服务之前，请务必仔细阅读本条款并同意本声明。访问者访问本网站的行为以及通过各类方式利用本网站的行为，都将被视作是对本声明全部内容的无异议的认可;如有异议，请立即跟本网站协商，并取得本网站的书面同意意见。
　　<br/><br/>第一条访问者在从事与本网站相关的所有行为(包括但不限于访问浏览、利用、转载、宣传介绍)时，必须以善意且谨慎的态度行事;访问者不得故意或者过失的损害或者弱化本网站的各类合法权利与利益，不得利用本网站以任何方式直接或者间接的从事违反中国法律、国际公约以及社会公德的行为，且访问者应当恪守下述承诺：
　　1、传输和利用信息符合中国法律、国际公约的规定、符合公序良俗;
　　2、不将本网站以及与之相关的网络服务用作非法用途以及非正当用途;
　　3、不干扰和扰乱本网站以及与之相关的网络服务;
4、遵守与本网站以及与之相关的网络服务的协议、规定、程序和惯例等。
　　<br/><br/>第二条本网站郑重提醒访问者：请在转载、上载或者下载有关作品时务必尊重该作品的版权、著作权;如果您发现有您未署名的作品，请立即和我们联系，我们会在第一时间加上您的署名或作相关处理。
　　<br/><br/>第三条除我们另有明确说明或者中国法律有强制性规定外，本网站用户原创的作品，本网站及作者共同享有版权，其他网站及传统媒体如需使用，须取得本网站的书面授权，未经授权严禁转载或用于其它商业用途。
　　<br/><br/>第四条本网站内容仅代表作者本人的观点，不代表本网站的观点和看法，与本网站立场无关，相关责任作者自负。
　　<br/><br/>第五条本网站有权将在本网站内发表的作品用于其他用途，包括网站、电子杂志等，作品有附带版权声明者除外。
　　<br/><br/>第六条未经常本网站和作者共同同意，其他任何机构不得以任何形式侵犯其作品著作权，包括但不限于：擅自复制、链接、非法使用或转载，或以任何方式建立作品镜像。
　　<br/><br/>第七条本网站所刊载的各类形式(包括但不仅限于文字、图片、图表)的作品仅供参考使用，并不代表本网站同意其说法或描述，仅为提供更多信息，也不构成任何投资建议。对于访问者根据本网站提供的信息所做出的一切行为，除非另有明确的书面承诺文件，否则本网站不承担任何形式的责任。
<br/><br/>第八条当本网站以链接形式推荐其他网站内容时，本网站并不对这些网站或资源的可用性负责，且不保证从这些网站获取的任何内容、产品、服务或其他材料的真实性、合法性，对于任何因使用或信赖从此类网站或资源上获取的内容、产品、服务或其他材料而造成(或声称造成)的任何直接或间接损失，本网站均不承担任何责任。
　　<br/><br/>第九条访问者在本网站注册时提供的一些个人资料，本网站除您本人同意及第十条规定外不会将用户的任何资料以任何方式泄露给任何一方。
　　<br/><br/>第十条当政府部门、司法机关等依照法定程序要求本网站披露个人资料时，本网站将根据执法单位之要求或为公共安全之目的提供个人资料。在此情况下之任何披露，本网站均得免责。
　　<br/><br/>第十一条由于用户将个人密码告知他人或与他人共享注册账户，由此导致的任何个人资料泄露，本网站不负任何责任。
　<br/><br/>第十二条本网站有部分内容来自互联网，如无意中侵犯了哪个媒体、公司、企业或个人等的知识产权，请来电或致函告之，本网站将在规定时间内给予删除等相关处理，若有涉及版权费等问题，请及时提供相关证明等材料并与我们联系，通过友好协商公平公正原则处理纠纷。
　　<br/><br/>第十二条以上声明内容的最终解释权归创业加网站所有。
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
