<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>
    <h2><a href="index.jsp">Home</a></h2>
    <h3>TeaEdit</h3>
    <jsp:useBean id="tea" type="org.glasma.teafriend.model.Tea" scope="request"/>
    <form method="post" action="${pageContext.request.contextPath}teas/save">
    <input type="hidden" name="id" value="${tea.id}">
        <dl>
            <dt>Name</dt>
            <dd><input type="text" value="${tea.name}" name="name" required="required"></dd>
        </dl>
        <dl>
            <dt>Category</dt>
            <dd>
                <select name="category" value="${tea.category}" required="required">
                    <jsp:include page="fragments/teaCategoryOptions.jsp"/>
                </select>
            </dd>
        </dl>
        <dl>
            <dt>Country</dt>
            <dd>
                <select value="${tea.country}" name="country" required="required">
                    <jsp:include page="fragments/teaCountryOptions.jsp"/>
                </select>
            </dd>
        </dl>
        <dl>
            <dt>Description</dt>
            <dd>
                <textarea cols="30" rows="10" type="text" value="${tea.description}" name="description" required="required">${tea.description}</textarea>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
