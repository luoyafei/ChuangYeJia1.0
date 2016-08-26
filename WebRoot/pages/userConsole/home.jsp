<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

    <title>创业+管理控制台</title>

     <!-- Bootstrap core JavaScript
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
    <script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
    <script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/vendor/holder.min.js"></script>
    <script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/assets/bootstrap-3.3.5/docs/examples/dashboard/dashboard.css" rel="stylesheet" />
	<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>

	<!-- uikit -->
	<script src="<%=path%>/assets/uikit/uikit.js"></script>
	<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>

    	<style>
			body {
				font-family: "微软雅黑";
				padding-bottom: 0px;
			}

			.row .img {
				margin-right: 5px;
			}

			#navbar ul a:hover {
				color: #398BE5;
				background-color: transparent;
			}

		</style>

  </head>

  <body>
  
	<jsp:include page="/pages/module/index_bar.jsp" flush="true" />
	
	
	
    <div class="container-fluid" style="margin-top: 0px;">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" style="margin-top: 20px;">
          <ul class="nav nav-sidebar nav-tabs-justified" role="tablist" id="user_con_tab">
          	<!--个人资料，我的项目，我的资金，我的技术，我的运营，我的产品，我的合同，我的团队-->
            <li role="presentation"  class="active"><a href="#my_data" role="tab" data-toggle="tab">我的资料 </a></li>
            <li role="presentation"><a href="#my_startups" role="tab" data-toggle="tab">我的公司</a></li>
            <li role="presentation"><a href="#my_product" role="tab" data-toggle="tab">我的产品</a></li>
            <li role="presentation"><a href="#my_contract" role="tab" data-toggle="tab">我的合同</a></li>
            <!--<li role="presentation"><a href="#my_news" role="tab" data-toggle="tab">我的消息</a></li>-->
          </ul>
        </div>
        <script type="text/javascript">
			$('#user_con_tab a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			})
        </script>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
        
        	<div class="tab-content">
			  	<div role="tabpanel" class="tab-pane active" id="my_data"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_startups"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_product"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_contract"></div>
			  	<!-- <div role="tabpanel" class="tab-pane" id="my_news"></div> -->
			</div>

        	<script>

        		$(document).ready(function(){
        			
        			$("#navbar").attr("class", "navbar navbar-fixed-top navbar-inverse");
        			
        			$("#my_data").load("homeItem/my_data.jsp");//将个人资料load进来
        			$("#my_startups").load("homeItem/my_startups.jsp");//将我的项目load进来
        			$("#my_product").load("homeItem/my_product.jsp");//将我的产品load进来
        			$("#my_contract").load("homeItem/my_contract.jsp");//将我的合同load进来
        			/*$("#my_news").load("user_statusinfo_item/my_news.php");//将我的消息load进来团队*/
        		});
        	</script>
        </div>
      </div>
    </div>
  </body>
</html>