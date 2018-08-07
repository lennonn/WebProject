"use strict";

module.exports = function(sequelize,Sequelize){
    var DBTagList = sequelize.define(
        'DBTagList',
        {
            'id' : {
                'type' : Sequelize.UUID,
                'primaryKey' : true,		//主键
                'unique' : true,				//是否唯一
                'allowNull': false,
                'defaultValue' : Sequelize.UUIDV4,
                'comment' : '标签列表id'
            },
            'pic' : {
                'type' : Sequelize.STRING(100),
                'allowNull': true,
                'comment' : '图书封面'
            },
            'name' : {
                'type' : Sequelize.STRING(100),
                'allowNull': true,
                'comment' : '书名'
            },
            'url' : {
                'type' : Sequelize.STRING(200),
                'allowNull': true,
                'comment' : '链接'
            },
            'pub' : {
                'type' : Sequelize.STRING(300),
                'allowNull': true,
                'comment' : 'pub'
            },
            'star' : {
                'type' : Sequelize.DECIMAL(10,1),
                'allowNull': true,
                'comment' : '评分'
            },
            'desc' : {
                'type' : Sequelize.STRING(500),
                'allowNull': true,
                'comment' : '描述'
            }
        },{
            comment : '豆瓣读书标签表',
            timestamps : true,
            paranoid : true,
            deletedAt : 'deleted_at', //删除字段deletedAt别名
            freezeTableName : true,   //是否自定义表名
            tableName : 'db_tag_list', //自定义表名
            underscored : true    //使用驼峰命名法
        }
    );
   // DBTagList.sync({ force: false });

    return DBTagList;
}
