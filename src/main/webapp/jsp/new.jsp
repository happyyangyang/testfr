<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Free HTML5 Bootstrap Admin Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">
    <script type="text/javascript">
    var countdown = 0;
    var phoneRegex = /^[1][0-9]{10}$/;
   	
    </script>
</head>
<body>
<div class="ch-container">
    
    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-danger" id="alertId" style="display: none;">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong id="alertContent"></strong>
			</div>
            <form class="form-horizontal" action="${appctx}/interface/new.do" method="post">
                <fieldset>
                    <div class="input-group input-group-lg"  >
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                       	 <input type="text" class="form-control" id="password" name="projectname" placeholder="请输入项目名">
                    </div>
                    <div class="input-group input-group-lg" ><br>
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                       	 <input type="text" class="form-control" id="password" name="name" placeholder="请输入接口名">
                    </div>
                    <div class="clearfix"></div><br>
                     <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                       	 <input type="text" class="form-control" id="url" name="url" placeholder="请输入URL">
                    </div>
                    <div class="clearfix"></div><br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                       	 <input type="text" class="form-control" id="method" name="method" placeholder="请输入请求方法">
                    </div>
                    <div class="clearfix"></div>
                    <p class="center col-md-5">
                    	<button type="submit" class="btn btn-primary">提交</button>
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
