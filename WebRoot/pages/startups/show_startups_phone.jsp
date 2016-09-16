<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.chuangyejia.bean.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			公司内容展现
		</title>
		
		
		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
		<link href="<%=path%>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">
		
		<script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
		
		
		<!-- uikit -->
		<script src="<%=path%>/assets/uikit/uikit.js"></script>
		<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>
		<link href="<%=path%>/assets/uikit/slideshow.css" rel="stylesheet"/>
		<script src="<%=path%>/assets/uikit/slideshow.js"></script>
			
	</head>

	<body style="background-color: #F5F5F5;">
		

		
		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 78%;">
		
			<h2 align="center">公司内容展现</h2>

			<div class="uk-block uk-block-muted" style="width:100%;height: 400px;">

                <div class="uk-container">

                    <div class="uk-grid uk-grid-match" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-2 uk-row-first">
                            <div class="uk-panel">
                             	<div class="uk-thumbnail uk-thumbnail-large">
                             		
                             		<div class="uk-slidenav-position" data-uk-slideshow>
                                        <ul style="height: 197px;" class="uk-slideshow" data-uk-slideshow="{autoplay:true}">
                                            <li style="height: 197px;" class="uk-active" aria-hidden="false"><div style="background-image: url(<s:property value='#request.sts.startupsPhoto1'/>);" class="uk-cover-background uk-position-cover"></div><canvas style="width: 100%; height: auto; opacity: 0;" height="400" width="800"></canvas></li>
                                            <li class="" style="height: 197px;" aria-hidden="true"><div style="background-image: url(<s:property value='#request.sts.startupsPhoto2'/>);" class="uk-cover-background uk-position-cover"></div><canvas style="width: 100%; height: auto; opacity: 0;" height="400" width="800"></canvas></li>
                                            <li class="" style="height: 197px;" aria-hidden="true"><div style="background-image: url(<s:property value='#request.sts.startupsPhoto3'/>);" class="uk-cover-background uk-position-cover"></div><canvas style="width: 100%; height: auto; opacity: 0;" height="400" width="800"></canvas></li>
                                        </ul>
                                        <ul class="uk-dotnav uk-dotnav-contrast uk-position-bottom uk-text-center uk-flex-center">
									        <li data-uk-slideshow-item="0"><a href=""></a></li>
									        <li data-uk-slideshow-item="1"><a href=""></a></li>
									        <li data-uk-slideshow-item="2"><a href=""></a></li>
									    </ul>
                                    </div>
									<%-- <img  style="height: 300px;" src='<s:property value="#session.user.userPhoto"/>' /> --%>
								</div>
                            </div>
                        </div>
                        <div class="uk-width-medium-1-2">
                            <div class="uk-panel">
                                <ul class="uk-list uk-list-line">
									<li>公司名称:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.sts.startupsName"/></span></li>
									<li>服务类型:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.sts.startupsServiceType"/></span></li>
									<li>运营阶段:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.sts.startupsOperationStage"/></span></li>
									<li>合伙人需求:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.sts.startupsCopartnerRequire"/></span></li>
									<li>所属高校:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.sts.startupsAddress"/></span></li>
								</ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

			<div class="content-main-mid" style="margin-top: 10px;overflow: auto;">
				<div style="width: 80%;height: 100%;margin: 0 auto;border-bottom: dashed #A9A9A9 1px;">
					<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title project_brief">公司简介</h3>
					  </div>
					  <div class="panel-body">
					  	
					  	<div class="uk-grid">
						    <div class="uk-width-1-2">
						    	<div class="uk-cover iframeDiv">
								    <iframe src='<s:property value="#request.sts.startupsVideo"/>' style="width: 100%; height: 100%;" class="iframeSrc" frameborder=0 allowfullscreen></iframe>
								</div>
						    </div>
						    <div class="uk-width-1-2">
						    简介：
						    	<span>
							    	<s:property value="#request.sts.startupsBrief"/>
							    </span>
							</div>
						</div>
					  </div>
					</div>
				</div>
			</div>

			<div style="width: 80%;height: 80px;margin: 0 auto;">
				<div class="main-left" style="width: 50%;text-align: center;height: 100%;float: left;padding-top: 20px;">
						<s:if test="#session.user != null">
							<a href="<%=path %>/pages/chat/chat.jsp?toUserId=<s:property value='#request.sts.startupsLeader.userId'/>" class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;">联系ta</a>
						</s:if>
						<s:else>
							<a class="btn btn-default" onclick="alert('请先进行登陆操作后再进行聊天！');" style="border: solid #A9A9A9 2px; border-radius: 10px;">联系ta</a>
						</s:else>
				</div>
				<div class="main-right" style="width: 50%;text-align: center;height: 100%;float: left;padding-top: 20px;">
					<a class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;" href="<%=path %>/pages/userConsole/apply/apply_join.jsp?join=<s:property value='#request.sts.startupsId'/>">申请加入</a>
				</div>
			</div>

			<div style="margin-top: 20px;">
				
				<ul class="nav nav-tabs" role="tablist" id="myTab">
					<li role="presentation" class="active" style="width: 33%;text-align: center;"><a href="#home" role="tab" data-toggle="tab" style="color: black;">公司详情</a></li>
					<li role="presentation" style="width: 33%;text-align: center;"><a href="#profile" role="tab" data-toggle="tab" style="color: black;">公司成员</a></li>
					<li role="presentation" style="width: 34%;text-align: center;"><a href="#messages" role="tab" data-toggle="tab" style="color: black;">创业产品</a></li>
				</ul>
			
			</div>

			<div class="tab-content">

				<!-- 公司详情 -->
				<div role="tabpanel" class="tab-pane active" id="home">
					<div style="width: 80%;margin: 20px auto;">
						<span>
							<s:property value="#request.sts.startupsDetail"/>
						</span>
					</div>
				</div>
				
				
				<!-- 公司成员 -->
				<div role="tabpanel" class="tab-pane" id="profile">
					<div style="width: 80%;margin: 30px auto;">

						<div class="" style="width: 100%;height: 100px;padding-bottom: 20px;border-bottom: dashed #A9A9A9 1px;">
							<div style="width: 20%;height: 100%;float: left;">
								<h4>公司总监</h4>
							</div>
							<div style="width: 80%;height: 100%;float: right;">
								<div style="width: 100px;height: 100%;">
									<a href="getUserMark?mark=<s:property value='#request.sts.startupsLeader.userId'/>">
										<img src='<s:property value="#request.sts.startupsLeader.userPhoto"/>' alt="logo.jpg" style="width: 80px;height: 80px;"  class="img-circle" />
										<button class="btn btn-sm" style="width: 70px;overflow: hidden;">
											<s:property value="#request.sts.startupsLeader.userNickName"/>
										</button>
									</a>
								</div>
							</div>
						</div>

						<div class="" style="width: 100%;height: 80%;margin-top: 20px;">
							<div style="width: 20%;height: 100%;float: left;">
								<h4>公司成员</h4>
							</div>

							<div style="width: 80%;float: right;margin-top:10px;margin-bottom: 20px;">
								<div class="row">
								
									<s:iterator value="#request.sts.copartner" var="x">
										<div class="col-md-2">
											<a href="getUserMark?mark=<s:property value='#x.userId' />">
												<img data-holder-rendered="true" src="<s:property value="#x.UserPhoto" />" alt="图片加载失败" style="width: 80px; height: 80px;" class="img-circle" />
												<button class="btn btn-sm" style="width: 70px;overflow: hidden;">
													<s:property value="#x.userNickName" />
												</button>
											</a>
									    </div>
									</s:iterator>
									
									<br /><br />
								</div>
							</div>
							<hr />
						</div>
						
					</div>
				</div>

				<!-- 创业产品  -->
				<div role="tabpanel" class="tab-pane" id="messages">
					<div style="width: 80%;margin: 30px auto;">
						<div class="" style="width: 100%;height: 100px;">
							<div style="width: 20%;height: 100%;float: left;">
								<h4>创业产品</h4>
							</div>
							<div style="width: 80%;float: right;overflow-y: auto;" id="productField">
					
								<a class="uk-thumbnail productHref">
                                    <img src="" alt="" class="productConver" style="width: 200px;height: 100px;">
                                    <div class="uk-thumbnail-caption productName" style="width: 200px;white-space: nowrap;overflow: hidden;">
                                    尚未创建产品
                                    </div>
                                </a>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<s:if test="#session.user != null && #session.user.userId.equals(item)">	
			<div style="text-align: center;" >
				<div class="uk-button-group">
				    <a class="uk-button uk-button-primary uk-button-large uk-width-1-2" href="/project/modify_project.php?projectid=project_id">编辑</a>
				    <a class="uk-button uk-button-danger uk-button-large uk-width-1-2" onclick="delete_return()">删除</a>
				</div>
			</div>
			<script>
				function delete_return() {
					$('#delete_modal').modal('show');
				}
			</script>
			<div class="modal fade" id="delete_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="my_delete_modal">
									删除提醒
								</h4>
						</div>
						<div class="modal-body">
							<h3>您确认要删除该项目吗？</h3>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">
								关闭
							</button>
							<a href="#" class="btn btn-danger">
								删除
							</a>
						</div>
					</div>
				</div>
			</div>
		</s:if>			
		
	</body>
	<script>
		$(document).ready(function() {
			
			$.post('getProductsInStartups!getProductsInStartups.action', {
				startupsId : '<s:property value="#request.sts.startupsId" />'
			}, function(data, textStatus) {
				if(textStatus == 'success') {
					
					if(data.success) {
						for(var i = 0; i < data.ps.length-1; i++) {
							$("#productField").append($(".productHref").clone().attr("class", "uk-thumbnail productFieldClone"));
						}
						for(var i = 0;i < data.ps.length; i++) {
							
							if(i === 0) {
								$(".productHref").eq(i).attr("href", "getProductItem?item="+data.ps[i].productId);
								$(".productName").eq(i).text(data.ps[i].productName);
								$(".productConver").eq(i).attr("src", data.ps[i].productCover);
							} else {
								$(".productFieldClone").eq(i-1).attr("href", "getProductItem?item="+data.ps[i].productId);
								$(".productName").eq(i).text(data.ps[i].productName);
								$(".productConver").eq(i).attr("src", data.ps[i].productCover);
							}
							
						}
					} else {
						alert("获取产品出错，请刷新重试");
					}
				} else {
					alert("网络出错！请刷新重试！");
				}
			}, 'json');
		});
		$('#myTab a').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
	</script>

</html>
