<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<title>
			免责申明
		</title>
		<!-- Bootstrap core CSS -->
		<link href="<%=path%>/assets/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie-emulation-modes-warning.js"></script>
		<link href="<%=path%>/assets/bootstrap-3.3.5/docs/examples/carousel/carousel.css" rel="stylesheet">

		<!-- Bootstrap core JavaScript
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=path%>/assets/jQuery/2.x/jquery-2.1.4.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
		<script src="<%=path%>/assets/bootstrap-3.3.5/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
		
		<script src="<%=path%>/assets/uikit/uikit.js"></script>
		<link href="<%=path%>/assets/uikit/uikit.css" rel="stylesheet"/>
		
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
			<!-- Indicators -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="" src="../../assets/img/user/333.png" alt="">
					<div class="container" style="padding-right: 0px;padding-left: 0px;">
						<div class="carousel-caption">
							<div class="logo-img" style="width: 100%;">
								<span>
									<img src="../../assets/img/user/logo.png" style="width: 18%;height: 6%; margin-bottom: 0px;padding-bottom: 0px;">
								</span>
								<span>
									<a style="font-size: 22px;text-decoration: none;">
										<span style="display: block;">创业加</span>
										<br />
									</a>
								</span>
							</div>
							<p style="margin-bottom: 0px;font-size: 44px;">
								免责声明
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
		<div class="container marketing" style="background-color: #F5F5F5; padding:50px 0px;width: 68%;">
			<!-- Three columns of text below the carousel -->
			<div class="thumbtitle">
				<div class="contenttitle" style="margin-bottom: 10px;">
					<p style="margin-bottom: 4px;">
						ABOUT&nbsp;&nbsp;OUR
					</p>
					<p style="float: right;">
						随经济全球化以及生产专业化现象的普遍，社会分工和协同合作已经成为了一种创业趋势。
					</p>
					<h2 style="margin-top: 0;" style="color: black;">
						免责声明
					</h2>
				</div>
			</div>
			<div class="content-main" style="width: 100%;height: 100%;padding-bottom: 50px;background-color: white;overflow: hidden;border-bottom: solid #A9A9A9 2px;border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
				<div class="content-main-top" style="height: 27%;">
					<div style="width: 80%;height: 100%;margin: 0 auto;">
						
						
						<br /><strong>免责声明</strong><br />
							
