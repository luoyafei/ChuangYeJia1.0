<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.chuangyejia.bean.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("user")==null || ((User)session.getAttribute("user")).getUserId().equals(request.getParameter("toUserId"))) {
	out.println("<script type='text/javascript'>window.history.back();</script>");
}
%>
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<title>
			聊天交流页面
		</title>


		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet" />
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
		<link href="<%=path%>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet" />
		
		<script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
		
		
		<!-- uikit -->
		<script src="<%=path%>/assets/uikit/uikit.js"></script>
		<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>

<style>
		body {
			font-family: "微软雅黑";
			padding-bottom: 0px;
			overflow-x: hidden;
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
	
	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		style="margin-bottom: 0px;">
		
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="" src="../../assets/img/content_detail/333.png" alt="">
				<div class="container"
					style="padding-right: 0px; padding-left: 0px;">
					<div class="carousel-caption">
						<div class="logo-img" style="width: 100%;">
							<span> <img data-holder-rendered="true"  src="<%=path %>/assets/img/content_detail/头像.png" class="toUser_photo img-circle" style="width: 100px; height: 100px; margin-bottom: 0px; padding-bottom: 0px;">
							</span> <span> <a style="font-size: 14px; text-decoration: none;">
									<span style="display: block;" class="toUser_nickname">
									ID:姓名/昵称</span>
							</a> 
							<!--<a style="font-size: 14px;text-decoration: none;">
									<span style="display: block;">信用等级:4</span>
								</a>-->
							</span> <span> <img src="<%=path %>/assets/img/content_detail/等级条.png"
								style="width: 12%; height: 5%; margin-bottom: 0px; padding-bottom: 0px;">
							</span>
						</div>
						<p style="margin-bottom: 0px; font-size: 32px;">
							<br> 即时通讯
						</p>
						<br /> <br /> <br />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container marketing" style="background-color: #F5F5F5; padding: 50px 0px; width: 78%;">
		
		<div class="thumbtitle">
			<div class="contenttitle" style="margin-bottom: 10px;">
				<p style="margin-bottom: 4px;">
					WHO&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;AM</p>
				<p style="float: right;">
					随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。</p>
				<h2 style="margin-top: 0;" style="color: black;">即时通讯</h2>
			</div>
		</div>

		<div class="content-main"
			style="width: 100%; height: 1200px; background-color: white; overflow: hidden; border-bottom: solid #A9A9A9 2px; border-bottom-left-radius: 5px; border-bottom-right-radius: 5px;">

			<div class="content-main-mid"
				style="height: 90%; margin-top: 30px; border-bottom: solid #DCDCDC 1px;">
				<div style="width: 90%; height: 100%; margin: 0 auto;">
					<div class="main-right"
						style="width: 100%; height: 100%; float: right; padding-top: 20px;">

						<div class="modal_001" id="IM_dialog_info"
							aria-labelledby="myModalLabel001">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" id="myModalLabel001">联系交流</h4>
									</div>
									<div class="modal-body">


										<div class="form-horizontal" role="form">

											<div class="marketing-nav">
												<ul class="nav nav-tabs marketing-nav-content"
													role="tablist" id="myTab">
													<li role="presentation" class="active"><a
														href="#now_message_info" role="tab" data-toggle="tab"
														style="color: #398BE5;">当前消息</a></li>
													<li role="presentation"><a href="#history_message"
														role="tab" data-toggle="tab" style="color: black;">历史消息</a></li>
												</ul>
											</div>

											<!--##############################################此为当前消息-->
											<div class="tab-content" style="background-color: white; border-bottom: solid #A9A9A9 2px; border-bottom-left-radius: 5px; border-bottom-right-radius: 5px;">
												<div role="tabpanel" class="tab-pane active" id="now_message_info">
													<div class="tab-content-1" style="width: 100%; height: 880px; margin: 0 auto; background-color: #F5F5F5;">
														<div class="form-horizontal" role="form" style="margin-left: 0px;">
															<div class="" style="width: 100%; height: 600px; background-color:; overflow: auto; border-bottom: solid #A9A9A9 1px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;">
																<div id="message_panel" style="width: 90%; background-color:; margin: 10px auto;"></div>
															
															</div>
															<div>
																<div class="form-group" style="padding-top: 15px;">
																	<div class="col-sm-12">
																		<textarea id="message_input" style="width: 100%; height: 130px;"></textarea>
																	</div>
																</div>
															</div>
															<div style="margin: 25px auto;">
																<div class="form-group"
																	style="margin: 0 auto; text-align: center;">
																	<button id="send_message" type="submit" class="btn btn-default btn-lg" style="border: solid #A9A9A9 2px; border-radius: 10px;">发送</button>
																</div>
															</div>
														</div>
													</div>
												</div>
												
												
												<!--######################此处为历史消息-->
												<div role="tabpanel" class="tab-pane" id="history_message">
													<div class="tab-content-1" style="width: 100%; margin: 0px auto; background-color: white;">
														<div class="form-horizontal" role="form"
															style="margin-left: 0px;">
															<div class="tab-content-1" style="width: 100%; height: 680px; margin: 0 auto; background-color: #F5F5F5;">
																<div class="form-horizontal" role="form" style="margin-left: 0px;">

																	<div class="" style="width: 100%; height: 600px; background-color:; overflow: auto; border-bottom: solid #A9A9A9 1px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;">
																		<div id="his_message_panel" style="width: 90%; background-color:; margin: 10px auto;"></div>
																		
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
	$('#myTab a').click(function(e) {
		e.preventDefault()
		$(this).tab('show')
	})
	$(document).ready(function() {
		$("td").attr("style", "border-top: solid #333333 1px;");
		
		/**
		*解决接收推送的重复问题
		*/
		var toPushSpan = 0;
		var webSocket = null;
		init();
		var toUser = {};
		
		function init() {
			
		    if ('WebSocket' in window) {  
		        webSocket = new WebSocket('ws://chuangyejia.top/ChuangYeJia/chat/server');
		    } else if ('MozWebSocket' in window) {  
		        webSocket = new MozWebSocket('ws:chuangyejia.top/ChuangYeJia/chat/server');
		    }

			webSocket.onerror = function(event) {
				onError(event);
			};

			webSocket.onopen = function(event) {
				onOpen(event);
			};

			webSocket.onmessage = function(event) //接受客户端消息
			{
				onMessage(event);
			};
		}

		
		function onMessage(event) {
			var json = JSON.parse(event.data);
			toUser = json.toUser;
			if(json.notRead != null && json.first != null) {
				for(var i = 0; i < json.notRead.length; i++) {
					var article = $('<article></article>');
					article.attr("class", "uk-comment toUser_article");
					var header = $('<header></header>');
					header.attr("class", "uk-comment-header");
					header.appendTo(article);
					var img = $('<img />');
					img.attr("class", "uk-comment-avatar uk-border-rounded toUser_photo");
					img.attr("src", json.toUser.userPhoto);
					img.attr("alt", "图片正在玩命加载中...");
					img.attr("style", "width: 50px; height: 50px;");
					img.appendTo(header);
					var h4 = $('<h4></h4>');
					h4.attr("class", "uk-comment-title");
					h4.text(json.toUser.userNickName + ":" + json.notRead[i].messageSendTime);
					h4.appendTo(header);
					var div = $('<div></div>');
					div.attr("class", "uk-comment-meta");
					div.appendTo(header);
					var span = $('<span></span>');
					span.attr("class", "uk-h4");
					span.text(json.notRead[i].chatMessage);
					span.appendTo(div);
					
					article.appendTo($("#message_panel"));
				}
				json.notRead = null;//使用之后赋值为 null
				
				/*
				接收到历史消息
				*/
				if(json.historyMsg != null) {
					for(var i = 0; i < json.historyMsg.length; i++) {
						if(json.historyMsg[i].fromUserId == json.toUser.userId) {
							var article = $('<article></article>');
							article.attr("class", "uk-comment");
							var header = $('<header></header>');
							header.attr("class", "uk-comment-header");
							header.appendTo(article);
							var img = $('<img />');
							img.attr("class", "uk-comment-avatar uk-border-rounded");
							img.attr("src", json.toUser.userPhoto);
							img.attr("alt", "图片正在玩命加载中...");
							img.attr("style", "width: 50px; height: 50px;");
							img.appendTo(header);
							var h4 = $('<h4></h4>');
							h4.attr("class", "uk-comment-title");
							h4.text(json.toUser.userNickName + ":" + json.historyMsg[i].messageSendTime);
							h4.appendTo(header);
							var div = $('<div></div>');
							div.attr("class", "uk-comment-meta");
							div.appendTo(header);
							var span = $('<span></span>');
							span.attr("class", "uk-h4");
							span.text(json.historyMsg[i].chatMessage);
							span.appendTo(div);
							
							article.appendTo($("#his_message_panel"));
						} else {

							var article = $('<article></article>');
							article.attr("class", "uk-comment uk-comment-primary");
							var header = $('<header></header>');
							header.attr("class", "uk-comment-header");
							header.appendTo(article);
							var img = $('<img />');
							img.attr("class", "uk-comment-avatar uk-border-rounded");
							img.attr("src", '<s:property value="#session.user.userPhoto"/>');
							img.attr("alt", "图片正在玩命加载中...");
							img.attr("style", "width: 50px; height: 50px;float: right;");
							img.appendTo(header);
							var h4 = $('<h4></h4>');
							h4.attr("class", "uk-comment-title");
							h4.attr("style", "float: right;");
							h4.text("我" + ":" + json.historyMsg[i].messageSendTime);
							h4.appendTo(header);
							var div = $('<div></div>');
							div.attr("class", "uk-comment-meta uk-flex-right");
							div.appendTo(header);
							var span = $('<span></span>');
							span.attr("class", "uk-h4");
							span.text(json.historyMsg[i].chatMessage);
							span.appendTo(div);
							
							
							article.appendTo($("#his_message_panel"));
						}
					}
				}
				
			}
			
			if(json.sendOne != null) {
				
				var article = $('<article></article>');
				article.attr("class", "uk-comment uk-comment-primary");
				var header = $('<header></header>');
				header.attr("class", "uk-comment-header");
				header.appendTo(article);
				var img = $('<img />');
				img.attr("class", "uk-comment-avatar uk-border-rounded");
				img.attr("src", '<s:property value="#session.user.userPhoto"/>');
				img.attr("alt", "图片正在玩命加载中...");
				img.attr("style", "width: 50px; height: 50px;float: right;");
				img.appendTo(header);
				var h4 = $('<h4></h4>');
				h4.attr("class", "uk-comment-title");
				h4.attr("style", "float: right;");
				h4.text("我" + ":" + json.sendOne.messageSendTime);
				h4.appendTo(header);
				var div = $('<div></div>');
				div.attr("class", "uk-comment-meta uk-flex-right");
				div.appendTo(header);
				var span = $('<span></span>');
				span.attr("class", "uk-h4");
				span.text(json.sendOne.chatMessage);
				span.appendTo(div);
				
				article.appendTo($("#message_panel"));
				
				json.sendOne = null;//使用之后赋值为null
			}

			if(json.pushToUser != null && toPushSpan === 0) {
			  /**
				*解决重复问题
				*/
				toPushSpan = 1;
				var article = $('<article></article>');
				article.attr("class", "uk-comment");
				var header = $('<header></header>');
				header.attr("class", "uk-comment-header");
				header.appendTo(article);
				var img = $('<img />');
				img.attr("class", "uk-comment-avatar uk-border-rounded");
				img.attr("src", toUser.userPhoto);
				img.attr("alt", "图片正在玩命加载中...");
				img.attr("style", "width: 50px; height: 50px;");
				img.appendTo(header);
				var h4 = $('<h4></h4>');
				h4.attr("class", "uk-comment-title");
				h4.text(json.toUser.userNickName + ":" + json.pushToUser.messageSendTime);
				h4.appendTo(header);
				var div = $('<div></div>');
				div.attr("class", "uk-comment-meta");
				div.appendTo(header);
				var span = $('<span></span>');
				span.attr("class", "uk-h4");
				span.text(json.pushToUser.chatMessage);
				span.appendTo(div);
				
				article.appendTo($("#message_panel"));
			} else {
				/**
				*解决重复问题
				*/
				toPushSpan = 0;
			}
			if(json.toUser != null) {
				$(".toUser_photo").attr("src", json.toUser.userPhoto);
				$(".toUser_nickname").text(json.toUser.userNickName);
			}
		}
		
		function onOpen(event) {
			webSocket.send("<s:property value='#parameters.toUserId'/>"); //发送消息给服务器端
		}

		function onError(event) {
			alert(event.data);
		}

		$("#send_message").on('click', function() {
			webSocket.send($("#message_input").val()); //发送消息给服务器端
			$("#message_input").val("");
		});
		
	});	
	
</script>
</html>
