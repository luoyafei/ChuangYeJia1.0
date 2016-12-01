<%--
  Created by IntelliJ IDEA.
  User: Diamond
  Date: 2016-11-24
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
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
    <title>我的购物车</title>

    <!-- Bootstrap core JavaScript
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=path %>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
    <script src="<%=path %>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
    <script src="<%=path %>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<%=path %>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
    <link href="<%=path %>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">

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
            <img class="" src="<%=path %>/assets/img/content_detail/333.png" alt="">
            <div class="container" style="padding-right: 0px;padding-left: 0px;">
                <div class="carousel-caption">
                    <div class="logo-img" style="width: 100%;">
							<span>
								<img data-holder-rendered="true" src="<s:property value='#session.user.userPhoto'/>" style="width: 100px; height: 100px;" class="img-circle" />
							</span>
							<span>
								<a style="font-size: 14px;text-decoration: none;">
									<span style="display: block;">
										<s:property value="#session.user.userNickName"/>
									</span>
                                </a>
							</span>
							<span>
								<img src="<%=path %>/assets/img/user/level.png" style="width: 12%;height: 5%; margin-bottom: 0px;padding-bottom: 0px;">
							</span>
                    </div>

                    <p style="margin-bottom: 0px;font-size: 32px;">

                        <br>我的购物车</p>
                    <br />
                    <br />
                    <br />
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container marketing" style="width: 78%;background-color: #F5F5F5; padding:50px 0px;">
    <div class="thumbtitle">
        <div class="contenttitle" style="margin-bottom: 10px;">
            <p style="margin-bottom: 4px;">
                WHO&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;AM
            </p>
            <p style="float: right;">
                随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
            </p>
            <h2 style="margin-top: 0;" style="color: black;">
               我的购物车
            </h2>
        </div>
    </div>

    <div class="uk-block uk-block-muted" style="width:100%;height: 100%;">

        <div class="uk-container">
            <div class="uk-grid uk-grid-match">

                <div class="uk-width-medium-1-5">
                    <input type="radio" value="买" />
                </div>
                <div class="uk-width-medium-2-5">
                    <div class="uk-panel">
                        <div class="uk-thumbnail uk-thumbnail-large">
                            <a class="uk-thumbnail" href="#"><img src="<s:property value='#session.user.userPhoto' />" alt="" height="100" width="200"></a>
                        </div>
                    </div>
                </div>
                <div class="uk-width-medium-2-5">
                    <div class="uk-panel">
                        <ul class="uk-list uk-list-line">
                            <li>用户昵称:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.userNickName"/></span></li>
                            <%-- <li>用户邮箱:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.userEmail"/></span></li> --%>
                            <li>所属高校:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.userAddress"/></span></li>
                            <li>能力方向:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.copartnerCategory"/></span></li>
                            <li>关注领域:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.userField"/></span></li>
                            <li>用户经历:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.userIntroduce"/></span></li>
                            <li>创业能力:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#request.uts.startAbility"/></span></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="../../module/bottom.jsp" flush="true" />

</body>
<script>
    $('#myTab a').click(function(e) {
        e.preventDefault()
        $(this).tab('show')
    })
    $(document).ready(function() {
        $("td").attr("style", "border-top: solid #333333 1px;");
    });
</script>
</html>


