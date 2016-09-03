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
			找回密码
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
	
	<%
	//out.println("<script type='text/javascript'>if(document.body.offsetWidth < 684) {window.location.href = '/ChuangYeJia/pages/signIn/login_phone.jsp';}</script>");
	%>
	
	<jsp:include page="/pages/module/index_bar.jsp" flush="true" />
	
		
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			<!-- Indicators -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path%>/assets/img/user/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span>
									<img src="<%=path%>/assets/img/user/logo.png" style="width: 18%;height: 6%; margin-bottom: 0px;padding-bottom: 0px;">
								</span>
								<span>
									<a style="font-size: 22px;text-decoration: none;">
										<span style="display: block;">创业加</span>
										<br />
									</a>
								</span>
							</div>
							<p style="margin-bottom: 0px;font-size: 34px;">
								找回密码
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
			
			<div class="content-main" style="width: 100%;height: 250px;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
				<div class="content-main-top" style="height: 27%;">
					<div style="width: 80%;height: 100%;margin: 50px auto;">
							<div style="text-align: center; color:#459EEB;" id="backResult"></div>
                            <div class="form-group">
							    <label for="email" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;箱</label>
							    <div class="col-sm-10">
							    	<input type="email" class="form-control" name="email" maxlength="30" id="email" placeholder="邮箱" onblur="checkemail()">
							    
								    <div class="alert alert-danger alert-email" role="alert" style="display: none">
										请输入正确的邮箱格式
									</div>
							    	<hr />
							    </div>
							</div>
							
							<div style="text-align: center;">
								<button type="button" class="btn btn-default" style="color: #398BE5;" name="forget" id="forgetBtn">
									确认发送
								</button>
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
		$("#forgetBtn").bind('click', function() {
			var email = $("#email").val().trim();
			if(email !== "" && email.match(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/)) {
				$(".alert-email").attr("style", "display: none;");
				$.post('forgetPassword!justDoIt.action', {
					email : email
				}, function(data, textStatus) {
					if(textStatus == "success") {
						if(data.success) {
							$("#backResult").text("找回密码申请成功！请您登录您的邮箱，进行邮件查看，注意！该邮件有可能被您的邮箱屏蔽！如果找不到的话，可在垃圾箱寻找！");
						} else {
							$("#backResult").text(data.reason);
						}
					}
				}, 'json');
				
			} else {
				$(".alert-email").attr("style", "display: inline;");
			}
			
		});
	});
	function checkemail() {
		var email = $("#email").val().trim();
		if(email === "" || !email.match(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/)) {
 			$(".alert-email").attr("style", "display: inline;");
		} else {
			$(".alert-email").attr("style", "display: none;");
		}
	}
</script>
</html>