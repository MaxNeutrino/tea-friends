<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="filterHelper.jsp"%>

<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-1">
    <input type="radio" id="category-1" class="mdl-radio__button" name="category" value="All" <%=isChecked(category, "All")%>>
    <span class="mdl-radio__label">All</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-2">
    <input type="radio" id="category-2" class="mdl-radio__button" name="category" value="Oolong" <%=isChecked(category, "Oolong")%>>
    <span class="mdl-radio__label">Oolong</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-3">
    <input type="radio" id="category-3" class="mdl-radio__button" name="category" value="Green" <%=isChecked(category, "Green")%>>
    <span class="mdl-radio__label">Green</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-4">
    <input type="radio" id="category-4" class="mdl-radio__button" name="category" value="White" <%=isChecked(category, "White")%>>
    <span class="mdl-radio__label">White</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-5">
    <input type="radio" id="category-5" class="mdl-radio__button" name="category" value="Yellow" <%=isChecked(category, "Yellow")%>>
    <span class="mdl-radio__label">Yellow</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-6">
    <input type="radio" id="category-6" class="mdl-radio__button" name="category" value="Red" <%=isChecked(category, "Red")%>>
    <span class="mdl-radio__label">Red</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-7">
    <input type="radio" id="category-7" class="mdl-radio__button" name="category" value="Black" <%=isChecked(category, "Black")%>>
    <span class="mdl-radio__label">Black</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-8">
    <input type="radio" id="category-8" class="mdl-radio__button" name="category" value="Sheng puer" <%=isChecked(category, "Sheng puer")%>>
    <span class="mdl-radio__label">Sheng puer</span>
</label>
<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="category-9">
    <input type="radio" id="category-9" class="mdl-radio__button" name="category" value="Shu puer" <%=isChecked(category, "Shue puer")%>>
    <span class="mdl-radio__label">Shu puer</span>
</label>