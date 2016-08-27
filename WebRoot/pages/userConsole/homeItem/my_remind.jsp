<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的消息提醒</title>
</head>
<body>
	<div style="width: 80%;margin-top:10px;margin-bottom: 20px;">
		<div class="row">
			<div class="col-md-2">
				<a href="">
					<img data-holder-rendered="true" src="" alt="图片加载失败" style="width: 80px; height: 80px;" class="img-circle remind_userPhoto" />
					<button class="btn btn-sm remind_userNickName" style="width: 70px;overflow: hidden;">
						用户
					</button>
				</a>
		    </div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$.post('getRemindUsers!getRemindUsers.action', {}, function(data, textStatus) {
				if(textStatus == "success") {
					alert(JSON.stringify(data));
				}
			}, 'json');
		});
	</script>
</body>
</html>