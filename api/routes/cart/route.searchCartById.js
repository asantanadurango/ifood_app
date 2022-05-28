const express = require('express');
const router = express.Router();
const connection = require('../../database/index');

router.get('/cart/search/:id', (req, res) => {
	const { id } = req.params;
	connection.query('SELECT * FROM cart WHERE id = ?', [id], (err, results, fields) => {
		if (!err) {
			console.log(results);
			if (results[0]) {
				res.json(results[0]);
			} else {
				res.json({
					err: 'cart not found',
				});
			}
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
