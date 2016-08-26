/**
 * 
 */

/* 用来检测邮箱的函数 */
function checkemail() {
	var email = $("#email").val().trim();
	var alertemail = $(".alert-email");
	var checkemail = $(".alert-check-email");
	if (email === "") {
		alertemail.attr("style", "display:inline-block;");
		checkemail.attr("style", "display:none;");
	} else {
		alertemail.attr("style", "display:none;");
		if(email.match(/^[a-z0-9]+([._]*[a-z0-9]+)*@[a-z0-9]+([_.][a-z0-9]+)+$/gi)) {
			checkemail.attr("style", "display:none;");
			
			$.post('vaction!checkEmail.action', { 
				email : email
			}, function(data, textStatus) {
				if(textStatus == "success") {
					checkemail.attr("style", "display:inline-block;");
					if(data) {
						//$(".email-error").text("该邮箱");
						checkemail.attr("style", "display:none;");
					} else {
						$(".email-error").text("该邮箱暂未注册");
					}
				} else {
					alert("网络出错" + textStatus);
				}
			}, 'json');
		} else {
			checkemail.attr("style", "display:inline-block;");
			$(".email-error").text("请输入正确的邮箱地址,例如:chuangyejia@163.com");
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
	
	if(checkpassword() && $("#email").val().trim()!=="" && $("#identifyCode").val().trim()!=="")
	 	return true;
	else {
		alert("请将信息核实正确并填写完整！");
		return false;
	}
}