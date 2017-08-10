<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.textarea{


    width:
			880px;


    min-height:
				20px;


    max-height:
				300px;


    _height:
				120px;


    margin-left:
				auto;


    margin-right:
				auto;


    padding:
				3px;


    outline:
				0;


    border:
				1px
				solid
				#a0b3d6;


    font-size:
				12px;


    line-height:
			24px;


    padding:
			2px;


    word-wrap:
			break-word;


    overflow-x:
			hidden;


    overflow-y:
			auto;


 


    border-color:
					rgba(82,
					168,
					236,
					0.8);


    box-shadow:
					inset
					0
					1px
					3px
					rgba(0,
					0,
					0,
					0.1),
					0
					0
					8px
					rgba(82,
					168,
					236,
					0.6);


}
	
</style>
<script type="text/javascript">
function cancelFun(){
	window.location.href="${appctx}/jsp/history.jsp";
}

</script>
</head>
<body style="height: 387px; ">
	<div class="ch-container">
		<div>
			<ul class="breadcrumb">
				<li><a href="#">报告管理</a></li>
				<li><a href="#">详细信息</a></li>
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
							
								<div class="input-append">
							详情信息：<div class="textarea" contenteditable="true">${reporter.text}</div>	
								</div>
								
								<p class="center col-md-5">
                    				<button type="button" class="btn btn-primary" onclick="cancelFun()">关闭</button>
                    			</p>
								
							
						</div>
						<div style="height: 15px;"></div>
					
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<hr>

</body>
</html>