<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2><a href="${pageContext.request.contextPath}/">Home</a></h2>
<jsp:useBean id="tea" type="org.glasma.teafriend.model.Tea" scope="request"/>
<h2>${tea.name}</h2>
<h3>${tea.category}</h3>
<h4>${tea.country}</h4>
<h4>${tea.rate}</h4>
<p>${tea.description}</p>
</body>
</html>
