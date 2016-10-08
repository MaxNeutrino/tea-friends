<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

    <jsp:include page="fragments/headerLoggedUser.jsp"/>
    <%--FOR GUESTS--%>
    <%--<jsp:include page="fragments/headerGuest.jsp"/>--%>

    <main class="mdl-layout__content">
        <div class="page-content">
            <div class="mdl-grid grid-adds">
                <%--<jsp:include page="fragments/filterSection.jsp"/>--%>

                <c:forEach items="${teaList}" var="tea">
                    <jsp:useBean id="tea" scope="page" type="org.glasma.teafriend.model.Tea"/>

                    <%--TEA CARDS--%>
                    <div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--4-col-phone mdl-card mdl-shadow--2dp">
                        <div class="mdl-card__media">
                            <img class="card-demo" src="../resources/uploads/tea/${tea.id}.jpg">
                        </div>
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">${tea.name}</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                                ${tea.description}
                            <hr/>
                                ${tea.category}
                            <hr/>
                                ${tea.country}
                        </div>
                        <div class="mdl-card__menu">
                            <button id="${tea.name}-${tea.id}"
                                    class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-button--colored mdl-js-ripple-effect">
                                <i class="material-icons">add</i>
                            </button>
                            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                                for="${tea.name}-${tea.id}">
                                <li class="mdl-menu__item drunk">
                                    <i class="material-icons">done</i> Add to drunk
                                </li>
                                <li class="mdl-menu__item wish">
                                    <i class="material-icons">playlist_add</i> Add to wish
                                </li>
                                <li disabled class="mdl-menu__item delete" is="disabled">
                                    <i class="material-icons">delete</i> Delete from list
                                </li>
                                <li class="mdl-menu__item">
                                    <i class="material-icons">share</i> Share
                                </li>
                            </ul>

                        </div>
                    </div>
                </c:forEach>
                <div id="toast-show" class="mdl-js-snackbar mdl-snackbar">
                    <div class="mdl-snackbar__text">lololo</div>
                    <button class="mdl-snackbar__action" type="button"></button>
                </div>
            </div>

            <%@ include file="fragments/filterHelper.jsp" %>

            <!-- FILTER CHIPS -->
            <div class="chips-wrapper  mdl-layout--large-screen-only">
                <% if (!category.equals("All")) { %>
                <span class="mdl-chip chips-adds mdl-shadow--2dp">
                <span class="mdl-chip__text"><%=category%></span>
            </span>
                <% } %>
                <% if (!country.equals("All")) { %>
                <span class="mdl-chip chips-adds mdl-shadow--2dp">
                <span class="mdl-chip__text"><%=country%></span>
            </span>
                <% } %>
            </div>

            <div id="fab-adds" class="mdl-speed-dial mdl-speed-dial--bottom-fixed">
                <%--<div class="mdl-speed-dial__options">
                    <div class="mdl-speed-dial__option">
                        &lt;%&ndash;<p class="mdl-speed-dial__tooltip">&ndash;%&gt;
                        <jsp:include page="fragments/filterSection.jsp"/>
                        &lt;%&ndash;</p>&ndash;%&gt;
                    </div>
                </div>--%>
                <%--<form method="get" action="/teas/create">--%>
                    <button class="mdl-speed-dial__main-fab mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
                        <i class="material-icons mdl-speed-dial_main-fab-icon">filter_list</i>
                    </button>
                <%--</form>--%>
            </div>
            <jsp:include page="fragments/footer.jsp"/>
        </div>
    </main>
</div>

</body>
</html>