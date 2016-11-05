$(function () {
    var form = $('#editTeaForm');
    form.submit(function (e) {
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
            success : function() {
                console.log("SUCCES");
                window.location.href = "/teas"
            },
            error : function(e) {
                console.log("ERROR: ", e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
        e.preventDefault();
    })
});

function deleteTea(teaid) {
    var url = "/ajax/admin/teas/" + teaid;
    $.ajax({
        type: "DELETE",
        url : url,
        timeout : 100000,
        success : function() {
            console.log("SUCCES");
            $("#datacards").load(location.href + " #datacards");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}