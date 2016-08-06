<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form method="post" action="${pageContext.request.contextPath}teas/filter">
    <section>
        <fmt:message key="form.text.category"/>: <select name="category">
        <option value="Все"><fmt:message key="choose.all"/> </option>
        <jsp:include page="teaCategoryOptions.jsp"/>
    </select>
    </section>

    <section>
        <fmt:message key="form.text.country"/>: <select name="country">
        <option value="Все"><fmt:message key="choose.all"/></option>
        <jsp:include page="teaCountryOptions.jsp"/>
    </select>
    </section>
    <button type="submit"><fmt:message key="common.filter"/></button>
</form>

