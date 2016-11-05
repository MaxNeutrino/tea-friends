<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<dialog class="mdl-dialog" id="edit-dialog">
    <form method="POST" action="${pageContext.request.contextPath}ajax/admin/teas/save" id="editTeaForm">

        <h4 class="mdl-color-text--grey-800" id="title-edit-dialog">Create tea</h4>

        <div class="mdl-dialog__content">
            <input type="text" hidden="hidden" id="edit-tea-id" name="id" value="">

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="edit-tea-name" name="name" value="fuck">
                <label class="mdl-textfield__label" for="edit-tea-name">Name</label>
            </div>
            <select id="category" name="category">
                <option id="Oolong" selected value="Oolong">Oolong</option>
                <option id="Green" value="Green">Green</option>
                <option id="White" value="White">White</option>
                <option id="Yellow" value="Yellow">Yellow</option>
                <option id="Red" value="Red">Red</option>
                <option id="Black" value="Black">Black</option>
                <option id="Sheng puer" value="Sheng puer">Sheng puer</option>
                <option id="Shu puer" value="Shu puer">Shu puer</option>
            </select>
            <select id="country" name="country">
                <option id="China" selected value="China">China</option>
                <option id="Taiwan" value="Taiwan">Taiwan</option>
                <option id="India" value="India">India</option>
                <option id="Ceylon" value="Ceylon">Ceylon</option>
            </select>
            <div class="mdl-textfield mdl-js-textfield">
                <textarea class="mdl-textfield__input" type="text" rows= "5" id="edit-tea-description" name="description"></textarea>
                <label class="mdl-textfield__label" for="edit-tea-description">Description</label>
            </div>
        </div>

        <div class="mdl-dialog__actions centered-text">
            <button type="button"
                    class="mdl-button  mdl-js-button mdl-button--raised mdl-js-ripple-effect close">
                Discard
            </button>
            <button type="submit"
                    class="mdl-button  mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="edit-dialog-button">
                Create
            </button>
        </div>
    </form>
</dialog>
