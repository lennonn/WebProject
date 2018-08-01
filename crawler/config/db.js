const database = {
    DATABASE: 'zlennon',
    USERNAME: 'root',
    PASSWORD: '123456',
    PORT: '3306',
    options:
        {
            "dialect": "mysql",
            "host": "127.0.0.1",
            "timezone": "+08:00"
        }
}

var Sequelize = require('sequelize');
var db = {};

var sequelize = new Sequelize(database.DATABASE,database.USERNAME,database.PASSWORD,database.options);
db.Sequelize = Sequelize;
db.sequelize = sequelize;

module.exports = db, database
