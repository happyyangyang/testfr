<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form action="user/MapUsers.do" method="post">
用户名：<input type="text" name="userMap('x').username">
密码：<input type="password" name="userMap('x').pwd">
用户名：<input type="text" name="userMap('y').username">
密码：<input type="password" name="userMap('y').pwd">
用户名：<input type="text" name="userMap('z').username">
密码：<input type="password" name="userMap('z').pwd">

<input type="submit" value="提交">
</form>
</body>
</html>
