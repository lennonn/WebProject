let express = require('express');
let router = express.Router();
let request = require('request');
let cheerio = require('cheerio');
let fs = require('fs');
let log4js = require('log4js');
let logger = log4js.getLogger("tagList");
let config = require('../../../config/config');

var DBTag = require('../../../model/douban/book/index').DBTag;
let DBTagList = require('../../../servlet/douban/book/tagList');
let Ut = require("../../../public/js/common");


router.get('/taglist', (req, res, next) => {
    // TagModel.getOneByIndex(9).then((doc) => {
    // 	res.json(doc);
    // });
   //saveTagList( DBTag.query());
    DBTag.findAll({
    }).then(function(result){
    	console.log(result.length);
        saveTagList(result);
    });
})

   function saveTagList(docs) {
		let _len = docs.length;
		let picPath='./WebContent/images/douban/';
		for (let i = 0; i <_len; i++) {
			var _tagId = docs[i].id;
			(() => {
				setTimeout(() => {
					for (let j = 0; j < 1; j++) { //docs[i].page
						//增加时间间隔，防止被封IP
						(() => {
							setTimeout(() => {
								let _startIndex = 20 * j;
								let _tempUrl = docs[i].url + '?start=' + _startIndex + '&type=T';
								//logger.info(_tempUrl);
								request(_tempUrl, (error, response, body) => {
									logger.info('ListPageCode: ' + response.statusCode);
									if (!error && response.statusCode == 200) {
										let $ = cheerio.load(body);
										//logger.error(body);
										//let _tag = $('#content').find('h1').text().split(':')[1];
										let _list = $('#subject_list').find('.subject-list').find('.subject-item');
										logger.info('length ----->' + _list.length);
										logger.info('tag ----->' + _tagId);
										for (let n = 0; n < _list.length; n++) {
											let _this = $(_list[n]);
											let _name = _this.find('.info').find('h2 a').attr('title');
                                           	var _star= _this.find('.info').find('.star').find('.rating_nums').text().trim();
                                           	var imgUrl =_this.find('.pic').find('a img').attr('src');
                                           	if(_star==''){
                                                _star=1;//原网页评价人数不足默认位1；
											}
                                            let opts = {
                                                url: imgUrl,
                                            };
                                           let localUrl= imgUrl.substring(imgUrl.lastIndexOf('/')+1);
                                           console.log(imgUrl+"==================");
                                            (async () => {
                                           		await Ut.downImg(opts,picPath+localUrl);
                                            })()
											let _item = {
												//tag: _tagId,
												pic: localUrl,
												name: _name,
												url:_this.find('.info').find('h2 a').attr('href') ,
												pub: _this.find('.info').find('.pub').text().trim(),
												star:_star,
												desc: _this.find('.info').find('p').text().trim().replace(/[\n]/ig, '')
											};
                                            DBTagList.saveByInfo(_item);
	/*										TagListModel.findOneByName(_name).then((doc) => {
												if (!doc) {
													TagListModel.addOneItem(_item);
													//logger.info('insert');
												}
											});*/
											//获取详情
										}
										//logger.info(_result);
										//先保存起来，后续这段代码删除，数据存入数据库
										// fs.writeFile('./com_data/tagList/tagList_' + _name + '_page_' + (index + 1) + '.json', JSON.stringify(_result), 'utf-8', (err) => {
										// 	if (err) throw err;
										// 	console.log(_name + ' success...' + (index + 1))
										// });
									}
								});
							}, 1);
						})(j)
					}
				}, 1)
			})(i)
		}
		//res.send('loading...');
	};

function dealUrl(path){
	var _url = path.substring(path.lastIndexOf("/"),);
}
module.exports = router;