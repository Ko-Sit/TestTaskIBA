<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select file</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<form name="form" method="POST" action="controller" enctype="multipart/form-data">
    <p>
        <label for="file-upload" class="custom-file-upload">Выбрать файл</label>
        <input id="file-upload" type="file" name="file" accept=".xml">
        <button type="submit" name="command" value="sendxml">Обработать</button>
    </p>
</form>
</body>
</html>