<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="filterHelper.jsp"%>

<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="country-1">
    <input type="radio" id="country-1" class="mdl-radio__button" name="country" value="All" <%=isChecked(country, "All")%>>
    <span class="mdl-radio__label">All</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="country-2">
    <input type="radio" id="country-2" class="mdl-radio__button" name="country" value="China" <%=isChecked(country, "China")%>>
    <span class="mdl-radio__label">China</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="country-3">
    <input type="radio" id="country-3" class="mdl-radio__button" name="country" value="Taiwan" <%=isChecked(country, "Taiwan")%>>
    <span class="mdl-radio__label">Taiwan</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="country-4">
    <input type="radio" id="country-4" class="mdl-radio__button" name="country" value="India" <%=isChecked(country, "India")%>>
    <span class="mdl-radio__label">India</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="country-5">
    <input type="radio" id="country-5" class="mdl-radio__button" name="country" value="Ceylon" <%=isChecked(country, "Ceylon")%>>
    <span class="mdl-radio__label">Ceylon</span>
</label>
