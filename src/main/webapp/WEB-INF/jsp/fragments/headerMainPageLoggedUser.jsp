<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title mdl-typography--text-uppercase "><a
                id="logo" href="${pageContext.request.contextPath}" class="mdl-color-text--white">Tea friends</a></span>
        <!-- Add spacer, to align navigation to the right -->
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation. We hide it in small screens. -->
        <nav class="mdl-navigation mdl-layout--large-screen-only">
            <a class="mdl-navigation__link" href="">People</a>
            <a class="mdl-navigation__link" href="">All Tea</a>
            <a class="mdl-navigation__link" href="">Forum</a>
            <a class="mdl-navigation__link" href="">Blog</a>
        </nav>
    </div>
</header>
<div class="mdl-layout__drawer">
    <span class="mdl-layout-title">LoggedUserName</span>
    <nav class="mdl-navigation left-bar-adds">
        <div class="mdl-layout--small-screen-only">
            <a class="mdl-navigation__link" href="users">People</a>
            <a class="mdl-navigation__link" href="teas">All Tea</a>
        </div>
        <a class="mdl-navigation__link" href="">Profile</a>
        <a class="mdl-navigation__link" href="">Drunk Teas</a>
        <a class="mdl-navigation__link" href="">Wish Teas</a>
        <a class="mdl-navigation__link" href="">Friends</a>
        <a class="mdl-navigation__link" href="">Messages</a>
        <a class="mdl-navigation__link" href="">My Topics</a>
        <div class="mdl-layout--small-screen-only ">
            <a class="mdl-navigation__link" href="">Forum</a>
            <a class="mdl-navigation__link" href="">Blog</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}">News</a>
        </div>
    </nav>
</div>