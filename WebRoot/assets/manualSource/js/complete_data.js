/**
 * complete_data.jsp页面的javascript资源文件
 */

/**
 * this method is upload file use asynchronized
 */
function userphoto_upload() {
	if($("#picture").val().trim() === "")
		alert("请选择图片后进行上传");
	else {
		$("#uploadBtn").attr("disabled", "true");
		$("#uploadInfo").text("图片正在玩命上传！请稍后...");
		var fd = new FormData();
		fd.append("picture", $("#picture").get(0).files[0]);
		$.ajax({
			url: "uploadPicture!uploadPicture.action",
			type: "POST",
			dataType: "json",
			processData: false,
			contentType: false,
			data: fd,
			success: function(data) {
				$("#uploadBtn").removeAttr("disabled");
				if(data.status) {
					$("#userImg").attr("src", data.pictureUrl);
					$("#uploadInfo").text("上传成功！");
					$("#uploadOk").attr("style", "display: inline;");
					$("#uploadOk").attr("class", "glyphicon glyphicon-ok");
				} else {
					$("#uploadInfo").text("上传失败！");
					$("#uploadOk").attr("style", "display: inline;");
					$("#uploadOk").attr("class", "glyphicon glyphicon-remove");
				}
			},
			 error: function(XMLHttpRequest, textStatus, errorThrown) {
				$("#uploadBtn").removeAttr("disabled");
				$("#uploadInfo").text("上传失败！");
				$("#uploadOk").attr("style", "display: inline;");
				$("#uploadOk").attr("class", "glyphicon glyphicon-remove");
			}
		});
	}
}

/**
 * this block is modify(nickname address profile) use asynchronized
 */
var errorInfo = $("#modifyInfoError");
function submitModifyInfo() {
	var nickname = $("#nickname").val().trim();
	var address = $("#address").val().trim();
	var profile = $("#profile").val().trim();
	var ability = $("#ability").val().trim();
	var videoTemp = $("#video").val().trim().split("src=")[1];
	var video = videoTemp.split('"')[1];
	
	var flag = checkInfoData(nickname, address, profile, ability, video);
	if(flag) {
		$.post('modifyUserInfo!modifyInfo.action', {
			"uid.nickname" : nickname,
			"uid.address" : address,
			"uid.profile" : profile,
			"uid.ability" : ability,
			"uid.category" : $('input[name="uid.category"]:checked').val(),
			"uid.field" : $('input[name="uid.field"]:checked').val(),
			"uid.video" : video
		}, function(data, textStatus) {
			if(textStatus == "success") {
				//alert(JSON.stringify(data));
				if(!data.errorInfo.success) {
					errorInfo.text(data.errorInfo.nickname+" "+data.errorInfo.address+" "+data.errorInfo.profile+" "+data.errorInfo.update + "" + data.errorInfo.category + "" + data.errorInfo.ability + "" + data.errorInfo.field);
					alert("信息修改失败");
				} else {
					errorInfo.text("信息修改成功！");
					alert("信息修改成功");
				}
					
			} else {
				alert("网络错误！请刷新重试");
			}
		}, 'json');
	}
}
function checkInfoData(nickname, address, profile, ability, video) {
	var flagNickname = false;
	var flagAddress = false;
	var flagProfile = false;
	var flagAbility = false;
	var flagVideo = false;
	if(nickname === "" || nickname.length < 2 || 16 < nickname.length) {
		errorInfo.text("用户昵称长度必须在2-16个字之间");
	} else
		flagNickname = true;
	
	if(address === "" || address.length > 16) {
		errorInfo.text("用户地址不能为空，且长度不能超过16个字！");
	} else
		flagAddress = true;
	
	if(profile === "" || profile.length > 254) {
		errorInfo.text("用户简介不能为空，且长度不能超过255个字！");
	} else
		flagProfile = true;
	
	if(ability === "") {
		errorInfo.text("请进信息填写完整！");
	} else {
		flagAbility = true;
	}
	
	
	if(flagNickname && flagAddress && flagProfile && flagAbility)
		return true;
	else
		return false;
}



/**
 * this block is modify(password) use asynchronized
 */
var error = $("#modifyError");
function submitModifyPassword() {
	var password = $("#password").val().trim();
	var newPassword = $("#newPassword").val().trim();
	var reNewPassword = $("#reNewPassword").val().trim();
	var flag = checkData(password, newPassword, reNewPassword);
	if(flag) {
		$.post('modifyUserInfo!modifyPassword.action', {
			"uid.password" : password,
			"uid.newPassword" : newPassword
		}, function(data, textStatus) {
			if(textStatus == "success") {
				
				if(!data.error.success) {
					error.text(data.error.password+" "+data.error.newPassword+" "+data.error.update);
					alert("密码修改失败");
				} else {
					error.text("密码修改成功！");
					alert("密码修改成功");
				}
					
			} else {
				alert("网络错误！请刷新重试");
			}
		}, 'json');
	}
}
function checkData(password, newPassword, reNewPassword) {
	var flagP = false;
	var flagN = false;
	var flagPN = false;
	if(password === "" || password.length < 6) {
		error.text("必须填写正确的原始密码");
	} else
		flagP = true;
	
	if(newPassword === "" || newPassword.length < 6) {
		error.text("新密码长度必须在6-16之间！");
	} else
		flagN = true;
	
	if(newPassword !== reNewPassword) {
		error.text("新密码与确认密码必须填写一致！");
	} else
		flagPN = true;
	
	if(flagP && flagN && flagPN)
		return true;
	else
		return false;
}