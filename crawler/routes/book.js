const express = require("express");
const router = express.Router();
const book = require("../spider/book/book");

router.get('/book', function(req, res, next) {
    book.main("https://www.zwdu.com/book/13205/");
    res.send('book crawer is spider');
});

module.exports = router;