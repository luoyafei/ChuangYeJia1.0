<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("flag", "product");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


		<title>产品列表</title>

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

			.marketing .col-lg-4 {
				margin-bottom: 0px;
			}
		</style>


	</head>

	<body  style="background-color: #F5F5F5;">

		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			
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
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研产品</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见产品内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研产品</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见产品内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研产品</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见产品内页......</p>
								<br />
								<p style="float: right;"><a role="button" href="javascript:void(0)" class="btn btn-primary btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">更多内容</a></p>
								<br /><br /><br />
								<br /><br />
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="" src="<%=path %>/assets/img/project/project_list1.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div style="width: 50%;float: right;">
								<p style="font-size: 30px;padding: 0 auto;margin: 0 auto;">国家<span style="font-size: 62px;">最新</span>科研产品</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									人工智能3.0时代</p>
								<p style="font-size: 27px;padding: 0 auto;margin: 0 auto;">正式<span style="font-size: 38px;">开启</span></p>
								<p style="font-size: 15px;padding: 0 auto;margin-top: 5px; margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;详情请见产品内页......</p>
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
					<p style="float: right;">随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。<a role="button" href="/ChuangYeJia/pages/userConsole/product/create_product.jsp" class="btn btn-lg" style="padding: 4px 12px;border-radius: 30px;border: solid 2px;">创建产品</a></p>
					<h2 style="margin-top: 0;color: black;">产品列表</h2>
				</div>
			</div>
			<br/>
			<br/>
			<div id="myTabContent" class="tab-content" style="background-color: #FFFFFF; text-align: center;">
			      <div role="tabpanel" class="tab-pane fade active in" id="time" aria-labelledby="time-tab">
			      
							<div class="uk-grid row" id="gridAll" style="width: 100%;margin-left: 0px;">
							    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 flagToCloneAll">
									<div class="uk-thumbnail">
				                   		<figure class="uk-overlay uk-overlay-hover">
				                           <img src="" style="height: 194.15px;" class="uk-overlay-spin productCover" alt="正在玩命加载中请稍后...">
				                           <figcaption class="uk-overlay-panel uk-overlay-background  uk-overlay-bottom uk-overlay-slide-bottom">
				                             	 <p class="productPrice"></p>
				                           </figcaption> 
				                            
				                        </figure>
				                   		<div class="uk-thumbnail-caption uk-text-truncate">
					                   		<a href="" class="linkProduct">
					                   			<span style="color:#222222;">产品名称:</span>
					                   			&nbsp;&nbsp;<span class="productName"></span>
					                   		</a>
				                   		</div>
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
		        	
		        	$(document).ready(function() {
		        		var start = window.location.search;
		        		if(start.trim() == "") {
		        			start = 1;
		        		} else {
		        			try {
		        				start = parseInt(start.substr(7, start.length - 7));
		        			} catch (e) {
		        				start = 1;
		        			}
		        		}
		        			
		        		$.post("/ChuangYeJia/supportProducts!getproducts.action", {
		        			length : 12,
		        			start : start-1
		        		}, function(data, textStatus) {
		        			var count = data.count;
							var allPage = parseInt(count/12) + (count%12==0?0:1);
							
						for(var i = 0; i < data.ps.length-1; i++) {
							$("#gridAll").append($(".flagToCloneAll").clone().attr("class", "col-lg-3 col-md-4 col-sm-6 col-xs-12 cloneItemAll"));
						}
						for(var i = 0;i < data.ps.length; i++) {
							
							$(".productName").eq(i).text(data.ps[i].productName);
							$(".productPrice").eq(i).text("售价：" + (data.ps[i].productPrice==undefined?"暂不出售":(data.ps[i].productPrice+"￥")));
							$(".linkProduct").eq(i).attr("href", "getProductItem?item="+data.ps[i].productId);
							$(".productCover").eq(i).attr("src", data.ps[i].productCover);
						}
							
						$(".tcdPageCode").createPage({
			                pageCount:allPage,
			                current:start,
			                backFn:function(p){
			                	window.location.href = "/ChuangYeJia/pages/title/product_list.jsp?start=" + p;
			                	return;
			                }
			            });
		        		}, "json");
		        	});
		            
		        </script>
		
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
