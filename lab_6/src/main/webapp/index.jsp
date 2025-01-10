<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <script>
        function showAlert(message) {
            alert(message);
        }
        window.onload = function() {
            var successMessage = "<%= session.getAttribute("successMessage") != null ? session.getAttribute("successMessage") : "" %>";
            var errorMessage = "<%= session.getAttribute("errorMessage") != null ? session.getAttribute("errorMessage") : "" %>";

            if (successMessage) {
                showAlert(successMessage);
                <%
                    session.removeAttribute("successMessage");
                %>
            }

            if (errorMessage) {
                showAlert(errorMessage);
                <%
                    session.removeAttribute("errorMessage");
                %>
            }
        };
    </script>
</head>
<body>
<h1>Меню</h1>
<form action="readAnimals" method="get">
    <input type="submit" value="Показать животных">
</form> <br>

<form action="addAnimal.jsp" method="get">
    <input type="submit" value="Добавить животное">
</form> <br>

<form action="deleteAnimal.jsp" method="get">
    <input type="submit" value="Удалить животное">
</form> <br>

</body>
</html>
