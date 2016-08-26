<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

 	<title>邀请成员加入</title>
    <!-- Bootstrap core JavaScript
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=path %>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
	<script src="<%=path %>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
	<script src="<%=path %>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>

	<!-- Bootstrap core CSS -->
	<link href="<%=path %>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=path %>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
	<link href="<%=path %>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">

	<!-- uikit -->
	<script src="<%=path%>/assets/uikit/uikit.js"></script>
	<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>
	<script src="<%=path%>/assets/uikit/form-select.js"></script>
	<link href="<%=path%>/assets/uikit/form-select.css" rel="stylesheet"/>

        <style>
	        body {
			    font-family: "微软雅黑";
			    padding-bottom: 0px;
			}
			
			li a {
			    color: snow;
			}
			
			.row .img {
			    margin-right: 5px;
			}
			
			.nav .active a {
			    border-bottom: solid #398BE5 3px;
			    color: #398BE5;
			    font-weight: bold;
			}
			
			#navbar ul a:hover {
			    border-bottom: solid #398BE5 3px;
			    color: #398BE5;
			    background-color: transparent;
			}
			
			#choicelabel a {
			    color: black;
			}
			
			#choicelabel .active {
			    color: #398BE5;
			}
			
			#inputSearch {
			    border-radius: 20px;
			    background-color: #A9A9A9;
			}
			
			.col-lg-3 {
			    margin: 0 0;
			    padding: 0 0;
			}
			
			.col-lg-4 {
			    margin: 0 0;
			    padding: 0 0;
			}
			
			.marketing .col-lg-4 {
			    margin-bottom: 0px;
			}
			
			.alert {
			    padding: 0;
			    margin-bottom: 0px;
			}
		
		</style>

</head>
<body style="background-color: #F5F5F5;">
        
		<jsp:include page="/pages/module/index_bar.jsp" flush="true" />
        
        <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 0px;">
          
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="" src="<%=path %>/assets/img/user/333.png" alt="">
                    <div class="container" style="padding-right: 0px;padding-left: 0px;">
                        <div class="carousel-caption">
                            <div class="logo-img" style="width: 100%;">
                                <span>
                                    <img src="<%=path %>/assets/img/user/logo.png" style="width: 18%;height: 6%; margin-bottom: 0px;padding-bottom: 0px;">
                                </span>
                                <span>
                                    <a style="font-size: 22px;text-decoration: none;">
                                        <span style="display: block;">创业加</span>
                                        <br />
                                    </a>
                                </span>
                            </div>
                            <p style="margin-bottom: 0px;font-size: 34px;">
                              	申请加入
                            </p>
                            <span style="border-top: solid white 2px;" style="font-family: sans-serif;">Hello!Welcome to Enterperse Plus</span>
                            <br />
                            <br />
                            <br />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 78%;">
            
            <div class="content-main" style="width: 100%;height: 100%;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
                <div class="content-main-top" style="height: 100%;">
                
                
                    <div style="width: 80%;height: 100%;margin: 50px auto;">

						<label id="inviteSendError" style="text-align: center;color: #398BE5; width: 100%;"></label>
						
						
						
						<div class="form-group">
                           <label for="startups" style="text-align: right;margin-top: 6px;" class="col-md-2 control-label">选择公司</label>
                           <div class="col-md-10">
                            <div class="uk-button uk-form-select uk-active" data-uk-form-select="">
                                <span></span>
                                <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                                <select id="selectFlag">
                                	<option value="0">选择您想邀请ta加入的公司</option>
                                </select>
                            </div>
                               <hr />
                           </div>
                       </div>
						
						
						
                        <div class="form-group">
                           <label for="name" style="text-align: right;margin-top: 6px;" class="col-md-2 control-label">合同名</label>
                           <div class="col-md-10">
                               <input type="text" maxlength="16" class="form-control" name="contract_name" id="name" placeholder="合同名">
                               <div class="alert alert-danger alert-name" role="alert" style="display: none;">
                                   	请输入合同名称
                               </div>
                               <hr />
                           </div>
                       </div>


                        <div class="form-group">
                            <label for="content" class="col-md-2 control-label" style="text-align: right;margin-top: 6px;">合同内容&nbsp;&nbsp;</label>
                            <div class="col-md-10">
                                <textarea id="content" name="contract_content" style="width:100%;height:200px;"></textarea>
                                <div class="alert alert-danger alert-content" role="alert" style="display: none;">
                                   	请输入合同内容
                               </div>
                            </div>
                        </div>


                        <div style="text-align: center;">
                            <button class="btn btn-default" id="sendInvite" style="color: #398BE5;margin-top: 40px;">
                                 	  发送邀请 
                        	</button>
                       	</div>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="../../module/bottom.jsp" flush="true" />
           
        </body>
        <script>
        $(document).ready(function() {
            $("td").attr("style", "border-top: solid #333333 1px;");
            
            $.post('getMyLeaderForInvite!justDoIt.action', {}, function(data, textStatus) {
            	if(textStatus == "success") {
            		if(data.leaderS.length == 0) {
            			$("#inviteSendError").text("您还没有自己的公司！请先创建属于自己的公司后，再进行邀请成员吧！");
            		} else {
            			for(var i = 0; i < data.leaderS.length; i++) {
            				var option = $('<option></option>');
            				option.attr("value", data.leaderS[i].startupsId);
            				option.text(data.leaderS[i].startupsName);
            				option.appendTo($("#selectFlag"));
            			}
            		}
            		
            	} else {
            		alert("网络出错！请刷新重试！");
            	}
            }, 'json');
            
            $("#sendInvite").bind('click', function() {
            	
            	var name = $("#name").val().trim();
                var content = $("#content").val().trim();
               	var startups = $("#selectFlag").val().trim();
                if(startups === "") {
                	$("#inviteSendError").text("您还没有自己的公司！请先创建属于自己的公司后，再进行邀请成员吧！");
                } else {
                	if (name === "") {
                		 $(".alert-name").attr("style", "display:inline-block;");
                	} else if(content === "") {
                    	$(".alert-content").attr("style", "display:inline-block;");
                    }
                }
                
                if(name !== "" && content !== "" && startups !== "") {
                	$.post('inviteJoin!inviteJoin.action', {
                		name : name,
                		content : content,
                		startups : startups,
                		userId : "<s:property value='#parameters.join'/>"
                	}, function(data, textStatus) {
                		if(textStatus == "success") {
                			if(data.success) {
                				$("#inviteSendError").text("恭喜！您已经成功发送邀请合同到该合伙人手中！请敬候佳音！");
                			} else {
                				$("#inviteSendError").text(data.reason);
                			}
                		}
                	}, 'json');
                }
                
            });
        });
    </script>
</html>