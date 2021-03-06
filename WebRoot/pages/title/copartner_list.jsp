<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("flag", "partner");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

		<title>合伙人列表</title>

		<!-- Bootstrap core JavaScript
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=path %>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path %>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path %>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
	
		<!-- Bootstrap core CSS -->
		<link href="<%=path %>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=path %>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
		<link href="<%=path %>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">

		<!-- uikit -->
		<script src="<%=path%>/assets/uikit/uikit.js"></script>
		<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>
		<link href="<%=path%>/assets/uikit/tooltip.css" rel="stylesheet"/>
		<script src="<%=path%>/assets/uikit/tooltip.js"></script>
		
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
			
			.uk-grid {
   				margin-left: 0px;
   			}
			
			.row {
   				text-align: center;
   			}

			.marketing .col-lg-4 {
				margin-bottom: 0px;
			}
		</style>


	</head>

	<body style="background-color: #F5F5F5;">

		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研项目</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见公司内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="second-slide" src="<%=path %>/assets/img/project/project_list1.png" alt="Second slide">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研项目</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见公司内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide" src="<%=path %>/assets/img/project/project_list1.png" alt="Third slide">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研项目</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见公司内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide" src="<%=path %>/assets/img/project/project_list1.png" alt="Third slide">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研项目</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见公司内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
			</div>

			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				<span aria-hidden="true"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				<span aria-hidden="true"></span>
			</a>
		</div>
		
		
		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 78%;">
			
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">WHAT&nbsp;&nbsp;&nbsp;&nbsp;WE&nbsp;&nbsp;&nbsp;&nbsp;DO</p>
					<p style="float: right;">随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。<a role="button" href=<s:if test="#session.user == null">"/ChuangYeJia/pages/signIn/register.jsp"</s:if><s:else>"/ChuangYeJia/pages/userConsole/complete_data.jsp"</s:else> class="btn btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">成为合伙人</a></p>
					<h2 style="margin-top: 0;" style="color: black;">合伙人分类</h2>
				</div>
			</div>

			<div class="categoryTab">
			    <ul id="copartnerCategory" class="nav nav-tabs" role="tablist">
			      <li role="presentation" class="tabRole" onclick="changeCategory(5)">
			      		<a href="#time" role="tab" data-toggle="tab" id="time-tab" style="color: #398BE5;" aria-controls="home" aria-expanded="true">综合</a>
			      </li>
			      <li class="tabRole" role="presentation" onclick="changeCategory(1)">
			      		<a href="#fund" role="tab" data-toggle="tab" id="fund-tab" style="color: #398BE5;" aria-controls="fund" aria-expanded="true">资金</a>
			      </li>
			      <li class="tabRole" role="presentation" onclick="changeCategory(2)">
			      		<a href="#technology" role="tab" data-toggle="tab" id="technology-tab" style="color: #398BE5;" aria-controls="technology" aria-expanded="true">技术</a>
			      </li>
			      <li class="tabRole" role="presentation" onclick="changeCategory(3)">
			      		<a href="#popularize" role="tab" data-toggle="tab" id="popularize-tab" style="color: #398BE5;" aria-controls=popularize aria-expanded="true">推广</a>
			      </li>
			      <li class="tabRole" role="presentation" onclick="changeCategory(4)">
			      		<a href="#operation" role="tab" data-toggle="tab" id="operation-tab" style="color: #398BE5;" aria-controls="operation" aria-expanded="true">运营</a>
			      </li>
			      <li class="tabRole" role="presentation" onclick="changeCategory(0)">
			      		<a href="#other" role="tab" data-toggle="tab" id="other-tab" style="color: #398BE5;" aria-controls="other" aria-expanded="true">其他</a>
			      </li>
			    </ul>
			    
			    <div id="myTabContent" class="tab-content" style="background-color: #FFFFFF; text-align: center;">
			      <div role="tabpanel" class="tab-pane fade active in" id="time" aria-labelledby="time-tab">

						<div class="uk-margin">
							<div class="uk-grid row" id="gridAll">
							    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 flagToCloneAll" style="border-right: ">
									<div class="uk-thumbnail">
				                   		<figure class="uk-overlay uk-overlay-hover">
				                           <img src="" style="height: 194.15px;width:194.15px;" class="uk-overlay-spin userCoverAll img-circle" alt="正在玩命加载中请稍后...">
				                           		<figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
				                             		<div class="uk-panel uk-panel-box-rmBnC uk-width-1-1 uk-text-truncate">
				                             			<span class="userIntroduceAll"></span>
				                             		</div>
				                             	</figcaption> 
				                         </figure>
				                   		<div class="uk-thumbnail-caption">
				                   			<ul class="uk-list uk-list-line">
												<li class="categoryAll"></li>
												<li>
													<span class="glyphicon glyphicon-user" aria-hidden="true">
														<a class="nicknameAll" href="" style="color: #1d8acb;">
														</a>
													</span>
												</li>
											</ul>
				                   		</div>
				                   	</div>
								</div>
							</div>
						</div>  
						
				<div class="fenye" style="width:100%;">
			        <style>
			            .tcdPageCode{padding: 15px 20px;text-align: left;color: #ccc;}
			            .tcdPageCode a{width: 60px;text-align: center;font-size: 2em;display: inline-block;color: #428bca;display: inline-block;height: 60px;	line-height: 60px;	padding: 0 10px;border: 1px solid #ddd;	margin: 0 2px;border-radius: 9px;vertical-align: middle;}
			            .tcdPageCode a:hover{text-decoration: none;border: 1px solid #428bca;}
			            .tcdPageCode span.current{width: 120px;text-align: center;font-size: 2em;display: inline-block;height: 60px;line-height: 60px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;border-radius: 4px;vertical-align: middle;}
			            .tcdPageCode span.disabled{	width: 120px;text-align: center;font-size: 2em;display: inline-block;height: 60px;line-height: 60px;padding: 0 10px;margin: 0 2px;	color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;}
			        </style>
			        <div class="tcdPageCode" style="text-align: center;"></div>
			        <script src="jquery.page.js"></script>
			        <script>
			        	
			        	var category = 5;
	        			var len = 12;
				        function changeCategory(type) {
				    		category = type;
				    		window.location.href = "/ChuangYeJia/pages/title/copartner_list.jsp?start=1&type="+type;
				    	}
				        
				        function getAllItem(type, start, length) {
				        	
				        	if(type == 5) {
				        		for(var i = 0; i < $(".tabRole").length; i++) {
				        			if(i == 0) {
				        				$(".tabRole").eq(i).attr("class", "tabRole active");
				        			} else
				        				$(".tabRole").eq(i).attr("class", "tabRole");
				        		}
							} else if(type == 1) {
								for(var i = 0; i < $(".tabRole").length; i++) {
				        			if(i == 1) {
				        				$(".tabRole").eq(i).attr("class", "tabRole active");
				        			} else
				        				$(".tabRole").eq(i).attr("class", "tabRole");
				        		}
							} else if(type == 2) {
								for(var i = 0; i < $(".tabRole").length; i++) {
				        			if(i == 2) {
				        				$(".tabRole").eq(i).attr("class", "tabRole active");
				        			} else
				        				$(".tabRole").eq(i).attr("class", "tabRole");
				        		}
							} else if(type == 3) {
								for(var i = 0; i < $(".tabRole").length; i++) {
				        			if(i == 3) {
				        				$(".tabRole").eq(i).attr("class", "tabRole active");
				        			} else
				        				$(".tabRole").eq(i).attr("class", "tabRole");
				        		}
							} else if(type == 4) {
								for(var i = 4; i < $(".tabRole").length; i++) {
				        			if(i == 4) {
				        				$(".tabRole").eq(i).attr("class", "tabRole active");
				        			} else
				        				$(".tabRole").eq(i).attr("class", "tabRole");
				        		}
							} else if(type == 0) {
								for(var i = 0; i < $(".tabRole").length; i++) {
				        			if(i == 5) {
				        				$(".tabRole").eq(i).attr("class", "tabRole active");
				        			} else
				        				$(".tabRole").eq(i).attr("class", "tabRole");
				        		}
							}
				        	
				        	
				        	
				        	$.post("/ChuangYeJia/provideUsers!getUsers.action", {
			        			start : type+","+start,
				             	length : length
			        		}, function(data, textStatus) {
			        			
			        			$(".cloneItemAll").remove();
			        			
								var categoryType = type;
								var startCount = start;
						
								var all;
								var allCount;
								var cc;//合伙人类型
								if(categoryType == 5) {
									all = data.all;
									allCount = data.allCount;
								} else if(categoryType == 1) {
									all = data.fund;
									allCount = data.fundCount;
									cc = "资金";
								} else if(categoryType == 2) {
									all = data.technology;
									allCount = data.technologyCount;
									cc = "技术";
								} else if(categoryType == 3) {
									all = data.popularize;
									allCount = data.popularizeCount;
									cc = "推广";
								} else if(categoryType == 4) {
									all = data.operation;
									allCount = data.operationCount;
									cc = "运营";
								} else if(categoryType == 0) {
									all = data.other;
									allCount = data.otherCount;
									cc = "其他";
								}
			        			for(var i = 0; i < all.length-1; i++) {
									$("#gridAll").append($(".flagToCloneAll").clone().attr("class", "col-lg-3 col-md-4 col-sm-6 col-xs-12 cloneItemAll"));
								}
								$(".userCoverAll").each(function(index){
									$(this).attr("src", all[index].userPhoto);
								});
								$(".userIntroduceAll").each(function(index){
									var introduce = "暂无";
									if(all[index].userIntroduce!=undefined)
										introduce = all[index].userIntroduce;
									$(this).text("用户经历： " + introduce);
								});
								$(".nicknameAll").each(function(index){
									$(this).text(all[index].userNickName);
								});
								$(".nicknameAll").each(function(index){
									$(this).attr("href", "/ChuangYeJia/getUserMark.action?mark="+all[index].userId);
								});
								$(".categoryAll").each(function(index){
									//var cc = data.all[index].copartnerCategory;
									if(type != 5) {
										$(this).text(cc);	
									} else
										$(this).text(data.all[index].copartnerCategory);
									
								});
			        			
								var allPage = parseInt(allCount/12) + (allCount%12==0?0:1);
								
								$(".tcdPageCode").createPage({
					                pageCount:allPage,
					                current:startCount,
					                backFn:function(p){
					                	window.location.href = "/ChuangYeJia/pages/title/copartner_list.jsp?start="+p+"&type="+type;
					                	return;
					                }
					            });
			        		}, "json");
							
						}
			        </script>
		    	</div>
			</div>
	    </div>
	  </div>
	</div>

		
	<jsp:include page="../module/bottom.jsp" flush="true" />
	</body>
	<script>
		$('#copartnerCotegory a').click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});
	
		$(document).ready(function() {
			$("td").attr("style", "border-top: solid #333333 1px;");
			
			var params = window.location.search;
			var start;
			var type;
    		if(params.trim() == "") {
    			start = 1;
    			type = 5;
    		} else {
    			try {
    				var arrayParam = params.split("&");
    				start = parseInt(arrayParam[0].substr(7, arrayParam[0].length));
    				type = parseInt(arrayParam[1].substr(5, arrayParam[1].length));
    				
    			} catch (e) {
    				start = 1;
    				type = 5;
    			}
    		}
			getAllItem(type, start, len);
		});
		
	</script>
	
		
</html>
