<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="appctx" value="${pageContext.request.contextPath}"></c:set>

<!-- Bootstrap -->
<link rel="stylesheet" href="${ctx}/css/bootstrap.css" media="screen">
<link rel="stylesheet" href="${ctx}/css/bootstrap-table.css" media="screen">

<script src="${ctx}/js/bootstrap-table.js"></script>
<script src="${ctx}/js/bootstrap.js"></script>
<script src="${ctx}/js/bootstrap-table-zh-CN.min.js"></script>
<!-- JQuery -->
<script src="${ctx}/js/jquery.min.js"></script>