<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form method="post" action="${pageContext.request.contextPath}teas/filter">
    <section>
        <fmt:message key="form.text.category"/>: <select name="category">
        <option value="Все"><fmt:message key="choose.all"/> </option>
        <option value="Светлый улун"><fmt:message key="tea.light.oolong"/> </option>
        <option value="Темный улун"><fmt:message key="tea.dark.oolong"/></option>
        <option value="Зеленый"><fmt:message key="tea.green"/></option>
        <option value="Белый"><fmt:message key="tea.white"/></option>
        <option value="Желтый"><fmt:message key="tea.yellow"/></option>
        <option value="Красный"><fmt:message key="tea.red"/></option>
        <option value="Черный"><fmt:message key="tea.black"/></option>
    </select>
    </section>

    <section>
        <fmt:message key="form.text.country"/>: <select name="country">
        <option value="Все"><fmt:message key="choose.all"/></option>
        <option value="Китай"><fmt:message key="country.china"/></option>
        <option value="Индия"><fmt:message key="country.india"/></option>
        <option value="Цейлон"><fmt:message key="country.ceylon"/></option>
        <option value="Грузия"><fmt:message key="country.georgia"/></option>
        <option value="Турция"><fmt:message key="country.turkey"/></option>
    </select>
    </section>
    <button type="submit"><fmt:message key="common.filter"/></button>
</form>

