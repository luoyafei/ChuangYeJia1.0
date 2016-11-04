/**
 * 
 */

/* 用来检测邮箱的函数 */
function checkTel() {
	var tel = $("#tel").val().trim();
	var alerttel = $(".alert-tel");
	var checktel = $(".alert-check-tel");
	if (tel === "") {
		alerttel.attr("style", "display:inline-block;");
		checktel.attr("style", "display:none;");
	} else {
		alerttel.attr("style", "display:none;");
//		if(tel.match(/^[a-z0-9]+([._]*[a-z0-9]+)*@[a-z0-9]+([_.][a-z0-9]+)+$/gi)) {
		if(tel.match(/\d{11}/)) {
			checktel.attr("style", "display:none;");
			
			$.post('vaction!checkTel.action', { 
				tel : tel
			}, function(data, textStatus) {
				if(textStatus == "success") {
					checktel.attr("style", "display:inline-block;");
					if(data) {
						checktel.attr("style", "display:none;");
					} else {
						$(".tel-error").text("该电话号码暂未注册");
					}
				} else {
					alert("网络出错" + textStatus);
				}
			}, 'json');
		} else {
			checktel.attr("style", "display:inline-block;");
			$(".tel-error").text("请输入正确的电话号码，例如:18888888888");
		}
	}
}
/* 用来检测密码的函数 */
function checkpassword() {
	
	var password = $("#password").val().trim();
	if (password === "" || password.length < 6) {
		$(".alert-password").attr("style", "display:inline-block;");
		return false;
	} else {
		$(".alert-password").attr("style", "display:none;");
		return true;
	}
}


/* 用来检测验证码的函数 */
function checkIdentifyCode() {
	var identifyCode = $("#identifyCode").val().trim();
	if(identifyCode === "") {
		$(".alert-check-identifycode").attr("style", "display:none;");
		$(".alert-identifycode").attr("style", "display:inline-block;");
		return 0;
	} else {
		$(".alert-identifycode").attr("style", "display:none;");
		$.post('vaction!checkIdentifyCode.action', {
			identifyCode : identifyCode
		}, function(data, textStatus) {
			if(textStatus == "success") {
				if(!data) {
					$(".alert-check-identifycode").attr("style", "display:inline-block;");
				} else {
					$(".alert-check-identifycode").attr("style", "display:none;");
				}
			} else {
				alert("网络出错" + textStatus);
				return 0;
			}
		}, 'json');
	}
}
function checkdata() {
	
	if(checkpassword() && $("#tel").val().trim()!=="" && $("#identifyCode").val().trim()!=="")
	 	return true;
	else {
		alert("请将信息核实正确并填写完整！");
		return false;
	}
}