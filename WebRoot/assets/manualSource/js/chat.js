$("#send_downLine").click(function() {
		$("#downLine_enter").toggle();
	});
	$("#downLine_send").click(function() {
		var tel = $("#downLine_tel_content").val().trim();
		if(tel !== null && tel !== "" && tel.length != 11 && !tel.match("/[\d]{11}/")) {
			alert("请输入您的正确电话方便我们客服为您提供服务,谢谢合作...");
		} else {
			$.post("downLineAction!justDoit.action", {}, function(data, textStatus) {
				
			}, "json");
		}
	});
	$('#myTab a').click(function(e) {
		e.preventDefault()
		$(this).tab('show')
	})
	$(document).ready(function() {
		$("#downLine_enter").hide();
		
		$("td").attr("style", "border-top: solid #333333 1px;");
		
		/**
		*解决接收推送的重复问题
		*/
		var toPushSpan = 0;
		var webSocket = null;
		init();
		var toUser = {};
		
		function init() {
			var url = location.href;
			var socketUrlInWindow = 'ws' + url.substring(url.indexOf(":"), url.indexOf("/", 10)) + '/ChuangYeJia/chat/server';
			var socketUrlInMozWeb = 'ws:' + url.substring(url.indexOf(":") + 3, url.indexOf("/", 10)) + '/ChuangYeJia/chat/server';
		    if ('WebSocket' in window) {  
//		        webSocket = new WebSocket('ws://chuangyejia.site/ChuangYeJia/chat/server');
		    	webSocket = new WebSocket(socketUrlInWindow);
		    } else if ('MozWebSocket' in window) {  
//		        webSocket = new MozWebSocket('ws:chuangyejia.site/ChuangYeJia/chat/server');
		    	webSocket = new MozWebSocket(socketUrlInMozWeb);
		    }

			webSocket.onerror = function(event) {
				onError(event);
			};

			webSocket.onopen = function(event) {
				onOpen(event);
			};

			webSocket.onmessage = function(event) //接受客户端消息
			{
				onMessage(event);
			};
		}

		
		function onMessage(event) {
			var json = JSON.parse(event.data);
			toUser = json.toUser;
			if(json.notRead != null && json.first != null) {
				for(var i = 0; i < json.notRead.length; i++) {
					var article = $('<article></article>');
					article.attr("class", "uk-comment toUser_article");
					var header = $('<header></header>');
					header.attr("class", "uk-comment-header");
					header.appendTo(article);
					var img = $('<img />');
					img.attr("class", "uk-comment-avatar uk-border-rounded toUser_photo");
					img.attr("src", json.toUser.userPhoto);
					img.attr("alt", "图片正在玩命加载中...");
					img.attr("style", "width: 50px; height: 50px;");
					img.appendTo(header);
					var h4 = $('<h4></h4>');
					h4.attr("class", "uk-comment-title");
					h4.text(json.toUser.userNickName + ":" + json.notRead[i].messageSendTime);
					h4.appendTo(header);
					var div = $('<div></div>');
					div.attr("class", "uk-comment-meta");
					div.appendTo(header);
					var span = $('<span></span>');
					span.attr("class", "uk-h4");
					span.text(json.notRead[i].chatMessage);
					span.appendTo(div);
					
					article.appendTo($("#message_panel"));
				}
				json.notRead = null;//使用之后赋值为 null
				
				/*
				接收到历史消息
				*/
				if(json.historyMsg != null) {
					for(var i = 0; i < json.historyMsg.length; i++) {
						if(json.historyMsg[i].fromUserId == json.toUser.userId) {
							var article = $('<article></article>');
							article.attr("class", "uk-comment");
							var header = $('<header></header>');
							header.attr("class", "uk-comment-header");
							header.appendTo(article);
							var img = $('<img />');
							img.attr("class", "uk-comment-avatar uk-border-rounded");
							img.attr("src", json.toUser.userPhoto);
							img.attr("alt", "图片正在玩命加载中...");
							img.attr("style", "width: 50px; height: 50px;");
							img.appendTo(header);
							var h4 = $('<h4></h4>');
							h4.attr("class", "uk-comment-title");
							h4.text(json.toUser.userNickName + ":" + json.historyMsg[i].messageSendTime);
							h4.appendTo(header);
							var div = $('<div></div>');
							div.attr("class", "uk-comment-meta");
							div.appendTo(header);
							var span = $('<span></span>');
							span.attr("class", "uk-h4");
							span.text(json.historyMsg[i].chatMessage);
							span.appendTo(div);
							
							article.appendTo($("#his_message_panel"));
						} else {

							var article = $('<article></article>');
							article.attr("class", "uk-comment uk-comment-primary");
							var header = $('<header></header>');
							header.attr("class", "uk-comment-header");
							header.appendTo(article);
							var img = $('<img />');
							img.attr("class", "uk-comment-avatar uk-border-rounded");
							img.attr("src", '<s:property value="#session.user.userPhoto"/>');
							img.attr("alt", "图片正在玩命加载中...");
							img.attr("style", "width: 50px; height: 50px;float: right;");
							img.appendTo(header);
							var h4 = $('<h4></h4>');
							h4.attr("class", "uk-comment-title");
							h4.attr("style", "float: right;");
							h4.text("我" + ":" + json.historyMsg[i].messageSendTime);
							h4.appendTo(header);
							var div = $('<div></div>');
							div.attr("class", "uk-comment-meta uk-flex-right");
							div.appendTo(header);
							var span = $('<span></span>');
							span.attr("class", "uk-h4");
							span.text(json.historyMsg[i].chatMessage);
							span.appendTo(div);
							
							
							article.appendTo($("#his_message_panel"));
						}
					}
				}
				
			}
			
			if(json.sendOne != null) {
				
				var article = $('<article></article>');
				article.attr("class", "uk-comment uk-comment-primary");
				var header = $('<header></header>');
				header.attr("class", "uk-comment-header");
				header.appendTo(article);
				var img = $('<img />');
				img.attr("class", "uk-comment-avatar uk-border-rounded");
				img.attr("src", '<s:property value="#session.user.userPhoto"/>');
				img.attr("alt", "图片正在玩命加载中...");
				img.attr("style", "width: 50px; height: 50px;float: right;");
				img.appendTo(header);
				var h4 = $('<h4></h4>');
				h4.attr("class", "uk-comment-title");
				h4.attr("style", "float: right;");
				h4.text("我" + ":" + json.sendOne.messageSendTime);
				h4.appendTo(header);
				var div = $('<div></div>');
				div.attr("class", "uk-comment-meta uk-flex-right");
				div.appendTo(header);
				var span = $('<span></span>');
				span.attr("class", "uk-h4");
				span.text(json.sendOne.chatMessage);
				span.appendTo(div);
				
				article.appendTo($("#message_panel"));
				
				json.sendOne = null;//使用之后赋值为null
			}

			if(json.pushToUser != null && toPushSpan === 0) {
			  /**
				*解决重复问题
				*/
				toPushSpan = 1;
				var article = $('<article></article>');
				article.attr("class", "uk-comment");
				var header = $('<header></header>');
				header.attr("class", "uk-comment-header");
				header.appendTo(article);
				var img = $('<img />');
				img.attr("class", "uk-comment-avatar uk-border-rounded");
				img.attr("src", toUser.userPhoto);
				img.attr("alt", "图片正在玩命加载中...");
				img.attr("style", "width: 50px; height: 50px;");
				img.appendTo(header);
				var h4 = $('<h4></h4>');
				h4.attr("class", "uk-comment-title");
				h4.text(json.toUser.userNickName + ":" + json.pushToUser.messageSendTime);
				h4.appendTo(header);
				var div = $('<div></div>');
				div.attr("class", "uk-comment-meta");
				div.appendTo(header);
				var span = $('<span></span>');
				span.attr("class", "uk-h4");
				span.text(json.pushToUser.chatMessage);
				span.appendTo(div);
				
				article.appendTo($("#message_panel"));
			} else {
				/**
				*解决重复问题
				*/
				toPushSpan = 0;
			}
			if(json.toUser != null) {
				$(".toUser_photo").attr("src", json.toUser.userPhoto);
				$(".toUser_nickname").text(json.toUser.userNickName);
			}
		}
		
		function onOpen(event) {
			webSocket.send("<s:property value='#parameters.toUserId'/>"); //发送消息给服务器端
		}

		function onError(event) {
			alert(event.data);
		}

		$("#send_message").on('click', function() {
			webSocket.send($("#message_input").val()); //发送消息给服务器端
			$("#message_input").val("");
		});
		
	});	
	