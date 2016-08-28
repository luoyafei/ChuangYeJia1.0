<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的消息提醒</title>
</head>
<body>
	<div style="width: 80%;margin-top:10px;margin-bottom: 20px;">
		<div class="row remindRow">
			<span class="col-md-2 remindNull"></span>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$.post('getRemindUsers!getRemindUsers.action', {}, function(data, textStatus) {
				$(".remindNull").text("");
				if(textStatus == "success") {
					if(data.remindSuccess) {
						for(var i = 0; i < data.remindUsers.length; i++) {
							var div = $('<div></div>');
							div.attr("class", "col-md-2");
							var a = $('<a></a>');
							a.attr("href", "<%=path %>/pages/chat/chat.jsp?toUserId=" + data.remindUsers[i].userId);
							a.appendTo(div);
							var img = $('<img />');
							img.attr("data-holder-rendered", "true");
							img.attr("src", data.remindUsers[i].userPhoto);
							$(".remind_userPhoto").attr("src", data.remindUsers[i].userPhoto);
							img.attr("alt", "图片正在玩命加载中...");
							img.attr("style", "width: 80px; height: 80px;");
							img.attr("class", "img-circle remind_userPhoto");
							img.appendTo(a);
							var button = $('<button></button>');
							button.attr("class", "btn btn-sm remind_userNickName");
							button.attr("style", "width: 70px;overflow: hidden;");
							button.appendTo(a);
							var span = $('<span></span>');
							span.attr("class", "uk-badge uk-badge-notification uk-badge-danger");
							span.text(data.userCount[i]);
							span.appendTo(button);
							var spanText = $('<span></span>');
							spanText.text(data.remindUsers[i].userNickName);
							spanText.appendTo(button);
							
							div.appendTo($(".remindRow"));
						}
					} else
						$(".remindNull").text("暂无消息");
				} else
					$(".remindNull").text("暂无消息");
			}, 'json');
		});
	</script>
</body>
</html>