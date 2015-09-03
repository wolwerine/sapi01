$(function() {

    $(".well").on("click", "#delete-comment-link", function(e) {
        e.preventDefault();

        var storyDeleteDialogTempate = Handlebars.compile($("#template-delete-comment-confirmation-dialog").html());

        $("#view-holder").append(storyDeleteDialogTempate());
        $("#delete-story-confirmation-dialog").modal();
    })

    $("#view-holder").on("click", "#cancel-comment-button", function(e) {
        e.preventDefault();

        var deleteConfirmationDialog = $("#delete-comment-confirmation-dialog")
        deleteConfirmationDialog.modal('hide');
        deleteConfirmationDialog.remove();
    });

    $("#view-holder").on("click", "#delete-comment-button", function(e) {
        e.preventDefault();
        window.location.href = "/comment/delete/" + $("#comment-id").text();
    });
});
