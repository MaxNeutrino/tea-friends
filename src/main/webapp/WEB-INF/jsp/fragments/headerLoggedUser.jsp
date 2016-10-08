<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header class="mdl-layout__header mdl-layout__header--waterfall ">
    <!-- Top row, always visible -->
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title  mdl-layout--large-screen-only mdl-typography--text-uppercase "><a
                id="logo" href="${pageContext.request.contextPath}" class="mdl-color-text--white">Tea space</a></span>
        <div class="mdl-layout-spacer"></div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">


            <label class="mdl-button mdl-js-button mdl-button--icon"
                   for="waterfall-exp">
                <i class="material-icons">search</i>
            </label>

            <div class="mdl-textfield__expandable-holder">
                <form method="get" action="${pageContext.request.contextPath}teas/search">
                    <input class="mdl-textfield__input" type="text" name="name"
                           id="waterfall-exp">
                </form>
            </div>
        </div>
    </div>
    <!-- Bottom row, not visible on scroll -->
    <div class="mdl-layout__header-row  mdl-layout--large-screen-only">
        <div class="mdl-layout-spacer"></div>
        <!-- Navigation -->
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link"
               href="users">People</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link" href="teas">All
                Tea</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link"
               href="">Forum</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link"
               href="">Blog</a>
            <a class="mdl-navigation__link mdl-typography--text-uppercase main-navigation__link"
               href="${pageContext.request.contextPath}">News</a>
        </nav>
    </div>
</header>
<div class="mdl-layout__drawer">

    <div class="drawer-header  mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <img src="../resources/uploads/avatar/avatar.jpg" class="avatar">
        <span class="mdl-layout-title">LoggedUserName</span>
    </div>
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

