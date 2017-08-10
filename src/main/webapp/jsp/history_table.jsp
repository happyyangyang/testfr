<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>

 <script type="text/javascript">
 
  function settime1(){
		if (countdown == 5) { 
			alert("操作成功，"+"点击确定后跳转到报告列表页面");
			location.href="${appctx}/jsp/history.jsp";
		    return;
	     } 
	}
 
 Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

 	function detail(rowid){
 		 location.href='${appctx}/report/detail.do?id='+rowid;
 	}
 	// //批量删除
 	function delbatch(arr){
 	
 		 $.ajax({
	        url: '${appctx}/report/deletebatchReporter.do',
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
 //初始化
 $(function () {
	 
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	 
	 //点击前台删除按钮
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
	  
     $('#datetimepicker2').datepicker({
            language: "zh-CN",
            autoclose: true,//选中之后自动隐藏日期选择框
            clearBtn: true,//清除按钮
            todayBtn: true,//今日按钮
            format: "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
        });

 })
 
 
 var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	 $('#tb_departments').bootstrapTable({
	 url: '${appctx}/report/getlist.do', //请求后台的URL（*）
	 method: 'post', //请求方式（*）
	 toolbar: '#toolbar', //工具按钮用哪个容器
	 showExport: true,
     exportDataType: "basic",
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
	 //search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	 //strictSearch: true,
	 showColumns: true, //是否显示所有的列
	// showRefresh: true, //是否显示刷新按钮
	 minimumCountColumns: 2, //最少允许的列数
	 clickToSelect: true, //是否启用点击选中行
	 height: 550, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	 uniqueId: "ID", //每一行的唯一标识，一般为主键列
	 //showToggle:true, //是否显示详细视图和列表视图的切换按钮
	// cardView: false, //是否显示详细视图
	// detailView: false, //是否显示父子表
	 
	 columns: [
	           {
	 checkbox: true
	 },
	 {  
    //field: 'Number',//可不加  
    title: '序号',//标题  可不加  
    formatter: function (value, row, index) {  
        return index+1;  }  
	} ,{
	 field: 'excdate',
	 title: '执行日期',
	  formatter:function (value,row,index){
                return new Date(value).Format('yyyy-MM-dd hh:mm:ss');}
	 },{
	 field: 'totaltime',
	 title: '执行总耗时（毫秒）'
	 }, {
	 field: 'totalcount',
	 title: '总用例数'
	 },{
	 field: 'successcount',
	 title: '通过数'
	 },{
	 field: 'failurescount',
	 title: '失败数（断言失败）'
	 },{
	 field: 'errorcount',
	 title: '报错数'
	 },{
	 field: 'skipscount',
	 title: '未执数'
	 },{
	 field: 'successpercent',
	 title: '通过率',
	  formatter: function(value,row,index){
		 
		 return value+"%";}
	 },
	 {
	 field: 'operate',
	 title: '操作',
	 align: 'center',
	 formatter: function(value,row,index){
		 var d = '<a href="#" id="detail" mce_href="#" onclick="detail(\''+ row.id +'\')">失败日志</a> ';
		 return d;}
		 }]
	 });
	 };
	 
	//得到查询的参数
	 oTableInit.queryParams = function (params) {
	 var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	 limit: params.limit, //页面大小
	 offset: params.offset, //页码
	 date: $("#exctdate").val()
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
	    <div class="form-group">  
       		<label class="col-sm-2 control-label" for = "name">执行时间:</label> 
            <div class="col-sm-3">
            	<div class='input-group date' id='datetimepicker2'> 
	               	<input type='text' class="form-control" id="exctdate" />  
	                <span class="input-group-addon">  
	                    <span class="glyphicon glyphicon-calendar"></span>  
	                </span>  
            	</div> 	
            </div>
            <button type="submit" style="margin-left:50px" id="btn_query" class="btn btn-primary" >查询</button>
            <dir>   
        </div>  
    </div>  
	 </form>
	 </div>
	 </div> 
	 
	 <div id="toolbar" class="btn-group">
	 <button id="btn_delete" type="button" class="btn btn-default" >
	 <span class="glyphicon glyphicon-remove" ></span>删除
	 </button>
	 </div>
	 <table id="tb_departments"></table>
	 </div>
</body>
</html>