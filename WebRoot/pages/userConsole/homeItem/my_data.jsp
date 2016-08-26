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
						个人中心
					</h2>
				</div>
			</div>
			
			<div class="uk-block uk-block-muted" style="width:100%;">

                <div class="uk-container">

                    <div class="uk-grid uk-grid-match" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-2 uk-row-first">
                            <div class="uk-panel">
                             	<div class="uk-thumbnail uk-thumbnail-large">
									<img  style="height: 300px;" src='<s:property value="#session.user.userPhoto"/>' />
								</div>
                            </div>
                        </div>
                        <div class="uk-width-medium-1-2">
                            <div class="uk-panel">
                                <ul class="uk-list uk-list-line">
									<li>用户昵称:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.userNickName"/></span></li>
									<li>用户邮箱:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.userEmail"/></span></li>
									<li>所属高校:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.userAddress"/></span></li>
									<li>能力方向:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.copartnerCategory"/></span></li>
									<li>关注领域:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.userField"/></span></li>
									<li>用户经历:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.userIntroduce"/></span></li>
									<li>创业能力:&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="#session.user.startAbility"/></span></li>
								</ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            
			 <div class="uk-width-medium-1-1 uk-container-center">
                <div class="uk-panel uk-panel-box uk-panel-box-default" style="text-align: center;">
						<div class="uk-grid">
						    <div class="uk-width-3-10">
								<span class="uk-h2">认证情况</span>
								<!-- <label style="border-radius: 10px;margin-right: 20px;float: right;font-size: 24px">认证情况：</label> -->
							</div>
						    <div class="uk-width-7-10">
						    <div class="uk-grid">
			                     <div class="uk-width-1-3"><a class="uk-button" style="border: solid #398BE5 2px; border-radius: 10px;color: #398BE5;" href="">实名认证</a></div>
			                     <div class="uk-width-1-3"><a class="uk-button" style="border: solid #398BE5 2px; border-radius: 10px;color: #398BE5;" href="">实名认证</a></div>
			                     <div class="uk-width-1-3"><a class="uk-button" style="border: solid #398BE5 2px; border-radius: 10px;color: #398BE5;" href="">实名认证</a></div>
			                </div>
						</div>
					</div>
				</div>
            </div>
            
		</div>
