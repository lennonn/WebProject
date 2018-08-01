var mysql = require('mysql');
const database = {
    DATABASE: 'zlennon',
    USERNAME: 'root',
    PASSWORD: '123456',
    PORT: '3306',
    HOST: 'localhost'
}
const pool = mysql.createPool({
    host     : database.HOST,
    user     : database.USERNAME,
    password : database.PASSWORD,
    database : database.DATABASE,
    port     : database.PORT,
    dialect  : 'mysql'
})
module.exports = pool;