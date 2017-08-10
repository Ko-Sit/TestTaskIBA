<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Schema</title>
</head>
<body>
<table>
    <tr>
        <th></th>
        <th>ID</th>
        <th>Age</th>
        <th>Name</th>
    </tr>

    <jsp:useBean id="customers" scope="request" type="java.util.List"/>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.age}</td>
            <td>${customer.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
