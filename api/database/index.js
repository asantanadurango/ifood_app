const mysql = require('mysql');
require('dotenv').config();
const connection = mysql.createConnection({
	host: process.env.HOST_DB,
	user: process.env.USER_DB,
	password: process.env.PASSWORD_DB,
	database: process.env.DATABASE_DB,
});
connection.connect();
module.exports = connection;
