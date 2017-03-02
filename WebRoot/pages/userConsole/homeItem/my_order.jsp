<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  <body>
      <div class="panel-group" id="accordion_myCreateOrder" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="headingOne1">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion_myCreateOrder" href="#collapseOne_myCreateOrder" aria-expanded="true" aria-controls="collapseOne_myCreateOrder">
            我创建的订单
              </a>
               <span class="label label-info myCreateOrderLabel"></span>
            </h4>
          </div>
          <div id="collapseOne_myCreateOrder" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne_myCreateOrder">
            <div class="panel-body">
              <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>公司名称</th>
                    <th>产品名称</th>
                    <th>金额(元)</th>
                    <th>创建时间</th>
                    <th>地址</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
               <tbody id="myCreateOrderTbody">
						<tr class="myCreateOrderTr">
							<td class="myCreateOrderStartupsName"></td>
							<td class="myCreateOrderProduct"></td>
							<td class="myCreateOrderPrice"></td>
							<td class="myCreateOrderCreateDate"></td>
							<td class="myCreateOrderAddr"></td>
							<td class="myCreateOrderOperate"></td>
						</tr>
					</tbody>
              </table>
            </div>
            </div>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="headingTwo1">
            <h4 class="panel-title">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion_myReceiveOrder" href="#collapseTwo_myReceiveOrder" aria-expanded="false" aria-controls="collapseTwo_myReceiveOrder">
                  我接收的订单
              </a>
              <span class="label label-info myReceiveOrderLabel"></span>
            </h4>
          </div>
          <div id="collapseTwo_myReceiveOrder" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo_myReceiveOrder">
            <div class="panel-body">
              <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>公司名称</th>
                    <th>产品名称</th>
                    <th>买家</th>
                    <th>创建时间</th>
                    <th>地址</th>
                    <th>操作</th>
                  </tr>
                </thead>
                
                 <tbody id="myReceiveOrderTbody">
					<tr class="myReceiveOrderTr">
						<td class="myReceiveOrderStartupsName"></td>
						<td class="myReceiveOrderProduct"></td>
						<td class="myReceiveOrderUser"></td>
						<td class="myReceiveOrderCreateDate"></td>
						<td class="myReceiveOrderAddr"></td>
						<td class="myReceiveOrderOperate"></td>
					</tr>
				</tbody>
                
              </table>
            </div>
            </div>
          </div>
        </div>
        
        
        <script>
               $(document).ready(function() {
            	   
            	   $.post('getMyOrderConsole!fetchMyOrders.action', {}, function(data, textStatus) {
            		   if(textStatus == "success") {
            			   
            			   if(data.success) {
            				   var createdOrders = data.createdOrders;
            				   var receivedOrders = data.receivedOrders;
            				   $(".myCreateOrderLabel").text(createdOrders.length + "个");
            				   $(".myReceiveOrderLabel").text(receivedOrders.length + "个");
            				   
            				if(createdOrders != null && createdOrders.length > 0) {
	               				   	$(".myCreateOrderTrClone").remove();
	   	   							for(var i = 0; i < createdOrders.length-1; i++) {
	   	   								$(".myCreateOrderTr").clone().attr("class", "myCreateOrderTrClone").appendTo("#myCreateOrderTbody");
	   	   							}
	   	   							
	   	   							for(var i = 0; i < createdOrders.length; i++) {
	   	   								$(".myCreateOrderStartupsName").eq(i).text(createdOrders[i].startupsId.startupsName);
	   	   								$(".myCreateOrderProduct").eq(i).text(createdOrders[i].productId.productName);
 	   	   								$(".myCreateOrderPrice").eq(i).text((createdOrders[i].unitPrice * createdOrders[i].productCount).toFixed(2));
	   		   							$(".myCreateOrderCreateDate").eq(i).text(createdOrders[i].orderDate);
	   		   							$(".myCreateOrderAddr").eq(i).text(createdOrders[i].addr);
	   		   							$(".myCreateOrderOperate").eq(i).html("<a href='/ChuangYeJia/orderDetail?citem=" + createdOrders[i].orderId + "'>查看</a>");
	   	   							}
	   	   						} 
            				   
            				   if(receivedOrders != null && receivedOrders.length > 0) {
	               				   	$(".myReceiveOrderTrClone").remove();
	   	   							for(var i = 0; i < receivedOrders.length-1; i++) {
	   	   								$(".myReceiveOrderTr").clone().attr("class", "myReceiveOrderTrClone").appendTo("#myReceiveOrderTbody");
	   	   							}
	   	   							
	   	   							for(var i = 0; i < receivedOrders.length; i++) {
	   	   								$(".myReceiveOrderStartupsName").eq(i).text(receivedOrders[i].startupsId.startupsName);
	   	   								$(".myReceiveOrderProduct").eq(i).text(receivedOrders[i].productId.productName);
	   	   								$(".myReceiveOrderUser").eq(i).html("<a href='/ChuangYeJia/getUserMark.action?mark="+ receivedOrders[i].userid.userId + "'>"+receivedOrders[i].userid.userNickName+"</a>");
	   		   							$(".myReceiveOrderCreateDate").eq(i).text(receivedOrders[i].orderDate);
	   		   							$(".myReceiveOrderAddr").eq(i).text(receivedOrders[i].addr);
	   		   							$(".myReceiveOrderOperate").eq(i).html("<a href='/ChuangYeJia/orderDetail?ritem=" + receivedOrders[i].orderId + "'>查看</a>");
	   	   							}
            				   	}
            			   }
            		   }
            	   }, "json");
               });
          </script>
      </div>
  </body>
</html>