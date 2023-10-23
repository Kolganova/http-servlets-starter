<%--
  Created by IntelliJ IDEA.
  User: kiskadi
  Date: 2023-10-19
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
    <span>Content. Русский</span>
    <p>Size: ${requestScope.flights.size()}</p>
    <p>Id: ${requestScope.flights.get(0).id}</p>
    <p>Id2: ${requestScope.flights[1].id}</p>
    <p>Map Id 2: ${sessionScope.flightsMap[1]}</p>
    <p>JSESSION id: ${cookie["JSESSIONID"].value}, unique identifier</p>
    <p>Header: ${header["Cookie"]}</p>
    <p>Param id: ${param.id}</p>
    <p>Param test: ${param.test}</p>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
