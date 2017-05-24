<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form action="user/SetUsers.do" method="post">
用户名：<input type="text" name="userset[0].username">
密码：<input type="password" name="userset[0].pwd">
用户名：<input type="text" name="userset[1].username">
密码：<input type="password" name="userset[1].pwd">
用户名：<input type="text" name="userset[3].username">
密码：<input type="password" name="userset[3].pwd">

<input type="submit" value="提交">
</form>
</body>
</html>
