<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="panel-group" id="accordion1" role="tablist" aria-multiselectable="true">
	<div class="panel panel-default">
		<div class="panel-heading" role="tab" id="headindStartups">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#startups1" href="#createStartups" aria-expanded="true" aria-controls="createStartups"> 我创建的公司 </a>
				<span class="label label-info myStartupsLabel"></span>
			</h4>
		</div>
		<div id="createStartups" class="panel-collapse collapse" role="tabpanel"
			aria-labelledby="headindStartups">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>公司名称</th>
								<th>合伙人需求</th>
								<th>公司密码</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="myStartupsTbody">
							<tr class="myStartupsTr">
								<td class="myStartupsName"></td>
								<td class="myCopartnerRequire"></td>
								<td class="myStartupsPassword"></td>
								<td class="myCreateDate"></td>
								<td class="myOperate"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading" role="tab" id="headingStartups2">
			<h4 class="panel-title">
				<a class="collapsed" data-toggle="collapse"
					data-parent="#startups1" href="#joinStartups"
					aria-expanded="false" aria-controls="joinStartups"> 我参与的公司 </a>
					<span class="label label-info joinStartupsLabel"></span>
			</h4>
		</div>
		<div id="joinStartups" class="panel-collapse collapse" role="tabpanel"
			aria-labelledby="headingStartups2">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>公司名称</th>
								<th>公司总监 </th>
								<th>合伙人需求</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody id="joinStartupsTbody">
							<tr class="joinStartupsTr">
								<td class="joinStartupsName"></td>
								<td class="joinStartupsLeader"></td>
								<td class="joinCopartnerRequire"></td>
								<td class="joinCreateDate"></td>
								<td class="joinOperate"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$.post('getStartupsConsole!getStartupsList.action', {}, function(data, textStatus) {
				if(textStatus == "success") {
					if(data.success) {
						
						$(".myStartupsLabel").text(data.leaderS.length + "个");
						$(".joinStartupsLabel").text(data.joinS.length + "个");
						
						if(data.leaderS != null && data.leaderS.length > 0) {
							$(".myStartupsTrClone").remove();
							for(var i = 0; i < data.leaderS.length-1; i++) {
								$(".myStartupsTr").clone().attr("class", "myStartupsTrClone").appendTo("#myStartupsTbody");
							}
							
							for(var i = 0; i < data.leaderS.length; i++) {
								$(".myStartupsName").eq(i).text(data.leaderS[i].startupsName);
								$(".myCopartnerRequire").eq(i).text(data.leaderS[i].startupsCopartnerRequire);
								$(".myStartupsPassword").eq(i).text(data.leaderS[i].startupsPassword)
								$(".myCreateDate").eq(i).text(data.leaderS[i].startupsCreateDate);
								$(".myOperate").eq(i).html("<a href='/ChuangYeJia/getStartupsItem?item=" + data.leaderS[i].startupsId + "' class='btn btn-default btn-xs myOperateDetail'>查看</a>"
									+ "<a href='/ChuangYeJia/getStartupsItem?item=" + data.leaderS[i].startupsId + "' class='btn btn-default btn-xs myOperateModify'>修改</a>"
									+ "<button class='btn btn-danger btn-xs myOperateDelete' onclick=''>删除</button>"
								);
							}
							
						}
						
						if(data.joinS != null && data.joinS.length > 0) {
							$(".joinStartupsTrClone").remove();
							for(var i = 0; i < data.joinS.length-1; i++) {
								$(".joinStartupsTr").clone().attr("class", "joinStartupsTrClone").appendTo("#joinStartupsTbody");
							}
							
							for(var i = 0; i < data.joinS.length; i++) {
								$(".joinStartupsName").eq(i).text(data.joinS[i].startupsName);
								$(".joinStartupsLeader").eq(i).html("<a href='/ChuangYeJia/getUserMark.action?mark='" + data.joinS[i].startupsLeader.userId + "'>" + data.joinS[i].startupsLeader.userNickName+"</a>")
								$(".joinCopartnerRequire").eq(i).text(data.joinS[i].startupsCopartnerRequire);
								$(".joinCreateDate").eq(i).text(data.joinS[i].startupsCreateDate);
								$(".joinOperate").eq(i).html("<a href='/ChuangYeJia/getStartupsItem?item=" + data.joinS[i].startupsId + "' class='btn btn-default btn-xs joinOperateDetail'>查看</a>"
										+ "<a href='' class='btn btn-danger btn-xs joinOperateExit'>退出公司</a>"
								);
							}
						}
					}
				}
			}, 'json');
		});
	</script>
	
</div>



