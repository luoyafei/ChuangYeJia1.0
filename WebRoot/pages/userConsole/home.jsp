<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.chuangyejia.bean.*" %>
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
    <div class="navbar-wrapper">
      <div class="container">

 		<nav class="navbar  navbar-inverse navbar-static-top" style="border-radius: 4px;">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
            
              <ul class="nav navbar-nav">
               
                <li class=<%=(String)request.getAttribute("flag")!=null && ((String)request.getAttribute("flag")).equals("index")?"active":"" %>><a class="a-item" href="/ChuangYeJia/index.jsp">首页</a></li>
				<li class=<%=(String)request.getAttribute("flag")!=null && ((String)request.getAttribute("flag")).equals("startups")?"active":"" %>><a class="a-item" href="/ChuangYeJia/pages/title/startups_list.jsp">创业公司</a></li>
				<li class=<%=(String)request.getAttribute("flag")!=null && ((String)request.getAttribute("flag")).equals("partner")?"active":"" %>><a class="a-item" href="/ChuangYeJia/pages/title/copartner_list.jsp">合伙人</a></li>
				<li class=<%=(String)request.getAttribute("flag")!=null && ((String)request.getAttribute("flag")).equals("product")?"active":"" %>><a class="a-item" href="/ChuangYeJia/pages/title/product_list.jsp">产品</a></li>
              </ul>
              
              <ul class="nav navbar-nav navbar-right" style="margin-right: 20px;">
                <li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" style="background: none;">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						<span class="caret"></span>
					</a>
					<ul class='dropdown-menu' role='menu' id='user-menu-cont'>
						<s:if test="#session.user != null">
							<li><a>欢迎您！<s:property value="#session.user.userNickName"/> </a>
							<li><a href="/ChuangYeJia/pages/userConsole/complete_data.jsp">编辑资料</a></li>
							<li><a href="#">消息提醒</a></li>
							<li><a href="/ChuangYeJia/pages/userConsole/home.jsp" class="personalManager">个人管理</a></li>
							
							<li role="presentation" class="menuInsertShow"><a href="#my_data" role="tab" data-toggle="tab">我的资料 </a></li>
				            <li role="presentation" class="menuInsertShow"><a href="#my_startups" role="tab" data-toggle="tab">我的公司</a></li>
            				<li role="presentation" class="menuInsertShow"><a href="#my_product" role="tab" data-toggle="tab">我的产品</a></li>
				            <li role="presentation" class="menuInsertShow"><a href="#my_contract" role="tab" data-toggle="tab">我的合同</a></li>
            				<li role="presentation" class="menuInsertShow"><a href="#my_remind" role="tab" data-toggle="tab">我的消息</a></li>
							
							<li><a href="http://oa001.w176-e0.ezwebtest.com/main/main.html">创业者之家</a></li>
							
							<li class='divider'></li>
							<li><a href="userSignIn!signOut.action">注销</a></li>
						</s:if>
						<s:else>
							<li><a href="/ChuangYeJia/pages/signIn/login.jsp?backUrl=<%=request.getRequestURI()+'?'+request.getQueryString() %>">登陆</a></li>
							<li><a href="/ChuangYeJia/pages/signIn/register.jsp?backUrl=<%=request.getRequestURI()+'?'+request.getQueryString() %>">注册</a></li>
						</s:else>
					</ul>
					
				</li>
              </ul>
            </div>
          </div>
        </nav>
	</div>
</div>
	
	
	
	
    <div class="container-fluid" style="margin-top: 0px;">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" style="margin-top: 20px;">
          <ul class="nav nav-sidebar nav-tabs-justified" role="tablist" id="user_con_tab">
          	<li role="presentation" class="active"><a href="#my_remind" role="tab" data-toggle="tab">我的消息</a></li>
            <li role="presentation"><a href="#my_data" role="tab" data-toggle="tab">我的资料 </a></li>
            <li role="presentation"><a href="#my_identify" role="tab" data-toggle="tab">我的认证</a></li>
            <li role="presentation"><a href="#my_startups" role="tab" data-toggle="tab">我的公司</a></li>
            <li role="presentation"><a href="#my_product" role="tab" data-toggle="tab">我的产品</a></li>
            <li role="presentation"><a href="#my_contract" role="tab" data-toggle="tab">我的合同</a></li>
          </ul>
        </div>
        <script type="text/javascript">
			$('#user_con_tab a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			})
			
			window.onresize = function() {
				screenModify();
			}
        </script>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
        
        	<div class="tab-content">
        		<div role="tabpanel" class="tab-pane active" id="my_remind"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_data"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_startups"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_product"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_contract"></div>
			  	<div role="tabpanel" class="tab-pane" id="my_identify"></div>
			</div>

        	<script>

        		function screenModify() {
        			if(document.body.offsetWidth < 684) {
    					$(".personalManager").hide();
    					$(".menuInsertShow").show();
    				} else {
    					$(".personalManager").show();
    					$(".menuInsertShow").hide();
    				}
        		}
        	
        		$(document).ready(function(){
        			
        			screenModify();
        			
        			$("#my_data").load("homeItem/my_data.jsp");//将个人资料load进来
        			$("#my_startups").load("homeItem/my_startups.jsp");//将我的项目load进来
        			$("#my_product").load("homeItem/my_product.jsp");//将我的产品load进来
        			$("#my_contract").load("homeItem/my_contract.jsp");//将我的合同load进来
        			$("#my_remind").load("homeItem/my_remind.jsp");//将我的消息load进来团队
        			$("#my_identify").load("homeItem/my_identify.jsp");//将我的认证load进来团队
        		});
        	</script>
        </div>
      </div>
    </div>
  </body>
</html>