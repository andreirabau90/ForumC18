<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 10.10.2018
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<script src="http://code.jquery.com/jquery-2.0.3.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<html>

<head>
    <title>Chat</title>

</head>
<body>
<h3>Ваш ник - ${nick}</h3>
<h3>Ваша группа - ${myGroup}</h3>
Сообщения:


<table id="chat">
    <c:forEach var="message" items="${mes}">
        <c:set var="com" value="${myGroup}"></c:set>
        <c:if test="${message.group==com}">
            <tr id='2'>
                    <td><c:out value="${message.author}"/></td>
                    <td><c:out value="${message.text}"/></td>
                    <td><c:out value="${message.dateForum}"/></td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<script>
    var timerId = setTimeout(function tick() {
        $('#chat_id').submit();
        timerId = setTimeout(tick, 5000);
    }, 5000);

</script>
<form id="chat_id" action="forum" method="post">
    <input id="messageparam" type="text" name="messageParam">
    <input id="nickname" type="hidden" value="${nick}" name="nickname">
    <input id="thisgroup" type="hidden" value="${myGroup}" name="thisGroup">
    <input id="1" type="submit" value="send">
</form>

<%--<script>--%>
    <%--$('#1').click(function () {--%>
        <%--$.ajax({--%>
            <%--type: "POST",--%>
            <%--url: "/forum",--%>
            <%--data: {messageParam:$('#memessageparam'),nickname:$('#nickname'),thisGroup:$('#thisgroup')},--%>
            <%--success: function(dat)      {--%>
                <%--alert('1');--%>
                <%--alert('2');--%>
            <%--for(i=0;i< dat.length;i++){--%>
                <%--alert('3');--%>
            <%--&lt;%&ndash;result = '<td><c:out value="${message.author}"/></td>' +&ndash;%&gt;--%>
                <%--&lt;%&ndash;'<td><c:out value="${message.text}"/></td>' +&ndash;%&gt;--%>
                <%--&lt;%&ndash;' <td><c:out value="${message.dateForum}"/></td>';&ndash;%&gt;--%>
                <%--result=message[i];--%>
            <%--$('#2').html($('#2')).html() + result;--%>

            <%--};--%>
        <%--}--%>
            <%--});--%>
    <%--});--%>

<%--</script>--%>




<form action="forum" method="post">
    <h3>название всех групп</h3>
    <table>
        <c:forEach var="gr" items="${groups} ">
            <tr>
                <td><c:out value="${gr}"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="text" id="groupname" name="thisGroup" placeholder="введите имя группы">
    <input type="hidden" value="${nick}" name="nickname">
    <input type="submit" value="send">
</form>
</body>
</html>
