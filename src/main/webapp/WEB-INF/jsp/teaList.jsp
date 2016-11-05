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

            <div class="mdl-grid grid-adds" id="datacards">
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
                                for="${tea.name}-${tea.id}"
                                idtea="${tea.id}" id="query">
                                <li class="mdl-menu__item drunk">
                                    <i class="material-icons">done</i> Add to drunk
                                </li>
                                <li class="mdl-menu__item wish">
                                    <i class="material-icons">playlist_add</i> Add to wish
                                </li>
                                <li class="mdl-menu__item  delete">
                                    <i class="material-icons">delete</i> Delete from list
                                </li>
                                    <%--ADMIN ONLY--%>
                                <li class="mdl-menu__item" onclick="showEditDialog('${tea.name}', '${tea.category}', '${tea.country}', '${tea.description}', ${tea.id})">
                                    <i class="material-icons edit">create</i> Edit
                                </li>
                                    <%--ADMIN ONLY--%>
                                <li class="mdl-menu__item" id="removefrom" onclick="deleteTea(${tea.id})">
                                    <i class="material-icons">delete</i> Remove
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

            <%--ADMIN FAB--%>
            <div class="mdl-speed-dial speed-dial--header-edge mdl-layout--large-screen-only" id="fab-adds-admin">
                <div class="mdl-speed-dial__options">
                    <div class="mdl-speed-dial__option">
                        <p class="mdl-speed-dial__tooltip">Add tea</p>
                        <button class="mdl-button show-modal-edit mdl-js-button mdl-button--fab mdl-button--mini-fab"
                                id="add">
                            <i class="material-icons">add</i>
                        </button>
                    </div>
                </div>
                <button class="mdl-speed-dial__main-fab mdl-speed-dial__main-fab--spin mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
                    <i class="material-icons mdl-speed-dial_main-fab-icon mdl-speed-dial_main-fab-icon--primary">add</i>
                    <i class="material-icons mdl-speed-dial_main-fab-icon mdl-speed-dial_main-fab-icon--secondary">create</i>
                </button>
            </div>

            <div class="mdl-speed-dial mdl-speed-dial--bottom-fixed" id="fab-adds-bottom">
                <button class="mdl-speed-dial__main-fab  show-modal-filter mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
                    <i class="material-icons mdl-speed-dial_main-fab-icon">filter_list</i>
                </button>
            </div>
            <jsp:include page="fragments/footer.jsp"/>
        </div>
    </main>
</div>

<jsp:include page="fragments/filterSection.jsp"/>
<jsp:include page="fragments/teaEdit.jsp"/>

<script>

    var dialogFilter = document.getElementById('filter');
    var showModalButtonFilter = document.querySelector('.show-modal-filter');

    var dialogEdit = document.getElementById('edit-dialog');
    var showModalButtonEdit = document.querySelector('.show-modal-edit');

    if (!dialogFilter.showModal) {
        dialogPolyfill.registerDialog(dialogFilter);
    }
    showModalButtonFilter.addEventListener('click', function () {
        dialogFilter.showModal();
    });
    dialogFilter.querySelector('.close').addEventListener('click', function () {
        dialogFilter.close();
    });

    if (!dialogEdit.showModal) {
        dialogPolyfill.registerDialog(dialogEdit);
    }
    showModalButtonEdit.addEventListener('click', function () {
        document.getElementById("title-edit-dialog").innerHTML = "Add tea";
        $("#edit-dialog-button").text("Add");
        $("#edit-tea-name").val('');
        /*$("#category option:selected").prop('selected', false);
        $("#country option:selected").prop('selected', false);*/
        $("#edit-tea-description").val('');
        $("#edit-tea-id").val(0);

        dialogEdit.showModal();
    });
    dialogEdit.querySelector('.close').addEventListener('click', function () {
        dialogEdit.close();
    });

    function showEditDialog(teaname, teacategory, teacountry, teadescription, teaid) {
        $("#title-edit-dialog").text("Edit tea");
        $("#edit-dialog-button").text("Edit");

        $("#edit-tea-name").val(teaname);

        $("#category option:selected").prop('selected', false);
        $("#" + teacategory).prop('selected', true);

        $("#country option:selected").prop('selected', false);
        $("#" + teacountry).prop('selected', true);

        $("#edit-tea-description").val(teadescription);
        $("#edit-tea-id").val(teaid);

        dialogEdit.showModal();
    }

</script>

</body>
</html>