<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages.app"/>
<html>
<jsp:include page="fragments/headTag.jsp"/>
  <body>
  <jsp:include page="fragments/bodyHeader.jsp"/>

    <h2>Социальная сеть для чаеманов Tea Friends</h2>
    <hr/>
    <form method="post" action="user">
      Login as: <select name="userId">
      <option value="1" selected>User</option>
      <option value="2">Admin</option>
    </select>
      <button type="submit">Выбрать</button>
    </form>
    <h3><a href="tea">TeaList</a> </h3>
    <h3><a href="user">UserList</a> </h3>

  <jsp:include page="fragments/footer.jsp"/>
  </body>
</html>
