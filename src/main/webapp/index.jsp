<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 10.10.2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NickName</title>
</head>
<body>
<form action="/forum1" >
    <input type="text" placeholder="nick here please" name="nickname">
    <input type="password" placeholder="password" name="pass">
    <input type="hidden" value="allChat" name="thisGroup">
    <input type="submit" value="send" >
</form>
<form action="Register.jsp">
    <input type="submit" value="register" >
</form>

<h1>${error}</h1>
</body>
</html>
