const express = require('express');
const router = express.Router();
const connection = require('../../database/index');

router.get('/users', (req, res) => {
	connection.query('SELECT * FROM users', (err, results, fields) => {
		if (!err) {
			res.json(results);
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
