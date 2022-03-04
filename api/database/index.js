const mysql = require('mysql');
const connection = mysql.createConnection({
	host: 'localhost',
	user: 'root',
	password: '',
	database: 'ifood_db',
});

connection.connect();

// connection.query('SELECT * FROM employees', (err, results, fields) => {
// 	if (!err) {
// 		console.log(results);
// 	} else {
// 		console.log('err');
// 	}
// });

module.exports = connection;
