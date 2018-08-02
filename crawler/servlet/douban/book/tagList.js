/**
 * Created by public on 2016/6/14.
 */

var moment = require('moment');
var logger = require('../../../config/log4js').log4js.getLogger(__filename);
var servlet={};
var DBTag = require('../../../model/douban/book/index').DBTag;

servlet.DBTag = DBTag;

/**
 * 保存方法
 * @param callback  回调函数
 * @param map       参数集合
 */
servlet.save = function(callback,map){
	DBTag.build(map).save().then(function(result){
		logger.info('保存CZTags表成功');
		//callback(result);
	});
};

servlet.saveByInfo = function(item){
	DBTag.build({
 	 'category' : item.category,
 	 'name' : item.name,
 	 'count' : item.count,
		'url' : item.url,
  }).save().then(function(result){
        logger.info('保存CZTags表成功');
	});
};





module.exports = servlet;
