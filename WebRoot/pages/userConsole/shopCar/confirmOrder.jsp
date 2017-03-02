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
    <title>确认订单</title>

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
    
    
    <script src="js/distpicker.data.js"></script>
	<script src="js/distpicker.js"></script>

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


	<div class="modal fade" tabindex="-1" role="dialog" id="AddressInput">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">请填写地址信息</h4>
	      </div>
	      <div class="modal-body">
	      
		      <div id="distpicker5">
		        <div class="form-group">
		          <label class="sr-only" for="province10">Province</label>
		          <select class="form-control" id="province10"></select>
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="city10">City</label>
		          <select class="form-control" id="city10"></select>
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="district10">District</label>
		          <select class="form-control" id="district10"></select>
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="detailAddr">Detail</label>
		          <input type="text" class="form-control" id="detailAddr" maxlength="255" placeholder="请输入地址详情..." />
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="receiveName">Name</label>
		          <input type="text" maxlength="5" class="form-control" id="receiveName" placeholder="请输入收货人姓名..." />
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="receiveTel">Tel</label>
		          <input type="tel" class="form-control" maxlength="11" id="receiveTel" placeholder="请输入收货电话..." />
		        </div>
		      </div>
		    
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" id="addressBtn">确定</button>
	      </div>
	    </div>
	  </div>
	</div>






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

                        <br>确认订单</p>
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
               我的订单
            </h2>
        </div>
    </div>

    <div class="uk-block uk-block-muted" style="width:100%;height: 100%;">
        <div class="uk-container uk-overflow-container">
        
	        <script type="text/javascript">
	        	function submitClick() {
	        		alert(detailAddr.value);
	        	}
	        </script>
	        <div class="row" style="border-bottom: 1px solid #398BE5;">
			  <div class="col-xs-2">公司</div>
			  <div class="col-xs-2">产品</div>
			  <div class="col-xs-2">单价(元)</div>
			  <div class="col-xs-2">数量</div>
			  <div class="col-xs-2">优惠(元)</div>
			  <div class="col-xs-2">小计(元)</div>
			</div>
	        
	       	<s:iterator value="#request.orders" var="x">
		       	<div class="row">
				  <div class="col-xs-2"><s:property value="#x.startupsId.startupsName" /></div>
				  <div class="col-xs-2"><s:property value="#x.productId.productName" /></div>
				  <div class="col-xs-2"><s:property value="#x.unitPrice" /></div>
				  <div class="col-xs-2"><s:property value="#x.productCount" /></div>
				  <div class="col-xs-2">无优惠</div>
				  <div class="col-xs-2"><span class="eachPrice"><s:property value="#x.unitPrice * #x.productCount" /></span></div>
				</div>
			</s:iterator>
			
			<br />
        	<br />
        	<hr />
			
        	<div>
        		共计<label id="titalMoney"></label>元
        		<br />
        		寄送至：<label id="sendAddr"></label>
        		<br />
        		收货人：<label id="receiveInfo"></label>
        	</div>
        	<div>
        		<a href="/ChuangYeJia/pages/userConsole/shopCar/myShopCar.jsp" class="btn primary-btn">返回购物车</a>
        		<form action="submitOrderAction" id="addrInfoAction" method="post" style="display: none;">
			      	<input name="addrInfo" id="addrInfoInput" />
			     </form>
        		<button class="btn" id="submitOrder">提交订单</button>
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
    });
	
	function AddrInfo(province, city, district, detailAddr, receiveName, receiveTel) {
		this.province = province;
		this.city = city;
		this.district = district;
		this.detailAddr = detailAddr;
		this.receiveName = receiveName;
		this.receiveTel = receiveTel;
		/*
		检验每个字段的辅助函数
		field，字段
		min，下限
		max，上限
		*/
		AddrInfo.prototype.checkField = function(field, min, max) {
			return field != null && field.length >= min && field.length <= max;
		}
		AddrInfo.prototype.checkAddr = function() {
			return this.checkField(province, 1, 8) && this.checkField(city, 1, 10) && this.checkField(district, 1, 10) && this.checkField(detailAddr, 1, 255);
		}
		AddrInfo.prototype.checkReceive = function() {
			return receiveName != null && receiveName.length >= 1 && receiveName.length <= 5 && receiveTel != null && receiveTel.match(/\d{11}/);
		}
	}
    jQuery(document).ready(function() {
    	jQuery("td").attr("style", "border-top: solid #333333 1px;");
    	

    	$("#AddressInput").modal({
    		show:true,
    		backdrop:'static',
    		keyboard: false
    	});
    	
		$('#distpicker5').distpicker({
	  		autoSelect: false
	  	});
		
		var addrInfo;
		var bol;
		$("#addressBtn").bind("click", function() {
    		var province = $("#province10").val().trim();
    		var city = $("#city10").val().trim();
    		var district = $("#district10").val().trim();
    		var detailAddr = $("#detailAddr").val().trim();
    		var receiveName = $("#receiveName").val().trim();
    		var receiveTel = $("#receiveTel").val().trim();
    		
    		var titalMoney = $("#titalMoney");
    		var sendAddr = $("#sendAddr");
    		var receiveInfo = $("#receiveInfo");
    		
    		
    		addrInfo = new AddrInfo(province, city, district, detailAddr, receiveName, receiveTel);
    		if(addrInfo.checkAddr()) {
   				if(addrInfo.checkReceive()) {
   					
   					var sumEachPrice = 0.00;
   					$(".eachPrice").each(function(index){
   						sumEachPrice += parseFloat($(".eachPrice").eq(index).html());
   					});
   					
   					titalMoney.text(sumEachPrice.toFixed(2));
   					sendAddr.text(addrInfo.province + " " + addrInfo.city + " " + addrInfo.district + " " + addrInfo.detailAddr);
   					receiveInfo.text(addrInfo.receiveName + " " + addrInfo.receiveTel);
   					bol = true;
   					$("#AddressInput").modal("hide");
   				} else {
   					bol = false;
   					addrInfo = null;
   					alert("请输入正确的接收信息！");
   				}
    		} else {
    			bol = false;
    			addrInfo = null;
    			alert("请输入正确的地址！");
    		}
    	});
		
		$("#submitOrder").bind("click", function() {
			if(bol) {
				var form = document.getElementById("addrInfoAction");
				var myInput = document.getElementById("addrInfoInput");
				myInput.value = JSON.stringify(addrInfo);
				form.submit();
			} else {
				alert("输入错误！");
			}
		});
		
	})
</script>
</html>


