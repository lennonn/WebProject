/**
 * Created by public on 2016/6/14.
 */

var moment = require('moment');
var logger = require('../../../config/log4js').log4js.getLogger(__filename);
var servlet={};
var dbtags = require('../../../model/douban/book/tag').dbtags;

servlet.dbtags = dbtags;

/**
 * 保存方法
 * @param callback  回调函数
 * @param map       参数集合
 */
servlet.save = function(callback,map){
	dbtags.build(map).save().then(function(result){
		logger.info('保存CZTags表成功');
		callback(result);
	});
};

servlet.saveByInfo = function(name,uid,fid,href,pic,brief,typeId,pid){
	dbtags.build({
 	 'typeId' : typeId,
 	 'name' : name,
 	 'uid' : uid,
 	 'fid' : fid,
 	 'href' : href,
 	 'pic' : pic,
 	 'brief' : brief,
 	 'pid' : pid
  }).save().then(function(result){});
};





module.exports = servlet;
