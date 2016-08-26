<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<title>
			产品具体内容展现
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
		</style>
	</head>

	<body style="background-color: #F5F5F5;">

		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />

		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
			
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="<%=path %>/assets/img/project/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
									
								<span>
									<img data-holder-rendered="true" src="<s:property value='#request.product.productCover'/>" style="width: 100px; height: 100px;" class="img-circle" />
								</span>
							</div>
							<p style="margin-bottom: 0px;font-size: 32px;">
								<br> 产品名称：<s:property value="#request.product.productName"/>
							</p>
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
						ITEM&nbsp;&nbsp;DESCRIPTION
					</p>
					<p style="float: right;">
						随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
					</p>
					<h2 style="margin-top: 0;" style="color: black;">
						产品内容
					</h2>
				</div>
			</div>
			
			
			<div class="uk-block uk-block-muted" style="width:100%;">

                <div class="uk-container">

                    <div class="uk-grid uk-grid-match" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-2 uk-row-first">
                            <div class="uk-panel">
                             	<div class="uk-thumbnail uk-thumbnail-large">
									<img  style="height: 300px;" src='<s:property value="#request.product.productCover"/>' />
								</div>
                            </div>
                        </div>
                        <div class="uk-width-medium-1-2">
                            <div class="uk-panel">
                                <ul class="uk-list uk-list-line">
									<li>产品名称:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.product.productName"/></span></li>
									<li>所属公司:&nbsp;&nbsp;&nbsp;&nbsp;
									<span>
									<a href="getStartupsItem?item=<s:property value='#request.product.productStartups.startupsId' />" style="color: #000000;text-decoration: none;">
										<s:property value="#request.product.productStartups.startupsName"/>
									</a>
									</span>
									</li>
									<li>产品售价:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:if test="#request.product.productPrice == null">暂不售卖</s:if><s:else><s:property value="#request.product.productPrice"/>元</s:else></span></li>
									<li>产品归属地:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.product.productAddress"/></span></li>
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
					    <h3 class="panel-title product_brief">产品简介</h3>
					  </div>
					  <div class="panel-body">
						    简介：
					    	<span>
						    	<s:property value="#request.product.productBrief"/>
						    </span>
					  </div>
					</div>
				</div>
			</div>

			<div style="width: 80%;height: 80px;margin: 0 auto;">
				<div class="main-left" style="width: 50%;text-align: center;height: 100%;float: left;padding-top: 20px;">
					<a class="btn btn-default" onclick="" style="border: solid #A9A9A9 2px; border-radius: 10px;">联系ta</a>
				</div>
				<div class="main-right" style="width: 50%;text-align: center;height: 100%;float: left;padding-top: 20px;">
					<a class="btn btn-default" style="border: solid #A9A9A9 2px; border-radius: 10px;">点击购买</a>
				</div>
			</div>


				<div class="content-main-bottoom" style="width: 100%;height: 100%;overflow: auto;">
					
					<ul class="nav nav-tabs" role="tablist" id="myTab">
						<li role="presentation" class="active" style="width: 33.333333%;text-align: center;"><a href="#home" role="tab" data-toggle="tab" style="color: black;">产品详情</a></li>
						<li role="presentation" style="width: 33.333333%;text-align: center;"><a href="#profile" role="tab" data-toggle="tab" style="color: black;">交易保障</a></li>
					  	<li role="presentation" style="width: 33.333333%;text-align: center;"><a href="#messages" role="tab" data-toggle="tab" style="color: black;">评价</a></li>
					</ul>
				</div>
				
				
				
				<div class="tab-content" style="background-color: #FFFFFF">
						<div role="tabpanel" class="tab-pane active" id="home">
							<div style="margin: 0px auto;padding-top:20px;padding-bottom: 20px">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span><s:property value="#request.product.productDetail"/></span>
							</div>
						</div>


						<!--此处为交易保障-->
					  <div role="tabpanel" class="tab-pane" id="profile" style="background-color: #FFFFFF">
					  	<div style="width: 80%;height: 100%;margin: 30px auto;">
					  		<div class="left-top" style="width: 50%;height: 50%;float: left;">
					  			<div  style="width: 80%;height: 100%;margin: 0 auto;">
					  				<div style="width: 20%; height: 100%;float: left;">
					  					<br />
					  					<span class="glyphicon glyphicon-info-sign" style="color: #398BE5;font-size: 48px;float: right;"></span>
					  				</div>
					  				<div class="" style="width: 80%;float: right;">
					  					<h1 style="color: #398BE5;margin-bottom: 0px;margin-top: 10px;">创业实名认证</h1>
					  					<h5 style="margin-top: 0px;">保障创业服务真实可靠</h5>
					  				</div>
					  			</div>
					  		</div>
					  		<div class="left-bottom" style="width: 50%;height: 50%;float: right;">
					  			<div class="" style="width: 80%;height: 100%;margin: 0 auto;">

					  				<div style="width: 20%; height: 100%;float: left;">
					  					<br />
					  					<span class="glyphicon glyphicon-check" style="color: #398BE5;font-size: 48px;float: right;"></span>
					  				</div>
					  				<div class="" style="width: 80%;float: right;">
					  					<h1 style="color: #398BE5;margin-bottom: 0px;margin-top: 10px;">线上线下结合</h1>
					  					<h5 style="margin-top: 0px;">保障创业流程万无一失</h5>
					  				</div>
					  			</div>
					  		</div>
					  		<div class="right-top" style="width: 50%;height: 50%;float: left;">
					  			<div  style="width: 80%;height: 100%;margin: 0 auto;">


					  				<div style="width: 20%; height: 100%;float: left;">
					  					<br />
					  					<span class="glyphicon glyphicon-pencil" style="color: #398BE5;font-size: 48px;float: right;"></span>
					  				</div>
					  				<div class="" style="width: 80%;float: right;">
					  					<h1 style="color: #398BE5;margin-bottom: 0px;margin-top: 10px;">签订法律合同</h1>
					  					<h5 style="margin-top: 0px;">保障创业成果安全有效</h5>
					  				</div>
					  			</div>
					  		</div>
					  		<div class="right-bottom" style="width: 50%;height: 50%;float: right;">
					  			<div  style="width: 80%;height: 100%;margin: 0 auto;">

					  				<div style="width: 20%; height: 100%;float: left;">
					  					<br />
					  					<span class="glyphicon glyphicon-facetime-video" style="color: #398BE5;font-size: 48px;float: right;"></span>
					  				</div>
					  				<div class="" style="width: 80%;float: right;">
					  					<h1 style="color: #398BE5;margin-bottom: 0px;margin-top: 10px;">官方实时监控</h1>
					  					<h5 style="margin-top: 0px;">保证双方利益公平均衡</h5>
					  				</div>

					  			</div>
					  		</div>
					  	</div>
					  </div>

					  <!--此处为评价-->
					  <div role="tabpanel" class="tab-pane" id="messages">
					  
						  <div class="uk-grid">
						    <div class="uk-width-1-2"  style="margin-top:20px;">
						    	<ul class="uk-list" style="text-align: center;">
								    <li><h1 style="color: #398BE5;font-weight: bold;">80%</h1></li>
								    <li><h4>好评度</h4></li>
								</ul>
							</div>
						    <div class="uk-width-1-2"  style="margin-top:20px;">
								
								<div class="uk-grid">
									 <div class="uk-width-2-5"><h3 style="font-family: '微软雅黑';font-weight: 700;">投资人印象</h3></div>
									 <div class="uk-width-2-5">
									 <ul class="uk-list">
		                                <li>
		                                <span>准确性：
		                                	<div class="progress">
			                                	<div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
											    	<span class="sr-only"></span><span>90%</span>
											  	</div>
											</div>
										</span>
										</li>
		                                <li>
		                                <span>可行性：
		                                	<div class="progress">
			                              	  	<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
											    	<span class="sr-only"></span><span>60%</span>
											  	</div>
											 </div>
		                                </span>
		                                </li>
		                                <li>
		                                <span>经济性：
			                                <div class="progress">
											  <div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
											    <span class="sr-only"></span><span>75%</span>
											  </div>
											</div>
		                                </span></li>
                           			 </ul>
								</div>
					  		</div>
							
							</div>
						</div>
					  
					  	
					  	<div style="width: 100%;height: 80%;">

					  		<div style="width: 100%;height: 30%;margin-top: 20px;">
					  			<div style="width: 100%;height: 100%;">
					  				<div style="width: 80%;height: 80%;margin:0 auto;">
						  				<span>商品评价是指生产厂家、商家或者消费者根据具体商品的性能、规格、材质、使用寿命、外观等商品的内在价值设定一个可量化或定性的评价体系，由消费者对商品使用价值进行评价的过程。
								  		商品评价是指生产厂家、商家或者消费者根据具体商品的性能、规格、材质、使用寿命、外观等商品的内在价值设定一个可量化或定性的评价体系，由消费者对商品使用价值进行评价的过程。
								  		</span>
						  			</div>
						  			<br /><br />
						  			<div style="width: 80%;height: 20%;margin:0 auto;text-align: right;border-bottom: dashed #A9A9A9 1px;">
						  				<span>XXX项目投资人</span>
						  				<br />
						  				<span>来自电脑客户端</span>
						  			</div>
					  			</div>
					  		</div>

					
					  	</div>
					  </div>

					</div>
				
				
			</div>
		
	<jsp:include page="../../module/bottom.jsp" flush="true" />
	</body>
	<script>
		$(document).ready(function() {
			$("td").attr("style", "border-top: solid #333333 1px;");
		});
		$('#myTab a').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		})
	</script>

</html>
