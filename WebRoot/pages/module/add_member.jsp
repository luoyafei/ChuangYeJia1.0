<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>

<div class="content-main" style="width: 100%;height: 1000px;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">

<h3 style="color: black;padding-top: 20px;text-align: center;">邀请成员</h3>
<div class="content-main-top" style="height: 100%;">
	<div style="width: 80%;height: 100%;margin: 50px auto;">
		<form action="../../action/team/action_add_member.php" method="post" id="addForm">

	        <div class="form-group">
			    <label for="exampleInputEmail1" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">添&nbsp;加&nbsp;邮&nbsp;箱</label>
			    <div class="col-sm-10">
			    	<input type="email" readonly="readonly" class="form-control" name="username"  id="exampleInputEmail1" value="<?php echo $owneremail?>" />
			    	<hr />
			    </div>
			</div>


			 <div class="form-group">
			    <label for="exampleInputPassword1" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">合同名</label>
			    <div class="col-sm-10">
			    	<input type="text" class="form-control" name="contract_name" onblur="chechteamid()"  id="exampleInputPassword1" placeholder="合同名">
			    	<div class="alert alert-danger alert-password" role="alert" style="display: none;">
						请输入合同名称
					</div>
				    <hr />
			    </div>
			</div>

			<div class="form-group">
			    <label for="exampleEntityType1" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">合同类型</label>
			    <div class="col-sm-10">
			    <div class="btn-group" data-toggle="buttons">
				  <input class="btn btn-default active" readonly="readonly" id="entity_type">
				  	<input name="entity_type" id="entity_type_real" type="hidden" />
				  </input>
				</div>
			    <hr />
			    </div>
			</div>

			<div class="form-group">
			    <label for="exampleEntityID1" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">实体ID</label>
			    <div class="col-sm-10">
			    	<input type="text" readonly="readonly" class="form-control" name="entity_id" id="entity_id" id="exampleEntityID1"  value="<?php echo $entity_id?>"/>
				    <hr />
			    </div>
			</div>

			<div class="form-group">
			    <label for="exampleTeam1" style="text-align: right;margin-top: 6px;" class="col-sm-2 control-label">团队ID</label>
			    <div class="col-sm-10">
			    	<input readonly="readonly" class="form-control" name="team_id"  id="exampleTeam1"/>
				    <hr />
			    </div>
			</div>


			<script>
				//此处是使用KE在线编辑器
				KE.show({
					id: 'content2222',
					resizeMode: 1,
					allowPreviewEmoticons: false,
					allowUpload: false,
					items: [
						'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link'
					]
				});
			</script>

			<div class="form-group">
				<label for="content2" class="col-sm-2 control-label" style="text-align: right;margin-top: 6px;">合同内容&nbsp;&nbsp;</label>
				<div class="col-sm-10">
					<textarea id="content2" name="contract_content_detail" style="width:100%;height:200px;visibility:visible;"></textarea>
				</div>
			</div>
			<input type="hidden" name="submit_add_member" value="邀请成员" />

			<div style="text-align: center;">
				<button type="button" class="btn btn-default" style="color: #398BE5;margin-top: 40px;" onclick="backPage()" value="返回">
					返回
				</button>
				<button type="button" class="btn btn-default" style="color: #398BE5;margin-top: 40px;" onclick="checkdata()">
					发送邀请
				</button>
			</div>

		</form>

		<script>
			$(document).ready(function() {
				var url = window.location.href;
				var temp1 = url.split("?");
				var temp2 = temp1[1].split("&");
				var tempTeamType = temp2[0].split("=");
				var teamType = tempTeamType[1];
				var tempTeamId = temp2[1].split("=");
				//var teamId = tempTeamId[1];
				//var ttId = $('input:radio[name="teamId"]:checked').val().trim();
				//$("#team_id").val(ttId);

				var entity_type = "类型";
				switch(teamType) {
					case "1":
					entity_type = "资金";
					break;
					case "2":
					entity_type = "技术";
					break;
					case "3":
					entity_type = "运营";
					break;
					default:
					break;
				}

				$("#entity_type").val(entity_type);
				$("#entity_type_real").val(teamType);
			});

			function chechteamid() {
				var password = $("#exampleInputPassword1").val().trim();
				if (password === "") {
					$(".alert-password").attr("style", "display:inline-block;");
				} else {
					$(".alert-password").attr("style", "display:none;");
				}
			}

			function checkdata() {
				var password = $("#exampleInputPassword1").val().trim();
				var content = $("#content2").val().trim();
				//alert($("#entity_type").val());
				if (password == "" || content == "") {
					alert("请您将信息填写完整");
				} else {
					$("#addForm").submit();
				}
			}

			function backPage() {
				$("#status1").click();
			}
		</script>
	</div>
</div>

</div>
