<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<div class="mdl-grid filter-fixed">--%>

    <div class="mdl-card<%-- mdl-cell--8-col mdl-cell--8-col-tablet mdl-cell--4-col-phone--%> mdl-shadow--2dp">
        <form method="post" action="${pageContext.request.contextPath}teas/filter">
            <div class="mdl-card__supporting-text">

                <div class="mdl-card__title">
                    <h3 class="mdl-card__title-text">Category</h3>
                </div>
                <div class="mdl-card__supporting-text left-text">
                    <jsp:include page="teaCategoryOptions.jsp"/>
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <div class="mdl-card__title">
                        <h3 class="mdl-card__title-text">Country</h3>
                    </div>
                    <div class="mdl-card__supporting-text left-text">
                        <jsp:include page="teaCountryOptions.jsp"/>
                    </div>
                </div>
                <div class="mdl-card__actions mdl-card--border centered-text">
                    <button type="submit"
                            class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                        Filter
                    </button>
                </div>
            </div>
        </form>
    </div>
<%--</div>--%>

