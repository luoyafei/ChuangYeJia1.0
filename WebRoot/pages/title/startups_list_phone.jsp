<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("flag", "startups");
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

		<title>公司列表</title>

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
		


	</head>

	<body style="background-color: #F5F5F5;">
		<div class="container marketing" style="background-color: #F5F5F5; padding:0px 0px;width: 78%;">
			
			<h2 align="center">查看公司信息</h2>
			<hr>
			<div class="marketing-nav">
				<ul class="nav nav-tabs marketing-nav-content" role="tablist">
					<li role="presentation" class="active">
						<a href="#all" role="tab" data-toggle="tab" id="all-tab" style="color: #000000;" aria-controls="all" aria-expanded="true">
							综合
						</a>
					</li>
					<li role="presentation">
						<a href="#update" role="tab" data-toggle="tab" id="update-tab" style="color: #000000;" aria-controls="update" aria-expanded="true">
							按更新排列
						</a>
					</li>
					<li role="presentation">
						<a href="#hot" role="tab" data-toggle="tab" id="hot-tab" style="color: #000000;" aria-controls="hot" aria-expanded="true">
							按热度排列
						</a>
					</li>
					<li role="presentation">
						<a href="#content" role="tab" data-toggle="tab" id="content-tab" style="color: #000000;" aria-controls="content" aria-expanded="true">
							按内容排列
						</a>
					</li>
					<li role="presentation">
						<a href="#stage" role="tab" data-toggle="tab" id="stage-tab" style="color: #000000;" aria-controls="stage" aria-expanded="true">
							按阶段排列
						</a>
					</li>
				</ul>
			</div>

			<div id="myTabContent" class="tab-content" style="background-color: #FFFFFF">
			      <div role="tabpanel" class="tab-pane fade active in" id="time" aria-labelledby="time-tab">
			      
			      		<div class="uk-margin">
			
							<div class="uk-grid" id="gridAll">
							
							    <div class="uk-width-medium-1-5 flagToCloneAll">
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
			      </div>
			</div>
			
			<nav id="paginationAll" class="text-center">
		      <ul class="pagination" id="pagId">
		        <li class="pagination_All active"><span>1</span></li>
		        <li class="pagination_All"><span>2</span></li>
                <li class="pagination_All"><span>3</span></li>
                <li class="pagination_All"><span>4</span></li>
                <li class="pagination_All"><span>5</span></li>
	            <li class="pagination_All"><span>...</span></li>
           		<li class="pagination_All"><span>7</span></li>
		     </ul>
		   </nav>
		</div>
	</body>
	<script>

		$(document).ready(function() {
			getAllStartups(1, 10);
			
			$(".pagination_All").bind("click", function(a) {
				if($(this).text() != "...") {
					$(".pagination_All").each(function(index) {
						$(".pagination_All").eq(index).attr("class", "pagination_All");
					})

					getAllStartups($(this).text(), 10);
				}
			});
			 
		});
	
	
		function getAllStartups(start, length) {
			
			$.post('supportStartups!getStartups.action', {
				start : start-1,
				length : length
			}, function(data, textStatus) {
				if(textStatus == 'success') {
					$(".cloneItemAll").remove();
					
					var count = data.count;
					var allPage = parseInt(count/length) + (count%length==0?0:1);

					var pa1 = $(".pagination_All").eq(0);
					var pa2 = $(".pagination_All").eq(1);
					var pa3 = $(".pagination_All").eq(2);
					var pa4 = $(".pagination_All").eq(3);
					var pa5 = $(".pagination_All").eq(4);
					var paSpan = $(".pagination_All").eq(5);
					var pa999 = $(".pagination_All").eq(6);

					if(allPage >= 3 && start <= (allPage*1-5)) {
						if(start==1) {
							pa1.html("<span>" + (start*1) + "</span>");
							pa2.html("<span>" + (start*1+1) + "</span>");
							pa3.html("<span>" + (start*1+2) + "</span>");
							pa4.html("<span>" + (start*1+3) + "</span>");
							pa5.html("<span>" + (start*1+4) + "</span>");
							paSpan.html("<span>...</span>");
							pa999.html("<span>" + allPage*1 + "</span>");
						} else if(start == 2) {
							pa1.html("<span>" + (start*1-1) + "</span>");
							pa2.html("<span>" + (start*1) + "</span>");
							pa3.html("<span>" + (start*1+1) + "</span>");
							pa4.html("<span>" + (start*1+2) + "</span>");
							pa5.html("<span>" + (start*1+3) + "</span>");
							paSpan.html("<span>...</span>");
							pa999.html("<span>" + allPage*1 + "</span>");
						} else {
							pa1.html("<span>" + (start*1-2) + "</span>");
							pa2.html("<span>" + (start*1-1) + "</span>");
							pa3.html("<span>" + (start*1) + "</span>");
							pa4.html("<span>" + (start*1+1) + "</span>");
							pa5.html("<span>" + (start*1+2) + "</span>");
							paSpan.html("<span>...</span>");
							pa999.html("<span>" + allPage*1 + "</span>");
						}
						
						
					} else if(allPage >= 7 && start > (allPage*1-5)) {
						
						pa1.html("<span>" + (allPage*1-6) + "</span>");
						pa2.html("<span>" + (allPage*1-5) + "</span>");
						pa3.html("<span>" + (allPage*1-4) + "</span>");
						pa4.html("<span>" + (allPage*1-3) + "</span>");
						pa5.html("<span>" + (allPage*1-2) + "</span>");
						paSpan.html("<span>"+ (allPage*1-1) +"</span>");
						pa999.html("<span>" + (allPage*1) + "</span>");
					} else if(allPage == 7) {
						pa1.html("<span>" + 1 + "</span>");
						pa2.html("<span>" + 2 + "</span>");
						pa3.html("<span>" + 3 + "</span>");
						pa4.html("<span>" + 4 + "</span>");
						pa5.html("<span>" + 5 + "</span>");
						paSpan.html("<span>"+ 6 +"</span>");
						pa999.html("<span>" + 7 + "</span>");
					}  else if(allPage < 7) {
						pa1.html("<span>" + 1 + "</span>");
						pa2.html("<span>" + 2 + "</span>");
						pa3.html("<span>" + 3 + "</span>");
						pa4.html("<span>" + 4 + "</span>");
						pa5.html("<span>" + 5 + "</span>");
						paSpan.html("<span>"+ 6 +"</span>");
						pa999.html("<span>" + 7 + "</span>");
						
						if(allPage == 6)
							pa999.hide();
						else if(allPage == 5) {
							pa999.hide();
							paSpan.hide();
						} else if(allPage == 4) {
							pa999.hide();
							paSpan.hide();
							pa5.hide();
						} else if(allPage == 3) {
							pa999.hide();
							paSpan.hide();
							pa5.hide();
							pa4.hide();
						} else if(allPage == 2) {
							pa999.hide();
							paSpan.hide();
							pa5.hide();
							pa4.hide();
							pa3.hide();
						} else if(allPage == 1) {
							pa999.hide();
							paSpan.hide();
							pa5.hide();
							pa4.hide();
							pa3.hide();
							pa2.hide();
						}
					}
					
					$(".pagination_All").each(function(index) {
						if($(".pagination_All").eq(index).text() == start) {
							$(this).attr("class", "pagination_All active");
						} else {
							$(this).attr("class", "pagination_All");
						}
						
					});
					
					
					
					for(var i = 0; i < data.stl.length-1; i++) {
						$("#gridAll").append($(".flagToCloneAll").clone().attr("class", "uk-width-medium-1-5 cloneItemAll"));
					}
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
			
		}
		
	</script>
	
		
</html>
