const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../database/index');

router.get('/', (req, res) => {
	connection.query('SELECT * FROM products', (err, results, fields) => {
		if (!err) {
			res.json(results);
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
