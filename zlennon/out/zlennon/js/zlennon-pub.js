function getContent(url) {
    $.ajax({
        url: url,
        type: "post",
        success: function (data) {
            $("#rightContent").html(data);
        }
    });
};