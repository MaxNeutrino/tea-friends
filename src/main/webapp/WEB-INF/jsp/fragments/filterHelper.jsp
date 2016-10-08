<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String category = null;
    String country = null;

    try {
        category = request.getParameter("category");
        country = request.getParameter("country");
    } catch (Exception e) {
        category = "All";
        country = "All";
    }

    if (category == null)
        category = "All";

    if (country == null)
        country = "All";
%>


<%!
    String isChecked(String requestParam, String value) {
        return requestParam.equals(value) ? "checked" : "";
    }
%>