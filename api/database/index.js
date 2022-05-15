const mysql = require('mysql');
const connection = mysql.createConnection({
	host: 'localhost',
	user: 'root',
	password: '',
	database: 'ifood_db',
});

connection.connect();

// host: 'cesde-moviles2-jueves.chl4iqqludt9.us-east-1.rds.amazonaws.com',
// 	user: 'admin',
// 	password: 'cesde-moviles2-jueves',
// 	database: 'cesde-moviles2-jueves',

// connection.query('SELECT * FROM employees', (err, results, fields) => {
// 	if (!err) {
// 		console.log(results);
// 	} else {
// 		console.log('err');
// 	}
// });

module.exports = connection;
