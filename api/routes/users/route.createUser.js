const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../database/index');

router.post('/users/create', (req, res) => {
	const { name, price, img_url } = req.body;
	connection.query('INSERT INTO products VALUES(?, ?, ?, ?)', [null, name, price, img_url], (err, results, fields) => {
		if (!err) {
			res.json({
				res: 'record saved successfully',
			});
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
