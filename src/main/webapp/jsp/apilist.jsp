<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<!--<script src="jquery.min.js"></script>-->
<!-- bootstrap组件引用 
 <script src="bootstrap.js"></script>
 <link href="bootstrap.css" rel="stylesheet" />-->
<!-- bootstrap table组件以及中文包的引用 
<script src="bootstrap-table.js"></script>
 <link href="bootstrap-table.css" rel="stylesheet" />
 <script src="bootstrap-table-zh-CN.min.js"></script>-->
 <script type="text/javascript">
 
 
 //update 
 
 function edit(rowid){
	 location.href='${appctx}/interface/updateapi.do?id='+rowid;
 }
 //delete
 function del(rowid){
	 $.ajax({
	        url: '${appctx}/interface/deleteapi.do',
	        async: true,
	        contentType:"application/json",
	        type: 'POST',
	        data: JSON.stringify({id:rowid}),
	        success: function(data , textStatus){
	        	
		          if(data.result=="success"){
		        	  countdown = 5;
			          settime1();
		          }else if(data.result=="error"){
		        	  alert("删除失败");
		          }
	        },
	        error: function(jqXHR , textStatus , errorThrown){
	        	alert("系统异常，请联系管理员！");
	        }
	      });
 }
 //批量删除
 function delbatch(arr){
 	
 		 $.ajax({
	        url: '${appctx}/interface/deletebatchapi.do',
	        async: true,
	        contentType:"application/json",
	        type: 'POST',
	        data: JSON.stringify(arr),
	        success: function(data , textStatus){
	        	
		          if(data.result=="success"){
		        	  countdown = 5;
			          settime1();
		          }else if(data.result=="error"){
		        	  alert("删除失败");
		          }
	        },
	        error: function(jqXHR , textStatus , errorThrown){
	        	alert("系统异常，请联系管理员！");
	        }
	      });
 }
 
 function settime1(){
		if (countdown == 5) { 
			alert("操作成功，"+"点击确定后跳转到接口列表页面");
			location.href="${appctx}/jsp/apilist.jsp";
 		    return;
 	     } 
	}
 //查询
 function searchfun(){
		
	 //
	 $('#tb_departments').bootstrapTable({
		 url: '${appctx}/interface/search.do', //请求后台的URL（*）
		 method: 'post', //请求方式（*）
		 toolbar: '#toolbar', //工具按钮用哪个容器
		 striped: true, //是否显示行间隔色
		 cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		 pagination: true, //是否显示分页（*）
		 sortable: false, //是否启用排序
		 sortOrder: "asc", //排序方式
		 queryParams: Params,//传递参数（*）
		 sidePagination: "client", //分页方式：client客户端分页，server服务端分页（*）
		 pageNumber:1, //初始化加载第一页，默认第一页
		 pageSize: 10, //每页的记录行数（*）
		 pageList: [10,25,50,100], //可供选择的每页的行数（*）
		 search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
		} , {
		field: 'projectname',
		title: '项目名'
		},{
		 field: 'name',
		 title: '接口名'
		 }, {
		 field: 'url',
		 title: '接口地址'
		 }, {
		 field: 'method',
		 title: '请求方法'
		 },{
		 field: 'operate',
		 title: '操作',
		 align: 'center',
		 formatter: function(value,row,index){
			 var e = '<a href="#" id="upate" mce_href="#" onclick="edit(\''+row.id + '\')">编辑</a> ';
			 var d = '<a href="#" id="delete" mce_href="#" onclick="del(\''+ row.id +'\')">删除</a> ';
			 return e+d;}
			 }]
		 });
 	
 }	
 
 

 //初始化
 $(function () {
	 
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	
	 //新增操作
	 $("#btn_add").click(function(){
		 location.href='${appctx}/jsp/newapi.jsp';
			});
	 
		//修改操作

	 $("#btn_edit").click(function(){
		 var a= $('#tb_departments').bootstrapTable('getSelections'); 
		 if(a.length==1){
		 	edit(a[0].id);
		 }else {
		 	alert("只能选择一行");
		 }
		 
	} )
	 //工具栏的删除
	 $("#btn_delete").click(function(){
		 var a= $('#tb_departments').bootstrapTable('getSelections'); 
		 var arr = new Array();
		 if(a.length==0){
		 	alert("请选择一行");
		 }else {
		 	for(var i=0;i<a.length;i++){
		 		arr[i] = a[i].id
		 		//alert(arr[i]);
		 	}
		 	delbatch(arr);
		 }
		 
	} )

 })
 
 
 var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	 $('#tb_departments').bootstrapTable({
	 url: '${appctx}/interface/getlist.do', //请求后台的URL（*）
	 method: 'post', //请求方式（*）
	 toolbar: '#toolbar', //工具按钮用哪个容器
	 striped: true, //是否显示行间隔色
	 cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	 pagination: true, //是否显示分页（*）
	 sortable: false, //是否启用排序
	 sortOrder: "asc", //排序方式
	 queryParams: oTableInit.queryParams,//传递参数（*）
	 sidePagination: "client", //分页方式：client客户端分页，server服务端分页（*）
	 pageNumber:1, //初始化加载第一页，默认第一页
	 pageSize: 10, //每页的记录行数（*）
	 pageList: [10,25,50,100], //可供选择的每页的行数（*）
	 search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
	} , {
	field: 'projectname',
	title: '项目名'
	},{
	 field: 'name',
	 title: '接口名'
	 }, {
	 field: 'url',
	 title: '接口地址'
	 }, {
	 field: 'method',
	 title: '请求方法'
	 },{
	 field: 'operate',
	 title: '操作',
	 align: 'center',
	 formatter: function(value,row,index){
		 var e = '<a href="#" id="upate" mce_href="#" onclick="edit(\''+row.id + '\')">编辑</a> ';
		 var d = '<a href="#" id="delete" mce_href="#" onclick="del(\''+ row.id +'\')">删除</a> ';
		 return e+d;}
		 }]
	 });
	 };
	 
	//得到查询的参数
	 oTableInit.queryParams = function (params) {
	 var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	 limit: params.limit, //页面大小
	 offset: params.offset, //页码
	 departmentname: $("#txt_search_departmentname").val(),
	 statu: $("#txt_search_statu").val()
	 };
	 return temp;
	 };
	 return oTableInit;
	};
	//得到查询的参数
	 function Params(pageReqeust) {  
    //console.log("-----params-----"); 
    pageReqeust.projectname = $("#txt_search_projectname").val();
    pageReqeust.name = $("#txt_search_name").val();
    return pageReqeust;  
}
 	
	
		 
 </script>
