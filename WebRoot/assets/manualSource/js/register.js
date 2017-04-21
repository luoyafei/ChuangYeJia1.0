/**
 * 
 */
	$(document).ready(function() {
		$("#clickSend").bind("click", sendTel);
	});
	
	function sendTel() {
		if($("#tel").val().trim() !== "" && $("#tel").val().trim().match(/^1[34578]\d{9}$/) && $("#nickname").val().trim()) {
			$.post('sendMessage!sendMessage.action', {
				nickname : $("#nickname").val().trim(),
				tel : $("#tel").val().trim()
			}, function(data, textStatus) {
				if(textStatus == "success") {
					if(data.success) {
						alert("发送成功！请您注意查收您的短信！");
						$("#clickSend").unbind("click");
						$("#clickSend").attr("disabled", "disabled");
						var i = 300;
						var runTime = setInterval(function() {
							$("#clickSend").text(i-- + "秒后重新点击获取手机验证码");
							if(i == -2) {
								$("#clickSend").removeAttr("disabled");
								$("#clickSend").text("点击获取手机验证码");
								i == 300;
								clearInterval(runTime);
								$("#clickSend").bind("click", sendTel);
							}
						}, 1000);
					} else {
						alert(data.reason);
					}
				}
			}, 'json'); 
		} else {
			alert("请先输入正确的电话号码和用户名！");
		}
	}
	
	function sendEmail() {
		if($("#email").val().trim() !== "" && $("#email").val().trim().match(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/)) {
			$.post('sendEmail!sendEmail.action', {
				email : $("#email").val().trim()
			}, function(data, textStatus) {
				if(textStatus == "success") {
					if(data.success) {
						alert("发送成功！请登录您的邮箱进行查看，有可能您的邮箱设置的自动拦截，如果找不到的话，在垃圾箱寻找！");
						$("#clickSend").unbind("click");
						$("#clickSend").attr("disabled", "disabled");
						var i = 300;
						var runTime = setInterval(function() {
							$("#clickSend").text(i-- + "秒后重新点击获取邮箱验证码");
							if(i == -2) {
								$("#clickSend").removeAttr("disabled");
								$("#clickSend").text("点击获取邮箱验证码");
								i == 300;
								clearInterval(runTime);
								$("#clickSend").bind("click", sendEmail);
							}
						}, 1000);
					} else {
						alert("错误！");
					}
				}
			}, 'json'); 
		} else {
			alert("请先输入邮箱");
		}
	}
	
	
	

/* 用来检测昵称的函数*/
function checknickname() {
	var alertnickname = $(".alert-nickname");
	var nickname = $("#nickname").val().trim();
	if (nickname === "" || nickname.length < 2) {
		alertnickname.attr("style", "display:inline-block;");
		return false;
	} else {
		alertnickname.attr("style", "display:none;");
		return true;
	}
}
/* 用来检测邮箱的函数 */
function checktel() {
	var tel = $("#tel").val().trim();
	var alerttel = $(".alert-tel");
	var checktel = $(".alert-check-tel");
	if (tel === "") {
		alerttel.attr("style", "display:inline-block;");
		checktel.attr("style", "display:none;");
		return 0;
	} else {
		alerttel.attr("style", "display:none;");
		var reg = /^1[34578]\d{9}$/;
		if(tel.match(reg)) {
			checktel.attr("style", "display:none;");
			
			$.post('vaction!checkTel.action', { 
				tel : tel
			}, function(data, textStatus) {
				if(textStatus == "success") {
					checktel.attr("style", "display:inline-block;");
					if(data) {
						$(".tel-error").text("该电话号码已被注册");
						return 0;
					} else {
						$(".tel-error").text("该电话号码可用");
						return 1;
					}
				} else {
					alert("网络出错" + textStatus);
					return 0;
				}
			}, 'json');
		} else {
			checktel.attr("style", "display:inline-block;");
			$(".tel-error").text("请输入正确的电话号码，如：18888888888");
			return 0;
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
function checkrepassword() {
	var password = $("#password").val().trim();
	var repassword = $("#repassword").val().trim();
	if (repassword === "" || password !== repassword) {
		$(".alert-repassword").attr("style", "display:inline-block;");
		return false;
	} else if (password === repassword) {
		$(".alert-repassword").attr("style", "display:none;");
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

function checkMicro() {
	if($("#profile").val().trim() != "" && $("#address").val().trim() != "" && $("#picture").val().trim() != "") {
		return true;
	} else
		return false;
}
function checkdata() {
	var telCode = $("#telCode").val().trim();
	if(checknickname() && checkpassword() && checkrepassword() && $("#tel").val().trim()!=="" && $("#identifyCode").val().trim()!=="" && telCode !== "" && telCode.length === 6)
	 	return true;
	else {
		alert("请将信息核实正确并填写完整！");
		return false;
	}
}