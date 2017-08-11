<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Add row</title>
</head>
<body>
<form name="Form" method="POST" action="controller">
    <div class="field">
        <label>ID</label>
        <input type="number" name="id" value="" required/>
    </div>
    <div class="field">
        <label>Age</label>
        <input type="number" name="age" value="" required/>
    </div>
    <div class="field">
        <label>Name</label>
        <input type="text" name="name" value="" maxlength="100" required/>
    </div>

    <button type="submit" name="command" value="addrow">Сохранить</button>
</form>

</body>
</html>
