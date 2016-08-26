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
      <div class="panel-group" id="accordion1" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="headingOne1">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion1" href="#collapseOne1" aria-expanded="true" aria-controls="collapseOne1">
            我创建的邀请合同
              </a>
               <span class="label label-info myCreateInviteLabel"></span>
            </h4>
          </div>
          <div id="collapseOne1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne1">
            <div class="panel-body">
              <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>合同名称</th>
                    <th>邀请成员</th>
                    <th>邀请公司</th>
                    <th>创建时间</th>
                    <th>合同状态</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
               <tbody id="myCreateInvite">
						<tr class="myCreateInviteTr">
							<td class="myCreateInviteName"></td>
							<td class="myCreateInviteUser"></td>
							<td class="myCreateInviteStartups"></td>
							<td class="myCreateInviteCreateDate"></td>
							<td class="myCreateInviteStatus"></td>
							<td class="myCreateInviteOperate"></td>
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
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion1" href="#collapseTwo1" aria-expanded="false" aria-controls="collapseTwo1">
                  我接收的邀请合同
              </a>
              <span class="label label-info myReceiveInviteLabel"></span>
            </h4>
          </div>
          <div id="collapseTwo1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo1">
            <div class="panel-body">
              <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>合同名称</th>
                    <th>邀请公司</th>
                    <th>邀请人</th>
                    <th>创建时间</th>
                    <th>合同状态</th>
                    <th>操作</th>
                  </tr>
                </thead>
                
                 <tbody id="myReceiveInvite">
					<tr class="myReceiveInviteTr">
						<td class="myReceiveInviteName"></td>
						<td class="myReceiveInviteStartups"></td>
						<td>我</td>
						<td class="myReceiveInviteCreateDate"></td>
						<td class="myReceiveInviteStatus"></td>
						<td class="myReceiveInviteOperate"></td>
					</tr>
				</tbody>
                
              </table>
            </div>
            </div>
          </div>
        </div>
        
          <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="headingOne1OfInvite01">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion1" href="#collapseOne1Invite01" aria-expanded="true" aria-controls="collapseOne1Invite01">
            我创建的申请合同
              </a>
              <span class="label label-info myCreateApplyLabel"></span>
            </h4>
          </div>
          <div id="collapseOne1Invite01" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne1">
            <div class="panel-body">
              <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>合同名称</th>
                    <th>创建人</th>
					<th>申请公司</th>
                    <th>创建时间</th>
                    <th>合同状态</th>
                    <th>操作</th>
                  </tr>
                </thead>
                
                
                <tbody id="myCreateApply">
					<tr class="myCreateApplyTr">
						<td class="myCreateApplyName"></td>
						<td>我</td>
						<td class="myCreateApplyStartups"></td>
						<td class="myCreateApplyCreateDate"></td>
						<td class="myCreateApplyStatus"></td>
						<td class="myCreateApplyOperate"></td>
					</tr>
				</tbody>
              </table>
              
              
            </div>
            </div>
          </div>
        </div>

        <div class="panel panel-default">
          <div class="panel-heading" role="tab" id="headingTwo1Invite02">
            <h4 class="panel-title">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion1" href="#collapseTwo1Invite01" aria-expanded="false" aria-controls="collapseTwo1">
                  我接收的申请合同
              </a>
                <span class="label label-info myLeaderReceiveLabel"></span>
            </h4>
          </div>
          <div id="collapseTwo1Invite01" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo1">
            <div class="panel-body">
              <div class="table-responsive">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>合同名称</th>
                    <th>申请人</th>
                    <th>申请公司</th>
                    <th>创建时间</th>
                    <th>合同状态</th>
                    <th>操作</th>
                  </tr>
                </thead>
	                  <tbody id="myLeaderReceive">
						<tr class="myLeaderReceiveTr">
							<td class="myLeaderReceiveName"></td>
							<td class="myLeaderReceiveApplicant"></td>
							<td class="myLeaderReceiveStartups"></td>
							<td class="myLeaderReceiveCreateDate"></td>
							<td class="myLeaderReceiveStatus"></td>
							<td class="myLeaderReceiveOperate"></td>
						</tr>
					</tbody>
              </table>
            </div>
            </div>
          </div>
        </div>
        
         <script>
               
               
               
               $(document).ready(function() {
            	   $.post('getContractConsole!getContractList.action', {}, function(data, textStatus) {
            		   
            		   if(textStatus == "success") {
            			   //alert(JSON.stringify(data.myLeaderReceive));
            			   $(".myCreateApplyLabel").text(data.myCreateApply.length + "个");
            			   $(".myLeaderReceiveLabel").text(data.myLeaderReceive.length + "个");
            			   $(".myCreateInviteLabel").text(data.myCreateInvite.length + "个");
            			   $(".myReceiveInviteLabel").text(data.myReceiveInvite.length + "个");
            			   /*
							这是我创建的申请的合同的块
            			   */
            			   if(data.myCreateApply != null && data.myCreateApply.length > 0) {

            				   	$(".myCreateApplyTrClone").remove();
	   							for(var i = 0; i < data.myCreateApply.length-1; i++) {
	   								$(".myCreateApplyTr").clone().attr("class", "myCreateApplyTrClone").appendTo("#myCreateApply");
	   							}
	   							
	   							for(var i = 0; i < data.myCreateApply.length; i++) {
	   								
	   								$(".myCreateApplyName").eq(i).text(data.myCreateApply[i].applyTitle);
	   								$(".myCreateApplyStartups").eq(i).html("<a href='/ChuangYeJia/getStartupsItem?item="+ data.myCreateApplyStartups[i].startupsId + "'>"+data.myCreateApplyStartups[i].startupsName+"</a>");
		   							$(".myCreateApplyCreateDate").eq(i).text(data.myCreateApply[i].createDate);
		   							$(".myCreateApplyStatus").eq(i).text(data.myCreateApply[i].applyStatus);
		   							if(data.myCreateApply[i].applyStatus == "正在审核") {
		   								$(".myCreateApplyOperate").eq(i).html("<a href='/ChuangYeJia/getApplyContract!JustDoIt.action?applyId="+data.myCreateApply[i].applyId+"' class='btn btn-default btn-xs myCreateApplyOperateDetail'>查看</a>"
			   									+ "<a class='btn btn-danger btn-xs myCreateApplyOperateQuit' onclick='myLeaderReceiveOperate(2, \""+ data.myCreateApply[i].applyId + "\")'>取消申请</a>"
			   							);
		   							} else {
		   								$(".myCreateApplyOperate").eq(i).html("<a href='/ChuangYeJia/getApplyContract!JustDoIt.action?applyId="+data.myCreateApply[i].applyId+"' class='btn btn-default btn-xs myCreateApplyOperateDetail'>查看</a>");
		   							}
		   							
	   								
	   							}
   							
	   						}
            			   /*
            				*   这里是我接收到的申请的块
            			    */
            			   if(data.myLeaderReceive != null && data.myLeaderReceive.length > 0) {

           				   		$(".myLeaderReceiveTrClone").remove();
	   							for(var i = 0; i < data.myLeaderReceive.length-1; i++) {
	   								$(".myLeaderReceiveTr").clone().attr("class", "myLeaderReceiveTrClone").appendTo("#myLeaderReceive");
	   							}
	   							
	   							for(var i = 0; i < data.myLeaderReceive.length; i++) {
	   								
	   								$(".myLeaderReceiveName").eq(i).text(data.myLeaderReceive[i].applyTitle);
		   							$(".myLeaderReceiveApplicant").eq(i).html("<a href='/ChuangYeJia/getUserMark.action?mark="+ data.myLeaderReceive[i].applyOrganiserId + "'>" + data.myLeaderReceiveUser[i].userNickName + "</>");
		   							$(".myLeaderReceiveStartups").eq(i).html("<a href='/ChuangYeJia/getStartupsItem?item=" + data.myLeaderReceive[i].applyStartupsId + "'>" + data.myLeaderReceiveStartups[i].startupsName + "</a>");
		   							$(".myLeaderReceiveCreateDate").eq(i).text(data.myLeaderReceive[i].createDate);
		   							$(".myLeaderReceiveStatus").eq(i).text(data.myLeaderReceive[i].applyStatus);
		   							if(data.myLeaderReceive[i].applyStatus == "正在审核") {
		   								$(".myLeaderReceiveOperate").eq(i).html("<a href='/ChuangYeJia/getApplyContract!JustDoIt.action?applyId="+data.myLeaderReceive[i].applyId+"' class='btn btn-default btn-xs myLeaderReceiveOperateDetail'>查看</a>"
			   								+ "<button class='btn btn-danger btn-xs myLeaderReceiveOk' onclick='myLeaderReceiveOperate(1, \""+ data.myLeaderReceive[i].applyId + "\")'>接收</button>"
			   								+ "<button class='btn btn-danger btn-xs myLeaderReceiveRefuse' onclick='myLeaderReceiveOperate(0, \""+ data.myLeaderReceive[i].applyId + "\")'>拒绝</button>"
			   							);
		   							} else {
		   								$(".myLeaderReceiveOperate").eq(i).html("<a href='/ChuangYeJia/getApplyContract!JustDoIt.action?applyId="+data.myLeaderReceive[i].applyId+"' class='btn btn-default btn-xs myLeaderReceiveOperateDetail'>查看</a>");
		   							}
		   							
	   							}
  							
	   						}
            			   
            			 /**
            			   * 这里是我创建的邀请
            			   */
            			   if(data.myCreateInvite != null && data.myCreateInvite.length > 0) {

          				   		$(".myCreateInviteTrClone").remove();
	   							for(var i = 0; i < data.myCreateInvite.length-1; i++) {
	   								$(".myCreateInviteTr").clone().attr("class", "myCreateInviteTrClone").appendTo("#myCreateInvite");
	   							}
	   							
	   							for(var i = 0; i < data.myCreateInvite.length; i++) {
	   								
	   								$(".myCreateInviteName").eq(i).text(data.myCreateInvite[i].inviteTitle);
		   							$(".myCreateInviteUser").eq(i).html("<a href='/ChuangYeJia/getUserMark.action?mark="+ data.myCreateInvite[i].inviteUserId + "'>" + data.myCreateInviteUser[i].userNickName + "</>");
		   							$(".myCreateInviteStartups").eq(i).html("<a href='/ChuangYeJia/getStartupsItem?item=" + data.myCreateInvite[i].inviteOrganiserStartupsId + "'>" + data.myCreateInviteStartups[i].startupsName + "</a>");
		   							$(".myCreateInviteCreateDate").eq(i).text(data.myCreateInvite[i].createDate);
		   							$(".myCreateInviteStatus").eq(i).text(data.myCreateInvite[i].inviteStatus);
		   							if(data.myCreateInvite[i].inviteStatus == "正在审核") {
		   								$(".myCreateInviteOperate").eq(i).html("<a href='/ChuangYeJia/getInviteContract!JustDoIt.action?inviteId="+ data.myCreateInvite[i].inviteId + "' class='btn btn-default btn-xs myCreateInviteOperateDetail'>查看</a>"
			   								+ "<button class='btn btn-danger btn-xs myCreateInviteQuit' onclick='operateInvite(2, \""+ data.myCreateInvite[i].inviteId + "\")'>取消邀请</button>"
			   							);
		   							} else {
		   								$(".myCreateInviteOperate").eq(i).html("<a href='/ChuangYeJia/getInviteContract!JustDoIt.action?inviteId="+ data.myCreateInvite[i].inviteId + "' class='btn btn-default btn-xs myCreateInviteOperateDetail'>查看</a>");
		   							}
	   							}
	   						} 
            			   /* 
            			   	这里是我被邀请的所有邀请合同
            			   	我接收的邀请合同
            			   	myReceiveInvite
            			   */
            			   
            			   if(data.myReceiveInvite != null && data.myReceiveInvite.length > 0) {

           				   	$(".myReceiveInviteTrClone").remove();
	   							for(var i = 0; i < data.myReceiveInvite.length-1; i++) {
	   								$(".myReceiveInviteTr").clone().attr("class", "myReceiveInviteTrClone").appendTo("#myReceiveInvite");
	   							}
	   							
	   							for(var i = 0; i < data.myReceiveInvite.length; i++) {
	   								
	   								$(".myReceiveInviteName").eq(i).text(data.myReceiveInvite[i].inviteTitle);
	   								$(".myReceiveInviteStartups").eq(i).html("<a href='/ChuangYeJia/getStartupsItem?item="+ data.myReceiveInviteStartups[i].startupsId + "'>"+data.myReceiveInviteStartups[i].startupsName+"</a>");
		   							$(".myReceiveInviteCreateDate").eq(i).text(data.myReceiveInvite[i].createDate);
		   							$(".myReceiveInviteStatus").eq(i).text(data.myReceiveInvite[i].inviteStatus);
		   							if(data.myReceiveInvite[i].inviteStatus == "正在审核") {
		   								$(".myReceiveInviteOperate").eq(i).html("<a href='/ChuangYeJia/getInviteContract!JustDoIt.action?inviteId="+ data.myReceiveInvite[i].inviteId + "' class='btn btn-default btn-xs myReceiveInviteOperateDetail'>查看</a>"
		   									+ "<a onclick='operateInvite(1, \""+ data.myReceiveInvite[i].inviteId + "\")' class='btn btn-default btn-xs myReceiveInviteOperateOk'>接收</a>"
			   								+ "<a onclick='operateInvite(0, \""+ data.myReceiveInvite[i].inviteId + "\")' class='btn btn-default btn-xs myReceiveInviteOperateRefuse'>拒绝</a>"
			   							);
		   							} else {
		   								$(".myReceiveInviteOperate").eq(i).html("<a href='/ChuangYeJia/getInviteContract!JustDoIt.action?inviteId="+ data.myReceiveInvite[i].inviteId + "' class='btn btn-default btn-xs myReceiveInviteOperateDetail'>查看</a>");
		   							}
		   							
	   								
	   							}
  							
	   						}
            			   
            		   }
            		   
            	   }, 'json');
               });
               
               /* 
               	操作申请合同，接收到的以及自己创建的
               	@parameter type:0,1,2 拒绝，接收，取消
               */
		          function myLeaderReceiveOperate(type, applyId) {
		        	  if(type == 1) {
		        		  if(confirm("您确定要接受该合伙人加入您的公司吗？")) {
		        			  $.post('operateApply!receiveUser.action', {
		        				  applyId : applyId
		        			  }, function(data, textStatus){
		        				  if(textStatus == "success") {
		        					  if(data.operateSuccess) {
		        						  alert("操作成功！！");
						                    window.location.reload();
		        					  } else {
		        						  alert("操作失败！！");
		        					  }
		        				  }
		        			  } , 'json');
				          }
		        	  } else if(type == 0) {
		        		  
		        		  if(confirm("您确定要拒绝该合伙人加入您的公司吗？")) {
				              $.post('operateApply!refuseUser.action',{
				                applyId : applyId
				              }, function(data, textStatus){
				                if(textStatus == "success") {
		        					  
		        					  if(data.operateSuccess) {
		        						  alert("操作成功！！");
						                    window.location.reload();
		        					  } else {
		        						  alert("操作失败！！");
		        					  }
				                }
				              }, 'json');
				            }
		        	  } else if(type == 2) {
		        		  
		        		  if(confirm("您确定要取消该申请合同吗？")) {
				              $.post('operateApply!quitApply.action',{
				                applyId : applyId
				              }, function(data, textStatus){
				                if(textStatus == "success") {
		        					  if(data.operateSuccess) {
		        						  alert("操作成功！！");
						                    window.location.reload();
		        					  } else {
		        						  alert("操作失败！！");
		        					  }
				                }
				              }, 'json');
				            }
		        	  }
		            
		          }
		          
		          /* 
	               	操作邀请合同，接收到的以及自己创建的
	               	@parameter type:0,1,2 拒绝，接收，取消
	               */
		          
		          function operateInvite(type, inviteId) {
	               		
		        	  if(type == 1) {
		        		  if(confirm("您确定要接受该公司的邀请合同吗？")) {
		        			  $.post('operateInvite!receiveStartups.action', {
		        				  inviteId : inviteId
		        			  }, function(data, textStatus){
		        				  if(textStatus == "success") {
		        					  if(data.operateInviteSuccess) {
		        						  alert("操作成功！！");
						                    window.location.reload();
		        					  } else {
		        						  alert("操作失败！！");
		        					  }
		        				  }
		        			  } , 'json');
				          }
		        	  } else if(type == 0) {
		        		  
		        		  if(confirm("您确定要拒绝该公司的邀请合同吗？")) {
				              $.post('operateInvite!refuseStartups.action',{
				            	  inviteId : inviteId
				              }, function(data, textStatus){
				                if(textStatus == "success") {
		        					  
		        					  if(data.operateInviteSuccess) {
		        						  alert("操作成功！！");
						                    window.location.reload();
		        					  } else {
		        						  alert("操作失败！！");
		        					  }
				                }
				              }, 'json');
				            }
		        	  } else if(type == 2) {
		        		  
		        		  if(confirm("您确定要取消该邀请合同吗？")) {
				              $.post('operateInvite!quitInvite.action',{
				            	  inviteId : inviteId
				              }, function(data, textStatus){
				                if(textStatus == "success") {
		        					  if(data.operateInviteSuccess) {
		        						  alert("操作成功！！");
						                    window.location.reload();
		        					  } else {
		        						  alert("操作失败！！");
		        					  }
				                }
				              }, 'json');
				            }
		        	  }
		            
		          }
		          
          </script>
              
        
        
      </div>
  </body>
</html>