<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <jsp:include page="fragments/headerMainPageLoggedUser.jsp"/>
    <%--FOR GUESTS--%>
    <%--<jsp:include page="fragments/headerGuest.jsp"/>--%>
    <main class="mdl-layout__content">
        <div class="page-content">
            <section>
                <form method="post" action="users">
                    <fmt:message key="app.login"/>: <select name="userId">
                    <option value="100000" selected>User</option>
                    <option value="100001">Admin</option>
                </select>
                    <button type="submit">Sing in</button>
                </form>
            </section>

            <jsp:include page="fragments/footer.jsp"/>
        </div>
    </main>
</div>
</body>
</html>