</head>
<body>
	<div class="panel-body" style="padding-bottom:0px;">
	 <div class="panel panel-default">
	 <div class="panel-heading">查询条件</div>
	 <div class="panel-body">
	 <form id="formSearch" class="form-horizontal">
	 <div class="form-group" style="margin-top:15px">
	 <label class="control-label col-sm-1" for="txt_search_departmentname" >项目名称  </label>
	 <div class="col-sm-3">
	 <input type="text" class="form-control" id="txt_search_projectname">
	 </div>
	 <label class="control-label col-sm-1" for="txt_search_statu">接口名称</label>
	 <div class="col-sm-3">
	 <input type="text" class="form-control" id="txt_search_name">
	 </div>
	 <div class="col-sm-4" style="text-align:left;">
	 <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary" onclick="searchfun()">查询</button>
	 </div>
	 </div>
	 </form>
	 </div>
	 </div> 
	 
	 <div id="toolbar" class="btn-group">
	 <button id="btn_add" type="button" class="btn btn-default">
	 <span class="glyphicon glyphicon-plus" ></span>新增
	 </button>
	 <button id="btn_edit" type="button" class="btn btn-default">
	 <span class="glyphicon glyphicon-pencil" ></span>修改
	 </button>
	 <button id="btn_delete" type="button" class="btn btn-default" >
	 <span class="glyphicon glyphicon-remove" ></span>删除
	 </button>
	 </div>
	 <table id="tb_departments"></table>
	 </div>
</body>
</html>