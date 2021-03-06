<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript">
 
  //刷新表格
 function doQuery(params){
    $('#tb_departments').bootstrapTable('refresh');    //刷新表格
}
 function settime1(){
		if (countdown == 5) { 
			alert("批量执行文件完成，"+"点击确定后跳转回到列表");
			location.href="${appctx}/jsp/testcaseexecute.jsp";
		    return;
	     } 
	}
 
 //批量执行
 
 //单条执行
 function execute(rowid){
	 location.href='${appctx}/testCase/exctSingle.do?id='+rowid;
 }

 $(function () {
	 
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	
	 //批量成功可执行文件
	
	 //批量执行
	 $("#btn_executebatch").click(function(){
		 var a= $('#tb_departments').bootstrapTable('getSelections'); 
		 var arr = new Array();
		 if(a.length==0){
		 	alert("请选择一行");
		 }else {
		 	for(var i=0;i<a.length;i++){
		 		arr[i] = a[i].id
		 		//alert(arr[i]);
		 	}
		 	executebatch(arr);
		 }
		 
	} )
	//批量删除
	function executebatch(arr){
		 $.ajax({
	        url: '${appctx}/testCase/exct.do',
	        async: true,
	        contentType:"application/json",
	        type: 'POST',
	        data: JSON.stringify(arr),
	        success: function(data , textStatus){
	        	
		          if(data.result=="success"){
		        	  countdown = 5;
			          settime1();
		          }else if(data.result=="error"){
		        	  alert("执行失败");
		          }
	        },
	        error: function(jqXHR , textStatus , errorThrown){
	        	alert("系统异常，请联系管理员！");
	        }
	      });
	}
	
	$("#btn_execute").click(function(){
			execase();
		})
	 
	});



 
 
 var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	 $('#tb_departments').bootstrapTable({
	 url: '${appctx}/testCase/getcaselist.do', //请求后台的URL（*）
	 method: 'post', //请求方式（*）
	 toolbar: '#toolbar', //工具按钮用哪个容器
	 striped: true, //是否显示行间隔色
	 cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	 pagination: true, //是否显示分页（*）
	 sortable: false, //是否启用排序
	 sortOrder: "asc", //排序方式
	 queryParams: oTableInit.queryParams,//传递参数（*）
	 sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
	 pageNumber:1, //初始化加载第一页，默认第一页
	 pageSize: 10, //每页的记录行数（*）
	 pageList: [10,50,100,200,300,400,500], //可供选择的每页的行数（*）
	 //search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	 strictSearch: true,
	 showColumns: true, //是否显示所有的列
	 showRefresh: true, //是否显示刷新按钮
	 minimumCountColumns: 2, //最少允许的列数
	 clickToSelect: true, //是否启用点击选中行
	 height: 550, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	 uniqueId: "ID", //每一行的唯一标识，一般为主键列
	 showToggle:true, //是否显示详细视图和列表视图的切换按钮
	 cardView: false, //是否显示详细视图
	 detailView: false, //是否显示父子表
	 columns: [
	           {
	 checkbox: true
	 },
	 {  
    //field: 'Number',//可不加  
    title: '序号',//标题  可不加  
    formatter: function (value, row, index) {  
        return index+1;  }  
	},{
	 field: 'casename',
	 title: '用例名'
	 },{
	 field: 'name',
	 title: '接口名'
	},{
	 field: 'url',
	 title: '请求URL',
	 width: 80,
	 }, {
	 field: 'method',
	 title: '请求方法'
	 },{
	 field: 'projectname',
	 title: '项目名称'
	 }, {
	 field: 'scenario',
	 title: '场景'
	 }, {
	 field: 'parmater',
	 title: '参数',
	 width: 10
	 },{
	 field: 'expectkey1',
     title: '断言字段一'
	 },{
	 field: 'expectvalue1',
     title: '断言字段一的值'
	 },{
	 field: 'expectkey2',
     title: '断言字段二'
	 },{
	 field: 'expectvalue2',
     title: '断言字段二的值'
	 },{
		 field: 'operate',
		 title: '操作',
		 align: 'center',
		 formatter: function(value,row,index){
			 var e = '<a href="#" id="upate" mce_href="#" onclick="execute(\''+row.id + '\')">执行</a> ';
			 return e;}
			 }]
	 });
	 };
	 
	//得到查询的参数
	 oTableInit.queryParams = function (params) {
	 var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	 limit: params.limit, //页面大小
	 offset: params.offset/params.limit+1, //页码
	 projectname: $("#txt_search_projectname").val(),
	 casename: $("#txt_search_name").val()
	 };
	 return temp;
	 };
	 return oTableInit;
	};
	

		 
 </script>
</head>
<body>
	<div class="panel-body" style="padding-bottom:0px;">
	 <div class="panel panel-default">
	 <div class="panel-heading">查询条件</div>
	 <div class="panel-body">
	 <form id="formSearch" class="form-horizontal">
	 <div class="form-group" style="margin-top:15px">
	 <label class="control-label col-sm-1" for="txt_search_departmentname">项目名称</label>
	 <div class="col-sm-3">
	 <input type="text" class="form-control" id="txt_search_projectname">
	 </div>
	 <label class="control-label col-sm-1" for="txt_search_statu">用例名</label>
	 <div class="col-sm-3">
	 <input type="text" class="form-control" id=txt_search_name>
	 </div>
	 <div class="col-sm-4" style="text-align:left;">
	 <button type="button" style="margin-left:50px" id="btn_query" onclick="doQuery();" class="btn btn-primary">查询</button>
	 </div>
	 </div>
	 </form>
	 </div>
	 </div> 
	 
	 <div id="toolbar" class="btn-group">
	 <button id="btn_executebatch" type="button" class="btn btn-default">
	 <span class="glyphicon glyphicon-play-circle" ></span>批量执行
	 </button>
	 </div>
	 <table id="tb_departments"></table>
	 </div>
</body>
</html>