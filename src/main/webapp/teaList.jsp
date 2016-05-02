<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>TeaList</title>
    </head>
    <body>
        <h2><a href="index.html">Home</a></h2>
        тут начинается код <br/>
        <c:forEach items="${teaList}" var="tea">
            <jsp:useBean id="tea" scope="page" type="org.glasma.teafriend.model.Tea"/>
            <p>
                ${tea.name}<br/>
                ${tea.category}<br/>
                ${tea.country}<br/>
                ${tea.description}<br/>
            </p>
        </c:forEach>
    а тут заканчивается<br/>
    </body>
</html>
