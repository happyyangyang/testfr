<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>自动化测试系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">
    <script type="text/javascript">
    	$(function(){
    		//document.onkeydown=keyDownSearch;
    		$("input").keypress(function(e){
        		// 兼容FF和IE和Opera    
        		var theEvent = e || window.event;    
                var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
     		   	if (code == 13) {
     		   		loginFunction();
     		   	}
     		 });
    	});
    	
        /* function keyDownSearch(e) {    
             var theEvent = e || window.event;    
             var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
             if (code == 13) {    
                 loginFunction()
             }    
        }   */

    	function loginFunction(){
    		if($("#username").val()==null||(!$("#username").val().length>0)){
    			$("#alertContent").html("请输入用户名");
    			$("#alertId").show();
    		}else if($("#password").val()==null||(!$("#password").val().length>0)){
    			$("#alertId").show();
    			$("#alertContent").html("请输入密码");
    		}
    	
    	}
    </script>
</head>
<body>
<div class="ch-container">
    <div class="row">
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>自动化测试系统</h2>
        </div>
    </div>
    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-danger" id="alertId" style="display: none;">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong id="alertContent"></strong>
			</div>
            <form class="form-horizontal" action="user/sucesspojo.do" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" class="form-control" name="pwd" placeholder="Password">
                    </div>
                    <div class="clearfix"></div><br>
                    <div class="row">
	                    <div class="col-md-6" style="text-align: left;padding-left:25px;"><a href="${appctx}/jsp/registerPage.jsp">注册</a></div>
	                    <div class="col-md-6" style="text-align: right;padding-right:25px;"><a href="${appctx}/jsp/getPswPage.jsp">找回密码</a></div>
                    </div>
                    
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                    	<button type="submit" class="btn btn-primary" id="loginId" onclick="loginFunction()">登录</button>
                    </p>
                    
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->

</body>
</html>
