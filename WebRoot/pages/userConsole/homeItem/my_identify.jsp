<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 100%;">
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">
						WHO&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;AM
					</p>
					<p style="float: right;">
						随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
					</p>
					<h2 style="margin-top: 0;" style="color: black;">
						我的认证
					</h2>
				</div>
			</div>
			
			<div class="uk-block uk-block-muted" style="width:100%;">

                <div class="uk-container">

                    <div class="uk-grid uk-grid-match" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-2 uk-row-first">
                            <div class="uk-panel">
                             	<div class="uk-thumbnail uk-thumbnail-large">
                             		<s:if test="#session.user.userRealPhoto.hashCode() == 0">
                             			<!-- 尚未审核 -->
                             			<img  style="height: 300px;"  id="userImg" src="/ChuangYeJia/assets/manualSource/img/not_identify.png" />
                             		</s:if>
                             		<s:elseif test="#session.user.isVerify==\"3\" ">
                             			<!-- 正在审核 -->
                             			<img  style="height: 300px; z-index: 1;position: absolute; opacity: 0.4;" src="/ChuangYeJia/assets/manualSource/img/ing_identify.png" />
                             			<img  style="height: 300px; z-index: -1;"  id="userImg" src='<s:property value="#session.user.userRealPhoto"/>' />
                             		</s:elseif>
                             		<s:elseif test="#session.user.isVerify==\"2\" ">
                             			<!-- 审核失败 -->
                             			<img  style="height: 300px; z-index: 1;position: absolute; opacity: 0.4;" src="/ChuangYeJia/assets/manualSource/img/fail_identify.png" />
                             			<img  style="height: 300px; z-index: -1;"  id="userImg" src='<s:property value="#session.user.userRealPhoto"/>' />
                             		</s:elseif>
                             		<s:else>
	                             		<!-- 审核成功 -->	
                             			<img  style="height: 300px; z-index: 1;position: absolute; opacity: 0.4;" src="/ChuangYeJia/assets/manualSource/img/ok_identify.png" />
                             			<img  style="height: 300px; z-index: -1;"  id="userImg" src='<s:property value="#session.user.userRealPhoto"/>' />
                             		</s:else>
								</div>
                            </div>
                        </div>
                        
                        
                      	<s:if test="#session.user.isVerify==\"0\" || #session.user.isVerify==\"2\"">
	                        <div class="uk-width-medium-1-2">
	                            <div class="uk-panel">
	                            	<h3 style="color: red;">请上传本人学生证以完成身份认证</h3>
									<div class="form-group" style="margin-right: 0px;margin-left: -10px;padding-top: 15px;">
										<div class="col-sm-12">
											<article class="uk-comment">
			                                    <header class="uk-comment-header">
			                                        <h4 class="uk-comment-title">
														<input type="file" id="picture" style="display:inline;" name="picture" accept="image/*"/>
														<button id="uploadBtn" type="button" class="uk-button uk-button-danger" onclick="userphoto_upload()">
															<span id="uploadInfo">立即上传</span>
															<span id="uploadOk" class="" aria-hidden="true" style="display: none;"></span>
														</button>
													</h4>
													
			                                    </header>
			                                </article>
										</div>
									</div>
	                            </div>
	                        </div>
                        </s:if>
                        
                        <div class="uk-thumbnail uk-thumbnail-expand">
                            <img src="/ChuangYeJia/assets/manualSource/img/default_identify.png" alt="" height="400" width="600">
                            <div class="uk-thumbnail-caption"><code>上传样本</code></div>
                        </div>
                    </div>
                </div>
            </div>
		</div>
		
		<s:if test="#session.user.isVerify==\"0\" || #session.user.isVerify==\"2\"">
 						<script type="text/javascript">
	                        function userphoto_upload() {
	                        	if($("#picture").val().trim() === "")
	                        		alert("请选择图片后进行上传");
	                        	else {
	                        		$("#uploadBtn").attr("disabled", "true");
	                        		$("#uploadInfo").text("图片正在玩命上传！请稍后...");
	                        		var fd = new FormData();
	                        		fd.append("picture", $("#picture").get(0).files[0]);
	                        		$.ajax({
	                        			url: "uploadPicture!uploadIdentify.action",
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
                        </script>
			</s:if>