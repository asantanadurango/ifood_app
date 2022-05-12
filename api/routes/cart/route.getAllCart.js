const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database/index');

router.get('/cart', (req, res) => {
	connection.query('SELECT * FROM cart', (err, results, fields) => {
		if (!err) {
			res.json(results);
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
