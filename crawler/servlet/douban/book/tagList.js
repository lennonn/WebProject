/**
 * Created by public on 2016/6/14.
 */

var moment = require('moment');
var logger = require('../../../config/log4js').log4js.getLogger(__filename);
var servlet={};
var DBTagList = require('../../../model/douban/book/index').DBTagList;

servlet.DBTagList = DBTagList;

/**
 * 保存方法
 * @param callback  回调函数
 * @param map       参数集合
 */
servlet.save = function(callback,map){
	DBTagList.build(map).save().then(function(result){
		logger.info('保存CZTags表成功');
		//callback(result);
	});
};

servlet.saveByInfo = function(item){
	DBTagList.build({
 	 'pic' : item.pic,
 	 'name' : item.name,
 	 'url' : item.url,
		'pub' : item.pub,
        'star' : item.star,
        'desc' : item.desc

  }).save().then(function(result){
        logger.info('保存CZTags表成功');
	});
};





module.exports = servlet;
