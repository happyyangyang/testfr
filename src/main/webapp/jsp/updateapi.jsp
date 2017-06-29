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
<script type="text/javascript">

	//页面初始化时候把要修改的api的内容展示在页面上
	$(function() {
		$.ajax({
			
		})
		
	});
	
	function cancelFun(){
		window.location.href="${appctx}/jsp/apilist.jsp";
	}
	
	
	
  	function registerFunction(){
   		if($("#projectname").val()==null||(!$("#projectname").val().length>0)){
   			alert("请输入项目名");
   		}else if($("#name").val()==null||(!$("#name").val().length>0)){
   			alert("请输入接口名");
   		}else if($("#url").val()==null||(!$("#url").val().length>0)){
   			alert("请输入接口地址");
   		}else if($("#method").val()==null||(!$("#method").val().length>0)){
   			alert("请输入请求方法");
   		}else{
   			$.ajax({
   		        url: '${appctx}/interface/updatejinterface.do',
   		        async: true,
   		        contentType:"application/json",
   		        type: 'POST',
   		        data: JSON.stringify({id:$("#id").val(),projectname:$("#projectname").val(),name:$("#name").val(),url:$("#url").val(),method:$("#method").val()}),
   		        success: function(data , textStatus){
   		        	
   			          if(data.result=="success"){
   			        	countdown = 5;
			            settime1();
   			          }else if(data.result=="error"){
   			        	  alert("保存失败");
   			          }
   		        },
   		        error: function(jqXHR , textStatus , errorThrown){
   		        	$("#alertId").show();
   		        	$("#alertContent").html("系统异常，请联系管理员！");
   		        }
   		            });
    		}
    	}
   function settime1(){
		if (countdown == 5) { 
			alert("新增成功，"+"点击确定后跳转到接口列表页面");
			location.href="${appctx}/jsp/apilist.jsp";
 		    return;
 	     } 
	}
</script>
</head>
<body>
	<div class="ch-container">
		<div>
			<ul class="breadcrumb">
				<li><a href="#">接口管理</a></li>
				<li><a href="#">修改接口</a></li>
			</ul>
		</div>

		<div class="row">
			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							</h2>
					</div>
					 
					<div class="box-content">
						<div class="btn-toolbar">
							<div class="pull-left"><br><br><br>
								<div class="input-append">
								项目：<input type="text" placeholder="项目名" id="projectname" name="projectname" value="${apinfor.projectname}" style="width: 270px; height: 43px"/>
								接口名称：<input type="text" placeholder="接口名称" id="name" name="name" value="${apinfor.name}" style="width: 235px;height: 43px "/>	
								</div><br><br><br>
								<div class="input-append">
								接口地址：<input type="text" placeholder="接口地址" id="url"  name="url" value="${apinfor.url}"style="width: 568px; height: 43px"/>
								请求方法：<input type="text" placeholder="请求方法" id="method"  name="apinfor.method" value="${apinfor.method}" style="height: 43px; "/>	
								</div><br><br><br>
								<input  type="hidden"  id="id" value="${apinfor.id}">
								<p class="center col-md-5">
                    				<button type="button" class="btn btn-primary" onclick="registerFunction()">提交</button>
                    				<button type="button" class="btn btn-primary" onclick="cancelFun()">取消</button>
                    			</p>
								
							</div>
						</div>
						<div style="height: 15px;"></div>
					
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3>Settings</h3>
				</div>
				<div class="modal-body">
					
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
