<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header class="mdl-layout__header mdl-layout__header--waterfall ">
    <!-- Top row, always visible -->
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title mdl-typography--text-uppercase "><a
                id="logo" href="${pageContext.request.contextPath}" class="mdl-color-text--white">Tea friends</a></span>
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation -->
        <nav class="mdl-navigation  mdl-layout--large-screen-only ">
            <a id="sing-up-dialog" class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link-first" href="">Sing up</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link-first"
               href="">Sing in</a>
        </nav>
    </div>
    <!-- Bottom row, not visible on scroll -->
    <div class="mdl-layout__header-row  mdl-layout--large-screen-only">
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation -->
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link" href="teas">All
                Tea</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link"
               href="">Forum</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link"
               href="">Blog</a>
        </nav>
    </div>
</header>
<div class="mdl-layout__drawer  mdl-layout--small-screen-only">
    <nav class="mdl-navigation left-bar-adds">
        <a class="mdl-navigation__link" href="">Sing up</a>
        <a class="mdl-navigation__link" href="">Sing in</a>
        <hr/>
        <a class="mdl-navigation__link" href="${pageContext.request.contextPath}">Main</a>
        <a class="mdl-navigation__link" href="teas">All Tea</a>
        <a class="mdl-navigation__link" href="">Forum</a>
        <a class="mdl-navigation__link" href="">Blog</a>

    </nav>
</div>
