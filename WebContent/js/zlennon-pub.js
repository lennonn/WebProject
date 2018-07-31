function getContent(url) {
    $.ajax({
        url: url,
        type: "post",
        success: function (data) {
            $("#rightContent").html(data);
        }
    });
};

function getWebContent(url) {
    $.ajax({
        url: url,
        type: "post",
        success: function (data) {
            $("#leftContent").html(data);
        }
    });
};