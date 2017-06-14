<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Free HTML5 Bootstrap Admin Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">
<style type="text/css">
.dropdown-menu li {list-style-type:none;}
</style>
<script type="text/javascript">
	var ws = null;  
	var url = null;  
	var urlPath = "/testmybatis/websocket;jsessionid=<%=request.getSession(true).getId()%>";
	$(function() {
		iFrameWidth();
		
		$(".close").click(function(){
			$("#myHomeModal").hide();
		});
		
	});
	
	function iFrameHeight() {
		var ifm = document.getElementById("iframepage");
		var subWeb = document.frames ? document.frames["iframepage"].document
				: ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			//ifm.width = subWeb.body.scrollWidth;
			//ifm.width = document.getElementById("content").scrollWidth;
			ifm.height = subWeb.body.scrollHeight+45;
		}
	}
	function iFrameWidth() {
		var ifm = document.getElementById("iframepage");
		if (ifm != null) {
			ifm.width = document.getElementById("content").scrollWidth;
			ifm.width = ifm.width - 30;
		}
	}

	
	function initSidebar(){
		$('a.ajax-link').click(function (e) {
	        if (!$('#is-ajax').prop('checked') || $(this).parent().hasClass('active')) return;
	        e.preventDefault();
	        $('.sidebar-nav').removeClass('active');
	        $('#loading').remove();
	        $('#content').fadeOut().parent().append('<div id="loading" class="center">Loading...<div class="center"></div></div>');
	        var $clink = $(this);
	        History.pushState(null, null, $clink.attr('href'));
	        $('ul.main-menu li.active').removeClass('active');
	        $clink.parent('li').addClass('active');
	    });

	    $('.accordion > a').click(function (e) {
	        e.preventDefault();
	        var $ul = $(this).siblings('ul');
	        var $li = $(this).parent();
	        if ($ul.is(':visible')) $li.removeClass('active');
	        else                    $li.addClass('active');
	        $ul.slideToggle();
	    });
	}
	function linkedHerf(url){
		main_target.location.href=url
		$("#myHomeModal").hide();
	}
</script>
</head>
<body>
	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-inner">
			<a class="navbar-brand" href="#"> <img alt="Charisma Logo"
				src="${ctx}/img/logo20.png" class="hidden-xs" /> <span>Charisma</span></a>
			<div class="btn-group pull-right">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i><span
						class="hidden-sm hidden-xs">${user.username}</span> <span
						class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a target='main_target' href="${appctx}/jsp/homePage.jsp">首页</a></li>
					<li class="divider"></li>
					<li><a href="${appctx}/user/exit.do">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">
			<div id="leftMenu" class="col-sm-2 col-lg-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<div class="nav-sm nav nav-stacked"></div>
						<ul class="nav nav-pills nav-stacked main-menu" id="menuList">
							
							
							
							<li class="accordion"><a href="#"><i class="glyphicon glyphicon-plus"></i><span>接口管理</span></a>
								<ul class="nav nav-pills nav-stacked">
									<li><a class="ajax-link"  target='main_target' href="${appctx}/jsp/apilist.jsp"><i class="glyphicon glyphicon-align-justify"></i><span>Http接口</span></a></li>
									<li><a class="ajax-link"  target='main_target' href="${appctx}/jsp/testcaselist.jsp"><i class="glyphicon glyphicon-calendar"></i><span>测试用例</span></a></li>
									<li><a class="ajax-link"  target='main_target' href="${appctx}/jsp/newWebservice.jsp"><i class="glyphicon glyphicon-th"></i><span>Webservice</span></a></li>
								</ul>
							</li>
							<li class="accordion"><a href="#"><i class="glyphicon glyphicon-plus"></i><span>权限管理</span></a>
								<ul class="nav nav-pills nav-stacked">
									<li><a class="ajax-link"  target='main_target' href="${appctx}/userController/userIndex"><i class="glyphicon glyphicon-align-justify"></i><span>用户管理</span></a></li>
									<li><a class="ajax-link"  target='main_target' href="${appctx}/roleController/roleIndex"><i class="glyphicon glyphicon-calendar"></i><span>角色管理</span></a></li>
									<li><a class="ajax-link"  target='main_target' href="${appctx}/resourceController/resourceIndex"><i class="glyphicon glyphicon-th"></i><span>资源管理</span></a></li>
								</ul>
							</li>
							<li class="accordion"><a href="#"><i class="glyphicon glyphicon-plus"></i><span>系统管理</span></a>
								<ul class="nav nav-pills nav-stacked">
									<li><a class="ajax-link"  target='main_target' href="${appctx}/paramController/paramIndex2"><i class="glyphicon glyphicon-align-justify"></i><span>日志统计</span></a></li>
									<li><a class="ajax-link"  target='main_target' href="${appctx}/visitorController/visitorIndex"><i class="glyphicon glyphicon-calendar"></i><span>访客管理</span></a></li>
									<li><a class="ajax-link"  target='main_target' href="${appctx}/paramController/paramIndex"><i class="glyphicon glyphicon-th"></i><span>系统参数</span></a></li>
								</ul>
							</li> 
						</ul>
					</div>
				</div>
			</div>
			<div id="content" class="col-lg-10 col-sm-10">
				<iframe src="${appctx}/jsp/homePage.jsp" name='main_target'
					id="iframepage" frameborder="0" scrolling="no" marginheight="0"
					marginwidth="0" onLoad="iFrameHeight()"></iframe>
			</div>
			<hr>
			<div id="myHomeModal" style="display: none;">
				<div class="modal-dialog" style="width:350px;height:175px;position: absolute;right:3px;bottom:3px;">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close">&times;</button>
							<font color="red" id="messageHead">消息提醒</font>
						</div>
						<div class="modal-body" id="messageBody" style="height:150px;">
							<!-- <a href="javascript:void(0)" onclick="linkedHerf()">请重新设置密码</a> -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer style="text-align: center">
       		<p style="text-align:center;">Copyright@2016-2020 @author lizhen</p>
   		</footer>
	</div>
</body>
</html>
