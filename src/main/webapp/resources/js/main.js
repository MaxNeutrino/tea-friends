(function() {
    /*var obj = document.getElementById('hidden-block')
    obj.style.display = 'none';*/

    'use strict';
    var snackbarContainer = document.querySelector('#toast-show');
    var showToastButtonDrunkTea = document.querySelectorAll('.drunk');
    var showToastButtonWishTea = document.querySelectorAll('.wish');
    var showToastButtonDeleteTea = document.querySelectorAll('.delete');

    for (var i = 0; i < showToastButtonDrunkTea.length; i++) {
        showToastButtonDrunkTea[i].addEventListener('click', function () {
            'use strict';
            var data = {message: 'Tea added to drunk list'};
            snackbarContainer.MaterialSnackbar.showSnackbar(data);
        });

        showToastButtonWishTea[i].addEventListener('click', function () {
            'use strict';
            var data = {message: 'Tea added to wish list'};
            snackbarContainer.MaterialSnackbar.showSnackbar(data);
        });

        if (showToastButtonDeleteTea[i].getAttribute("is") !== "disabled") {
            showToastButtonDeleteTea[i].addEventListener('click', function () {
                'use strict';
                var data = {message: 'Tea deleted from your list'};
                snackbarContainer.MaterialSnackbar.showSnackbar(data);
            });
        }
    }
}());

function hideBlock() {
    var x = document.getElementById('hidden-block');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}
