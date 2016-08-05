<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<%--<head>
    <title>TeaList</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>--%>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
<h3>TeaList</h3>
<jsp:include page="fragments/filterSection.jsp"/>
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
                <td><a href="teas/update?id=${tea.id}">Update</a></td>
                <td><a href="teas/delete?id=${tea.id}">Delete</a></td>
            </tr>
        </p>
    </c:forEach>
</table>
<hr>
<a href="teas/create">Add Tea</a>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
