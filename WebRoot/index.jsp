<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//用来区分导航栏bar字段的点击效果。
request.setAttribute("flag", "index");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

		<title>YANSPRO平台</title>

		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
		<link href="<%=path%>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">
		
		<!-- Bootstrap core JavaScript
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>

		
		<!-- uikit -->
		<script src="<%=path%>/assets/uikit/uikit.js"></script>
		<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>
		<link href="<%=path%>/assets/uikit/slideshow.css" rel="stylesheet"/>
		<script src="<%=path%>/assets/uikit/slideshow.js"></script>

		
		
		<style type="text/css">
			body {
				font-family: "微软雅黑";
				padding-bottom: 0px;
				overflow-x: hidden;
			}

			li a {
				color: snow;
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

	<body>
	
		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />
			
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="assets/img/indexpage/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span><img src="assets/img/logo.png" style="width: 18%; margin-bottom: 0px;padding-bottom: 0px;"></span>
							</div>

							<h1 style="margin-top: 0px; margin-bottom: 0px;color: #398BE5;">创业+</h1>
							<p style="margin-bottom: 0px;">
								<br> 欢迎来到创业加网站，在这里，我们能为你提供最具有潜力的项目，最可靠的资源，最优秀的团队，最专业的分析
							</p>
							<p style="padding-top: 10px;margin-bottom: 0px;">
								<a class="btn btn-primary" href="<%=path %>/pages/startups/create_startups.jsp" role="button" style="border-radius: 20px;">创建你的公司</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;">
			
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">WHAT&nbsp;&nbsp;&nbsp;&nbsp;WE&nbsp;&nbsp;&nbsp;&nbsp;DO</p>
					<p style="float: right;">随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。</p>
					<h2 style="margin-top: 0;color: black;">公司分类</h2>
				</div>
			</div>
			<div class="marketing-nav">
				<ul class="nav nav-tabs marketing-nav-content" role="tablist">
					<li role="presentation" class="active"><a href="#">综合</a></li>
					<li role="presentation"><a href="#" style="color: black;">按更新排列</a></li>
					<li role="presentation"><a href="#" style="color: black;">按热度排列</a></li>
					<li role="presentation"><a href="#" style="color: black;">按内容排列</a></li>
					<li role="presentation"><a href="#" style="color: black;">按运行阶段排列</a></li>
				</ul>
			</div>

			
			<div class="uk-margin">
			
				<div class="uk-grid">
				    <div class="uk-width-medium-1-4">
						<div class="uk-thumbnail">
	                   		<figure class="uk-overlay uk-overlay-hover">
	                           <img src="" style="height: 194.15px;" class="uk-overlay-spin startupsCover" alt="正在玩命加载中请稍后...">
	                           <figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
	                             	 <a class="startupsLeader" href=""></a>
	                             </figcaption> 
	                            
	                         </figure>
	                   		<div class="uk-thumbnail-caption uk-text-truncate">
		                   		<a href="" class="linkStartups">
		                   			<span style="color:#222222;">公司名称:</span>
		                   			&nbsp;&nbsp;<span class="startupsName"></span>
		                   		</a>
	                   		</div>
	                   	</div>
					</div>
				     <div class="uk-width-medium-1-4">
						<div class="uk-thumbnail">
	                   		<figure class="uk-overlay uk-overlay-hover">
	                           <img src="" style="height: 194.15px;" class="uk-overlay-spin startupsCover" alt="正在玩命加载中请稍后...">
	                           <figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
	                             	 <a class="startupsLeader" href=""></a>
	                             </figcaption> 
	                            
	                         </figure>
	                   		<div class="uk-thumbnail-caption uk-text-truncate">
		                   		<a href="" class="linkStartups">
		                   			<span style="color:#222222;">公司名称:</span>
		                   			&nbsp;&nbsp;<span class="startupsName"></span>
		                   		</a>
	                   		</div>
	                   	</div>
					</div>
					 <div class="uk-width-medium-1-4">
						<div class="uk-thumbnail">
	                   		<figure class="uk-overlay uk-overlay-hover">
	                           <img src="" style="height: 194.15px;" class="uk-overlay-spin startupsCover" alt="正在玩命加载中请稍后...">
	                           <figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
	                             	 <a class="startupsLeader" href=""></a>
	                             </figcaption> 
	                            
	                         </figure>
	                   		<div class="uk-thumbnail-caption uk-text-truncate">
		                   		<a href="" class="linkStartups">
		                   			<span style="color:#222222;">公司名称:</span>
		                   			&nbsp;&nbsp;<span class="startupsName"></span>
		                   		</a>
	                   		</div>
	                   	</div>
					</div>
					 <div class="uk-width-medium-1-4">
						<div class="uk-thumbnail">
	                   		<figure class="uk-overlay uk-overlay-hover">
	                           <img src="" style="height: 194.15px;" class="uk-overlay-spin startupsCover" alt="正在玩命加载中请稍后...">
	                           <figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
	                             	 <a class="startupsLeader" href=""></a>
	                             </figcaption> 
	                            
	                         </figure>
	                   		<div class="uk-thumbnail-caption uk-text-truncate">
		                   		<a href="" class="linkStartups">
		                   			<span style="color:#222222;">公司名称:</span>
		                   			&nbsp;&nbsp;<span class="startupsName"></span>
		                   		</a>
	                   		</div>
	                   	</div>
					</div>
				</div>
			</div>

			
			<script type="text/javascript">
			
				$(document).ready(function() {
					$.post('supportStartups!getStartups.action', {}, function(data, textStatus) {
						if(textStatus == 'success') {
							
							for(var i = 0;i < data.stl.length; i++) {
								
								$(".startupsName").eq(i).text(data.stl[i].startupsName);
								$(".linkStartups").eq(i).attr("href", "getStartupsItem?item="+data.stl[i].startupsId);
								$(".startupsLeader").eq(i).text("总监："+data.stl[i].startupsLeader.userNickName);
								$(".startupsLeader").eq(i).attr("href", "getUserMark?mark="+data.stl[i].startupsLeader.userId);
								$(".startupsLeader").eq(i).attr("style", "color: #FFFFFF;");
								$(".startupsCover").eq(i).attr("src", data.stl[i].startupsCover);
							}
						} else {
							alert("网络出错！请刷新重试！");
						}
					}, 'json');
				}); 
			</script>
			
			<div class="jumbotitle">
				<div class="container">
					<a href="<%=path %>/pages/title/startups_list.jsp"class="btn btn-lg" style="border-radius: 20px; border: solid black 2px; float: right;margin-top: 20px;">更多内容</a>
				</div>
			</div>
		</div>




		<div class="container marketing" style="background-color: white; padding:50px 0px">

			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<div class="uk-grid">
					    <div class="uk-width-1-2">
					    	<p>WHO&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;AM</p>
							<h2 style="margin-top: 0;color: black;">合伙人</h2>
						</div>
					    <div class="uk-width-1-2">
							<p class="uk-text-right">随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。</p>
						</div>
					</div>
				</div>
			</div>

			<div class="uk-margin">
				<div class="uk-grid" id="gridAll">
				    <div class="uk-width-medium-1-5 flagToCloneAll">
						<div class="uk-thumbnail">
	                   		<figure class="uk-overlay uk-overlay-hover">
	                           <img src="" style="height: 194.15px;width:194.15px;" class="uk-overlay-spin userCoverAll img-circle" alt="正在玩命加载中请稍后...">
	                           		<figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
	                             		<span class="userIntroduceAll"></span>
	                             	</figcaption> 
	                         </figure>
	                   		<div class="uk-thumbnail-caption">
	                   			<ul class="uk-list uk-list-line">
									<li class="categoryAll"></li>
									<li>
										<span class="glyphicon glyphicon-user" aria-hidden="true">
											<a class="nicknameAll" href="" style="color: #1d8acb;"></a>
										</span>
									</li>
								</ul>
	                   		</div>
	                   	</div>
					</div>
				</div>
			</div>
			<div class="jumbotitle">
				<div class="container">
					<a href="<%=path %>/pages/title/copartner_list.jsp" class="btn btn-lg" style="border-radius: 20px; border: solid black 2px; float: right;margin-top: 20px;margin-bottom: 20px;">更多内容</a>
				</div>
			</div>
		</div>
		
		
	<jsp:include page="pages/module/bottom.jsp" flush="true" />	
	</body>
	<script>
		$(document).ready(function() {
			$("td").attr("style", "border-top: solid #333333 1px;");
			
			$.post('provideUsers!getUsers.action', {
				start : "5,0",
				length : 5
			}, function(data, textStatus) {
				if(textStatus == "success") {
					
					$(".cloneItemAll").remove();
					
					var all = data.all;
					
					for(var i = 0; i < all.length-1; i++) {
						$("#gridAll").append($(".flagToCloneAll").clone().attr("class", "uk-width-medium-1-5 cloneItemAll"));
					}
					$(".userCoverAll").each(function(index){
						$(this).attr("src", data.all[index].userPhoto);
					});
					$(".userIntroduceAll").each(function(index){
						var introduce = "暂无";
						if(data.all[index].userIntroduce!=undefined)
							introduce = data.all[index].userIntroduce;
						$(this).text("用户经历： " + introduce);
					});
					$(".nicknameAll").each(function(index){
						$(this).text(data.all[index].userNickName);
					});
					$(".nicknameAll").each(function(index){
						$(this).attr("href", "/ChuangYeJia/getUserMark.action?mark="+data.all[index].userId);
					});
					$(".categoryAll").each(function(index){
						var cc = data.all[index].copartnerCategory;
						$(this).text(cc == "" || cc == null ? "未定" : cc);
					});
					
				} else {
					alert("网络出错！请刷新重试！");
				}
			}, 'json');
 		});
		
	</script>
	
</html>
