<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>

</head>
<body>      
  <SCRIPT language="JavaScript"> 
    alert("登录超时，请重新登录。"); 
    setTimeout(function () { 
      window.top.location.href="${appctx}/login.jsp"; 
    },2000); 
  </script> 
  </body>
</html>
