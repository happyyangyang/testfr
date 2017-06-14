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

</head>
<body>
	<div class="ch-container">
		<div>
			<ul class="breadcrumb">
				<li><a href="#">接口管理</a></li>
				<li><a href="#">Http接口</a></li>
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
							<div class="pull-right">
								<div class="input-append">
									项目：<input type="text" placeholder="项目名" id="name"/>
									接口名称：<input type="text" placeholder="接口名称" id="logDesc"/>
									
									<a class="btn btn-primary" href="#" onclick="searchFun()">
										<i class="glyphicon glyphicon-search"></i>查询
									</a>
								</div>
							</div>
							<a class="btn btn-danger" href="${appctx}/jsp/new.jsp">
								<i class="glyphicon glyphicon-plus"></i>新增
							</a>
							<a class="btn btn-danger" href="#" onclick="batchDelFun()" data-toggle="modal" data-target="#myModal">
								<i class="glyphicon glyphicon-trash "></i>批量删除
							</a>
						</div>
						<div style="height: 15px;"></div>
					
						<div class="row-fluid">
							<table id="dataTables" 
								class="table table-striped table-bordered table-hover table-condensed datatable">
								<thead>
									<tr>
										<th>
											<input type="checkbox" onclick="selectAll(this)" name="cb-check-all">
										</th>
										<th>id</th>
										<th>项目</th>
										<th>接口名称</th>
										<th>URL</th>
										<th>请求方法</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
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
				<div class="modal-footer">
					<a href="#" class="btn btn-default" id="closeBtn" data-dismiss="modal">Close</a>
					<a href="#" onclick="" class="btn btn-primary" id="saveBtn">Save</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
