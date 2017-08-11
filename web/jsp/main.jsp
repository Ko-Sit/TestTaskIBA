<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Schema</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<table id="customers">
    <tr>
        <th>ID</th>
        <th>Age</th>
        <th>Name</th>
    </tr>

    <jsp:useBean id="customers" scope="request" type="java.util.List"/>
    <c:forEach var="customer" items="${customers}">
        <tr id="${customer.id}" onclick="load(${customer.id})">
            <td>${customer.id}</td>
            <td>${customer.age}</td>
            <td>${customer.name}</td>
        </tr>
    </c:forEach>
</table>
<form name="Form" method="POST" action="controller">
    <a href="controller?command=gotoadd">Добавить</a>
    <a id="deletelink" href="controller?command=delete&id=">Удалить :</a>
    <button type="submit" name="command" value="save">Сохранить</button>
</form>
</body>
</html>
