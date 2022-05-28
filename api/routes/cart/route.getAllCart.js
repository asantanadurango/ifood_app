const express = require('express');
const router = express.Router();
const connection = require('../../database/index');

router.get('/cart', (req, res) => {
	connection.query('SELECT * FROM cart', (err, results, fields) => {
		if (!err) {
			res.json(results);
		} else {
			console.log(err);
		}
	});
	// res.send("hola")
});

module.exports = router;
