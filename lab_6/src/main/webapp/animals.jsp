<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Животные</title>
</head>
<body>
<h1>Список животных</h1>
<c:choose>
    <c:when test="${not empty animals}">
        <ul>
            <c:forEach var="animal" items="${animals}">
                <li>${animal}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>Животные не найдены</p>
    </c:otherwise>
</c:choose>
<a href="index.jsp">На главную</a>
</body>
</html>
