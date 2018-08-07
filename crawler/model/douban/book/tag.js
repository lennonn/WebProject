"use strict";

module.exports = function(sequelize,Sequelize){
    var DBTag = sequelize.define(
        'DBTag',
        {
            'id' : {
                'type' : Sequelize.UUID,
                'primaryKey' : true,		//主键
                'unique' : true,				//是否唯一
                'allowNull': false,
                'defaultValue' : Sequelize.UUIDV4,
                'comment' : '标签表id'
            },
            'category' : {
                'type' : Sequelize.STRING(64),
                'allowNull': true,
                'comment' : '种类'
            },
            'count' : {
                'type' : Sequelize.NUMERIC,
                'field' : 'count',
                'allowNull': true,
                'comment' : '种类数'
            },
            'name' : {
                'type' : Sequelize.STRING(100),
                'allowNull': true,
                'comment' : '类别名'
            },
            'url' : {
                'type' : Sequelize.STRING(100),
                'allowNull': true,
                'comment' : '链接'
            },
            'page' : {
                'type' : Sequelize.NUMERIC,
                'allowNull': true,
                'comment' : '第几页'
            }
        },{
            comment : '豆瓣读书标签表',
            timestamps : true,
            paranoid : true,
            deletedAt : 'deleted_at', //删除字段deletedAt别名
            freezeTableName : true,   //是否自定义表名
            tableName : 'db_tag', //自定义表名
            underscored : true    //使用驼峰命名法
        }
    );
    DBTag.sync({ force: false });

    return DBTag;
}
