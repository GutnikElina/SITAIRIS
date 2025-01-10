<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Удаление животного</title>
</head>
<body>
<h1>Удаление животного</h1>
<form action="deleteAnimal" method="post">
    <label for="id">Введите id животного для удаления:</label>
    <input type="text" id="id" name="id" required> <br>
    <input type="submit" value="Удалить животное">
</form> <br>
<a href="index.jsp">Home page</a>
</body>
</html>
