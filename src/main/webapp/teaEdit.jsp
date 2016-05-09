<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TeaEdit</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>TeaEdit</h3>
    <jsp:useBean id="tea" type="org.glasma.teafriend.model.Tea" scope="request"/>
    <form method="post" action="tea">
    <input type="hidden" name="id" value="${tea.id}">
        <dl>
            <dt>Name</dt>
            <dd><input type="text" value="${tea.name}" name="name" required="required"></dd>
        </dl>
        <dl>
            <dt>Category</dt>
            <dd><input type="text" value="${tea.category}" name="category" required="required"></dd>
        </dl>
        <dl>
            <dt>Country</dt>
            <dd><input type="text" value="${tea.country}" name="country" required="required"></dd>
        </dl>
        <dl>
            <dt>Description</dt>
            <dd><input type="text" value="${tea.description}" name="description" required="required"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
</body>
</html>