<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本协议是使用创业加系统软件服务的用户（以下简称“用户”或“您”）与创业加公司就创业加系统软件的使用等相关事宜所签订的协议，请用户在点击“同意”按钮之前，详细阅读本协议，用户可以选择不接受该协议条款，但用户点击“同意”按钮并提交后，依据《中华人民共和国合同法》《中华人民共和国电信条例》《互联网信息服务管理办法》等相关法律法规的规定，本协议即构成双方合法有效、对双方具有约束力的法律文件。
<br />一、协议的签署
<br />1、本平台提供的各项服务的所有权及运营权归创业加公司享有，您在注册完成后，即视为已经充分阅读并理解了本协议约定的条款，对标黑加粗的部分，再次提醒您重点阅读。
<br />2、在注册之前，请您确认同意该协议条款，如果您不同意本协议内容或对本协议内容有异议，请您立即停止注册。
<br />3、当您按照注册页面提示填写信息、阅读并同意本协议且完成全部注册程序后，即表示您已充分阅读、理解并接受本协议的全部内容，本协议即产生法律约束力。您承诺接受并遵守本协议的约定，届时您不应以未阅读本协议的内容或者未获得创业加对您问询的解答等理由，主张本协议无效，或要求撤销本协议。
<br />二、用户注册
<br />1、用户保证提供的注册信息（包括但不限于个人信息、企业信息等）真实、及时、完整和准确。如果信息有变动，用户应及时通知本平台，若用户未及时通知或提供注册的信息不真实、不准确、不合法，由此产生的一切法律责任及后果（包括本平台的损失）均由用户自行承担。同时，本平台有权暂停或终止向用户提供全部或部分服务。
<br />2、您了解并同意，创业加注册账号所有权归属于创业加，注册完成后，您仅获得账号使用权。创业加账号使用权仅归属于初始申请注册人，不得以任何方式转让或被提供予他人使用，否则，创业加有权立即不经通知收回该账号，由此带来的因您使用本服务产生的全部数据、信息等被清空、丢失等的损失，您应自行承担。
<br />3、用户注册成功后，将产生用户名及密码等用户信息，用户有更改密码的权利。用户应当妥善、谨慎的保管和使用账户信息，不得利用该账户从事违法犯罪或侵犯他人合法权益的行为。若用户发现住户密码被盗，请立即通知本平台或向司法机关报案。
<br />4、未经本平台同意，用户不得将注册成功的账户提供给其他方使用，否则由此产生的法律责任，由注册用户与实际使用人承担连带责任。
<br />5、若本平台有理由相信用户正在利用本平台从事违法活动，或依据司法行政机关的法律文书或命令，本平台有权依法进行相应的证据保全。
<br />6、您了解并同意，如您注册创业加系统软件标账号后连续超过12个月未登录，创业加系统软件为网站优化管理之目的有权回收该账号，相关问题及责任均由您自行承担。
<br />7、创业加根据本协议收回或取消账号后，有权自行对账号相关内容及信息以包括但不限于删除等方式进行处理，且无需就此向用户承担任何责任。
<br />三、用户责任
<br />1、根据《中华人民共和国电信条例》《互联网信息服务管理办法》《中华人民共和国计算机信息网络国际联网管理暂行规定》《中华人民共和国计算机信息系统安全保护条例》及本平台的相应规则，用户不得利用本平台制作、发布、传播含有下列内容的信息：
<br />a、反对宪法所确定的基本原则的；
<br />b、危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；
<br />c、损害国家荣誉和利益的；
<br />d、煽动民族仇恨、民族歧视，破坏民族团结的；
<br />e、破坏国家宗教政策，宣扬邪教和封建迷信的；
<br />f、散布谣言，扰乱社会秩序，破坏社会稳定的；
<br />g、散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；
<br />h、侮辱或者诽谤他人，侵害他人合法权益的；
<br />i、含有法律、行政法规禁止的其他内容的；
<br />2、用户不得从事干扰本平台的正常运转，非法侵入本平台及国家计算机信息系统的行为，不得利用本平台注册的账户进行非法牟利经营。
<br />若用户违反本条规定，本平台将依据《中华人民共和国侵权责任法》等相关法律、法规的规定，立即独立采取有效措施停止提供服务、关闭注销用户，由此产生的一切后果由用户自行承担。
<br />3、您了解并同意，在创业加系统软件服务提供过程中，创业加系统软件及其关联公司或其授权单位和个人有权以各种方式投放各种商业性广告或其他任何类型的推广信息，同时，您同意接受以电子邮件或其他方式向您发送的上述广告或推广信息。
<br />四、本平台服务
<br />本平台服务商提供互联网办公服务及相关软件、硬件的服务，其提供的服务会随着公司的经营而不断调整和变化。
<br />对于用户自行在本平台上传或发布的信息，本平台不负责实质性的审查。若在本平台上发布的信息有虚假、违法、侵权等情形的，均由发布者自行承担，本平台不承担任何的责任。但若出现上述情况，用户可及时通知本平台，经本平台查实后，本平台将依照相关法律、法规的规定采取屏蔽、注销、停止服务等措施。
<br />五、知识产权条款
<br />1、本平台在服务过程中提供的各种软件、硬件等产品的著作权、商标专用权、专利权等知识产权归本平台享有。
<br />2、用户因使用本平台提供的服务而产生或发布的各种信息、作品的知识产权归用户享有，但出于技术的需要，本平台可以无偿、永久的复制、存储、使用该信息。
<br />六、责任限制条款
<br />1、对于用户自行发布的信息，用户应当保证该信息的真实、合法性，本平台作为办公平台，无法控制该信息，若出现违法信息而产生的一切法律责任均由发布者自行承担，与本平台无涉，给本平台造成损失的，本平台将依法追究其相应的法律责任。
<br />2、无论在何种情况下，对因信息网络设备维护、信息传输故障、硬件通讯设备故障，及电力故障、罢工、社会事件、自然灾害等不可预见、不可避免、不可克服的因素所造成的不能提供服务或迟延提供服务，本平台不承担任何责任。
<br />3、不论是否可以预见，不论是源于何种形式的行为，创业加系统软件不对由以下原因造成的任何特别的，直接的，间接的，惩罚性的，突发性的或有因果关系的损害或其他任何损害（包括但不限于利润或利息的损失，营业中止，资料灭失）承担责任。
<br />3.1使用或不能使用服务；
<br />3.2通过服务购买或获取任何产品，样品，数据，信息或进行交易等，或其他可替代上述行为的行为而产生的费用；
<br />3.3未经授权的存取或修改数据或数据的传输；
<br />3.4第三方通过服务所作的陈述或行为；
<br />3.5其它与服务相关事件，包括疏忽等，所造成的损害；
<br />4、您充分了解并同意，鉴于互联网的特殊性，您在服务中分享的信息及个人资料有可能会被他人复制、转载、擅改或做其它非法用途；您在此已充分意识此类风险的存在，并确认此等风险应完全由您自行承担，创业加对此不承担任何责任。
<br />5、您了解并同意，在使用服务过程中可能存在来自任何他人的包括威胁性的、诽谤性的、令人反感的或非法的内容或行为或对他人权利的侵犯（包括知识产权）及匿名或冒名的信息的风险，基于服务使用规范所述，该等风险应由您自行承担，创业加对此不承担任何责任。
<br />七、保密及披露
<br />1、除本协议另有约定外，本平台保证不对外公开或向第三方提供用户的注册资料及用户在使用本平台服务时存储在本平台上合法、非公开内容，但下列情况除外：
<br />a、事先获得用户的明确授权的。
<br />b、根据有关的法律法规要求，本平台必须提供的。
<br />c、按照相关政府主管部门或司法部门的要求，本平台必须提供的。
<br />d、用户先行违反本协议内容造成本平台、他人或社会公共利益可能遭受损害的，本平台有权向相关当事人提供用户的相关信息。
<br />2、用户确认并同意：为了给用户提供更好的体验，本平台可能会与第三方合作向用户提供相关的网络服务，在此情况下，如该第三方同意承担与本网站同等的保护用户隐私的责任，则本平台有权将用户的注册资料、个人发布信息等提供给该第三方。
<br />八、协议终止
<br />1、为经营的需要，在任何时间，本平台都可以在以合理的方式通知用户，暂停或终止向用户提供全部或部分服务。对此，用户确认并予以理解，并承诺不因此追究本平台的任何责任。
<br />2、出现下列情况时，本平台有权决定终止提供服务，并终止本协议：
<br />a、用户提供的信息不真实、不合法或不及时更新。
<br />b、利用本平台从事违法、犯罪活动的。
<br />c、被本平台注销用户、终止服务的。
<br />d、本平台修改或更新用户协议，用户不同意或不接受的。
<br />e、本协议另有规定或本平台认为需要终止的其他情形。
<br />3、本协议终止后，用户同意本平台继续享有下述权利：
<br />a、继续在本平台上保留用户信息及服务期间的使用情况或使用信息。
<br />b、在服务期间存在违法或违反本协议的行为，本平台可依据本协议主张权利。
<br />c、法律、行政法规规定的及合同约定的其他情况。
<br />九、通知与维权
<br />1、用户在使用本平台服务时，若发现本平台内容有违反法律、法规的规定或侵犯他人合法权益（包括但不限于肖像权、姓名权、名誉权、知识产权等），或用户认为相关信息侵犯了自身的合法权益，用户应当如实向本平台告知并提交下列材料：
<br />a、涉嫌侵权信息的具体内容及位置、链接等。
<br />b、自身享有合法权益的证明。
<br />c、自身联系人姓名、地址、电话号码或电子邮件。
<br />d、身份证复印件或营业执照复印件。
<br />2、请按上述要求通过电子邮件的方式发送给本平台邮箱service@jingoal.com。
<br />本平台将在在收到该材料后，经审查属实的，本平台将尽快删除相关信息，本平台仅接受电子邮件方式的侵权通知。
<br />十、法律适用与管辖
<br />本协议之效力、解释、执行与争议解决均适用中华人民共和国大陆地区法律，如无相关法律规定的，则应参照通用国际商业惯例和（或）行业惯例。用户与本平台一致同意，若因履行本协议而产生的争议，双方本着友好协商解决，协商不成的，双方同意提交本平台运营公司注册地有管辖权的人民法院诉讼解决。
<br />本平台再次重申，在注册成为本平台用户之前，请仔细、详尽的阅读本协议，对协议中加粗标黑的部分，因关系用户自身的责任与义务，请着重阅读。一经注册，用户应严格遵守该协议的所有条款，本平台有权根据经营的需要随时修改本协议，对于修改后的协议，用户可随时查阅。若用户对修订后的协议有异议，请及时联系本平台或停止使用本平台服务。
							
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="../module/bottom.jsp" flush="true" />
			
		
	</body>
	<script>

	$(document).ready(function() {
		$("td").attr("style", "border-top: solid #333333 1px;");
	});
</script>
</html>