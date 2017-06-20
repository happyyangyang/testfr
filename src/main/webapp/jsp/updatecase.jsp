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
$(function(){
	//加载接口信息
	Apiinfors();
})
	//加载接口信息
	function Apiinfors(){
	$.ajax({
		type : "post",
		url : "${appctx}/interface/getlist.do",
		dataType : "json",
		data : {
			//merserialno : $("#merserialno").val()
		},
		success : function(data) {
			var html="";
			html+="<div data-model='bbb' class='tride-type'>";
			html+="<select class='business-area chosen-select chosen-select-spaceal' id='apiname' name='apiname'>";
			html+="<option value='${testcase.expect}'>""</option>";
			for (var i = 0; i < data.length; i++) {
				html+="<option value='" + data[i].id + "'>"+ data[i].name  + "</option>";
			}
			
			$("#receiveBusiDivision").html(html);
			$('.chosen-select').chosen();
			selectUpdate();
			//ae.bindEle();
		}
	});
	
	
}
	
function selectUpdate() {
	$('select').trigger('chosen:updated');
}
	
	function cancelFun(){
		window.location.href="${appctx}/jsp/testcaselist.jsp";
	}
	
	
	
  	function registerFunction(){
   		if($("#casename").val()==null||(!$("#casename").val().length>0)){
   			alert("请输入用例名");
   		}else if($("#scenario").val()==null||(!$("#scenario").val().length>0)){
   			alert("请输入场景");
   		}else if($("#parmater").val()==null||(!$("#parmater").val().length>0)){
   			alert("请输入参数");
   		}else if($("#expect").val()==null||(!$("#expect").val().length>0)){
   			alert("请输入期望结果");
   		}else{
   			$.ajax({
   		        url: '${appctx}/testCase/newtestcase.do',
   		        async: true,
   		        contentType:"application/json",
   		        type: 'POST',
   		        data: JSON.stringify({apiid:$("#apiname").val(),casename:$("#casename").val(),scenario:$("#scenario").val(),parmater:$("#parmater").val(),expect:$("#expect").val()}),
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
			location.href="${appctx}/jsp/testcaselist.jsp";
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
				<li><a href="#">修改测试用例</a></li>
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
								用例名：<input type="text" placeholder="用例名" id="casename" name="casename" value="${testcase.casename}" style="width: 270px; height: 43px"/>
								场景：<input type="text" placeholder="场景" id="scenario" name="scenario" value="${testcase.scenario}" style="width: 235px;height: 43px "/>	
								</div><br><br><br>
								<div class="input-append">
								参数：<textarea rows="10" cols="60" id="parmater" >${testcase.parmater}</textarea> 
								期望结果：<input type="text" placeholder="期望结果" id="expect" value="${testcase.expect}"  name="expect" style="height: 43px; "/>	
								</div><br><br><br>
								
								接口名：<div data-container="bbb" id="receiveBusiDivision"  style="width: 905px; "></div><br><br><br>
								
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
