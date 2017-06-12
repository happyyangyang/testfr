<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
 $(function () {
	 
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	
	 //新增操作
	 $("#btn_add").click(function(){
		 location.href='${appctx}/jsp/new.jsp';
			});
	 
		//修改操作

	 $("#btn_edit").click(function(){
		 location.href='${appctx}/jsp/new.jsp';
			});
	 //
	 $("#btn_edit").click(function(){
		 location.href='${appctx}/jsp/updat.jsp';
			});
	 //查询btn_query
	 $("#btn_query").click(function(){
		 location.href='${appctx}/jsp/new.jsp';
			});
	 
	});



 
 
 var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	 $('#tb_departments').bootstrapTable({
	 url: '${appctx}/testCase/gettestcaselist.do', //请求后台的URL（*）
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
	 pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
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
	 field: 'casename',
	 title: '用例名'
	 },{
		 field: 'apiid',
		 title: '接口id'
		 },{
	 field: 'scenario',
	 title: '场景'
	 }, {
	 field: 'parmater',
	 title: '参数'
	 },{
	 field: 'expect',
     title: '期望结果'
	 },]
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
	
	var ButtonInit = function () {
		 var oInit = new Object();
		 var postdata = {};
		 
		 oInit.Init = function () {
		 //初始化页面上面的按钮事件
		 };
		 
		 return oInit;
		};
 	
		wf.resource_delete=function(){
	        var selectIndex = $('input[name="btSelectItem"]:checked ').val();
	        deleteItem($table, "${ctx}/resource/wfResource!deleteResourceClassType.action", selectIndex, true);
	    } 
		function deleteItem($table, requestUrl, selectIndex, reLoad){
		    var selRow = $table.bootstrapTable('getSelections');
		    var idField = $table.bootstrapTable("getOptions").idField;
		    var className = $table.bootstrapTable("getOptions").className;
		    if(className!=null && className.length>0){
		        className +="."
		    }else{
		        className = "";
		    }
		    var datas = className+idField+"="+eval('selRow[0].'+idField)+"&currenttime="+new Date().getTime();

		    if(selRow!=null){       
		        qiao.bs.confirm({'title':'提示', 'msg':'此操作不可逆，确认删除第'+selectIndex+'行吗？'}, function(){
		            $.ajax({
		               type: "POST",
		               cache:false,
		               async : true,
		               dataType : "json",
		               url:  requestUrl,
		               data: datas,
		               success: function(data){
		                       alert(data.mess);
		                       if ( data.state == 200 ){
		                           $table.bootstrapTable('hideRow', {index:selectIndex});
		                          if(reLoad){
		                              $table.bootstrapTable('refresh');
		                          }
		                       }
		               }
		            });
		        })      
		    }else{
		        alert('请选取要删除的数据行！');
		    }
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
	 <label class="control-label col-sm-1" for="txt_search_departmentname">项目名称</label>
	 <div class="col-sm-3">
	 <input type="text" class="form-control" id="txt_search_projectname">
	 </div>
	 <label class="control-label col-sm-1" for="txt_search_statu">接口名称</label>
	 <div class="col-sm-3">
	 <input type="text" class="form-control" id="txt_search_name">
	 </div>
	 <div class="col-sm-4" style="text-align:left;">
	 <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
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
	 <button id="btn_delete" type="button" class="btn btn-default" onclick="wf.resource_delete();">
	 <span class="glyphicon glyphicon-remove" ></span>删除
	 </button>
	 </div>
	 <table id="tb_departments"></table>
	 </div>
</body>
</html>