var express = require('express');
var router = express.Router();
let Ut = require("../public/js/common");
/* GET users listing. */
router.get('/download', function(req, res, next) {


    (async () => {
        try {
            let url = "https://img3.doubanio.com/view/subject/m/public/s1992472.jpg";
            let opts = {
                url: url,
            };
            let path = "./WebContent/images/douban/123456789.jpg";
            let _url =url.substring(url.lastIndexOf('/')+1);
            let r1 = await Ut.downImg(opts, path);
            console.log(r1+_url);
        }
        catch (e) {
            console.log(e);
        }
    })()
});

module.exports = router;
