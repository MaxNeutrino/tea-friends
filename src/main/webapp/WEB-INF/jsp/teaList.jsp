<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TeaList</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<h2><a href="index.jsp">Home</a></h2>
<h3>TeaList</h3>
<form method="post" action="tea?action=filter">
    <section>
        From category: <select name="category">
        <option value="Все">Все</option>
        <option value="Светлый улун">Светлый улун</option>
        <option value="Темный улун">Темный улун</option>
        <option value="Зеленый">Зеленый</option>
        <option value="Белый">Белый</option>
        <option value="Желтый">Желтый</option>
        <option value="Красный">Красный</option>
        <option value="Черный">Черный</option>
        <option value="Травяной">Травяной</option>
    </select>
    </section>

    <section>
        From category: <select name="country">
        <option value="Все">Все</option>
        <option value="Китай">Китай</option>
        <option value="Индия">Индия</option>
        <option value="Цейлон">Цейлон</option>
        <option value="Грузия">Грузия</option>
        <option value="Турция">Турция</option>
        </select>
    </section>
    <button type="submit">Фильтр</button>
</form>
<hr>
<table border="1" cellpadding="8" cellspacing="0">
    <c:forEach items="${teaList}" var="tea">
        <jsp:useBean id="tea" scope="page" type="org.glasma.teafriend.model.Tea"/>
        <p>
            <tr>
                <td>${tea.name}</td>
                <td>${tea.category}</td>
                <td>${tea.country}</td>
                <td>${tea.description}</td>
                <td><a href="tea?action=update&id=${tea.id}">Update</a></td>
                <td><a href="tea?action=delete&id=${tea.id}">Delete</a></td>
            </tr>
        </p>
    </c:forEach>
</table>
<hr>
<a href="tea?action=create">Add Tea</a>
</body>
</html>
