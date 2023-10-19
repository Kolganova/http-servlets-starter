<%@ page import="com.kolganova.http.service.TicketService" %>
<%@ page import="com.kolganova.http.dto.TicketDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kiskadi
  Date: 2023-10-19
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    public void jspInit() {
        System.out.println("Hello from override jspInit");
    }
%>
    <h1>Купленные билеты:</h1>
        <ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }
    %>
        </ul>
</body>
</html>
