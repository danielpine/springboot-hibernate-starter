const NetUtil = {
    curl: function (url) {
        let html = ''
        $.ajax({
            url: url,
            type: 'get',
            async: false,
            cache: false,
            success: function (res) {
                html = res
            }
        })
        return html
    }
};