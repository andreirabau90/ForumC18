<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 10.10.2018
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<html>
<head>

    <title>Chat</title>
</head>
<body>
<h3>Ваш ник - ${nick}</h3>

Сообщения:
<table>
    <c:forEach var="message" items="${mes}">
        <tr>
            <td> <c:out value="${message.author}"/> </td>
            <td> <c:out value="${message.text}"/> </td>
            <td> <c:out value="${message.dateForum}"/> </td>
        </tr>
    </c:forEach>
</table>


<form action="forum" method="post">
    <input type="text" name="messageParam">
    <input type="hidden" value="${nick}" name="nickname">
    <input type="submit" value="send">
</form>

</body>
</html>
