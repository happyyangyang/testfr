<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(function(){
    var contacts = [];
    contacts[0] = 'xiaoming';
    contacts[1] = 'daming';
    $.ajax({
        type:'GET',
        url:'demo/sendContacts',
        data:contacts,
        success:function(result){
            alert(result);
        }
    });
})
</script>
	
</head>
<body>
<form action="user/userdog.do" method="post">
用户名：<input type="text" name="username">
密码：<input type="password" name="pwd">
养狗狗的数量：<input type="text" name="dog.count">
<input type="submit" value="提交">
</form>
</body>
</html>
