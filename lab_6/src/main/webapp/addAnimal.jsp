<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Добавление животного</title>
</head>
<body>
<h1>Добавьте новое животное</h1>
<form action="addAnimal" method="post">
    <label for="name">Название:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="careCost">Цена:</label>
    <input type="number" step="10" id="careCost" name="careCost" required><br><br>

    <input type="submit" value="Добавить животное">
</form>
<br>
<a href="index.jsp">Home page</a>
</body>
</html>
