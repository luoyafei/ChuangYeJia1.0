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
    
    <!-- <script src="https://code.angularjs.org/angular-1.0.1.min.js"></script> -->
    <script src="<%=path %>/assets/angularJS/angular.min.js"></script>
    <script src="<%=path %>/assets/manualSource/js/shopCar.js"></script>
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
		
		
		ul li {
			list-style: none
		}
		
		a {
			text-decoration: none;
		}
		
		a:hover {
			color: #e46432;
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
        <div class="uk-container uk-overflow-container">
        
        
        <div class="table-responsive" id="tableDiv">
	      <table class="table table-bordered table-hover">
	        <thead style="background-color: #EBEBEB;">
	          <tr>
	            <th>
	            	<label><input id="checkAll" type="checkbox"/>&nbsp;&nbsp;全选</label>
	            </th>
				<th>商品</th>
				<th>单价</th>
		        <th>数量</th>
		        <th>小计</th>
		        <th>操作</th>
	          </tr>
	        </thead>
	        <tbody id="tbodySpan">
	          <tr class="trSpanForClone">
		            <td class="checkSpan"><input class="checkOne check" type="checkbox"/></td>
			        <td class="commodityPicture">
			        	<!-- <img src="images/1.jpg" class="img-rounded" alt="140x140" style="width: 140px; height: 140px;" src="" data-holder-rendered="true" /> -->
			        	
			       	</td>
			        <td class="commodityPrice"></td>
			        <td class="commodityCount">
			        	<button class="commodityReduce uk-button uk-button-mini uk-button-link"><i class="uk-icon-minus-square"></i></button>
				        <input class="commodityCountInput" type="text" value="1" style="width: 40px"/>
				        <button class="commodityAdd uk-button uk-button-mini uk-button-link"><i class="uk-icon-plus-square"></i></button>
				    </td>
			        <td class="commodityOneTotal"></td>
			        <td class="commodityOperation"><a>删除</a>
			        <input type="hidden" class="produceItem" value="" /></td>
	          </tr>
	        </tbody>
	        <tfoot style="background-color: #EBEBEB;">
	        	<tr>
	        		<td>
	        			<a id="deleteSelect">删除</a>
	        		</td>
	        		<td></td>
	        		<td></td>
	        		<td>
	        			<div class="selectedCount" id="selected">已选商品<span id="selectedTotal" style="color: red;">0</span>件</div>
	        		</td>
	        		<td>
	        			<div class="totalMoney">合计：￥<span id="priceTotal">0.00</span></div>
	        		</td>
	        		<td>
	        			<div class="accounts" id="settlement">结 算</div>
	        		</td>
	        	</tr>
	        </tfoot>
	      </table>
	      <form action="shopCarAction!execute.action" id="cartForm" method="post" style="display: none;">
	      	<input name="settlementProducts" id="settlementProducts" />
	      </form>
   		</div>
    	</div>
	</div>
</div>

<jsp:include page="../../module/bottom.jsp" flush="true" />

</body>
<script>
	jQuery('#myTab a').click(function(e) {
        e.preventDefault()
        jQuery(this).tab('show')
    })
    jQuery(document).ready(function() {
    	jQuery("td").attr("style", "border-top: solid #333333 1px;");
    	
    	$.post("shopCarAction!getMyShopCarItems.action", {}, function(data, textStatus) {
        	if(textStatus == "success") {
        		var content = data.shopCar;
        		
        		for(var i = 0; i < content.length; i++) {
        			$("#tbodySpan").append($(".trSpanForClone").clone().attr("class", "trSpan"));
        		}
        		$(".trSpanForClone").remove();
        		
        		$(".commodityPicture").each(function(index){
					$(this).text(content[index].productName);
				});
        		$(".commodityPrice").each(function(index){
					$(this).text(parseFloat(content[index].productPrice).toFixed(2));
				});
        		$(".commodityOneTotal").each(function(index){
					$(this).text(parseFloat(content[index].productPrice).toFixed(2));
				});
        		$(".produceItem").each(function(index){
					$(this).val(content[index].productId);
				});
        		operateShopCar();
        	} else {
        		alert("请刷新重试！");
        	}
        }, 'json');
    	
	})
</script>
</html>


