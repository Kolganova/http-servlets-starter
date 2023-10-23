<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: kiskadi
  Date: 2023-10-19
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty requestScope.tickets}">
    <h1>Купленные билеты:</h1>
    <ul>
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket.seatNo)}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>

<%!
    public void jspInit() {
        System.out.println("Hello from override jspInit");
    }
%>