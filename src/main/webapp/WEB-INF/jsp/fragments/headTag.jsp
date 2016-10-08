<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

    <title><fmt:message key="app.title"/></title>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="resources/css/style.css">

    <!-- Material Design fonts -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="resources/plugins/mdl-speed-dial/mdl-speed-dial.css">
    <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.teal-amber.min.css" />


    <link rel="stylesheet" type="text/css" href="resources/plugins/dialog-polyfill/dialog-polyfill.css"/>
    <script src="resources/plugins/dialog-polyfill/dialog-polyfill.js"></script>
</head>
