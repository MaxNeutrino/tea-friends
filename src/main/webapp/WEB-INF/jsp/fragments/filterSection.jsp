<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<dialog class="mdl-dialog" id="filter">
    <form method="post" action="${pageContext.request.contextPath}teas/filter">

        <h3 class="mdl-dialog__title mdl-color-text--grey-800">Category</h3>
        <div class="mdl-dialog__content">
            <p>
                <jsp:include page="teaCategoryOptions.jsp"/>
            </p>
        </div>

        <h3 class="mdl-dialog__title mdl-color-text--grey-800">Country</h3>
        <div class="mdl-dialog__content">
            <jsp:include page="teaCountryOptions.jsp"/>
        </div>

        <div class="mdl-dialog__actions centered-text">
            <button type="button"
                    class="mdl-button  mdl-js-button mdl-button--raised mdl-js-ripple-effect close">
                Close
            </button>
            <button type="submit"
                    class="mdl-button  mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                Filter
            </button>
        </div>
    </form>
</dialog>
