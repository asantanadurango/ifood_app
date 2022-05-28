const express = require('express');
const router = express.Router();
const connection = require('../../database');

router.get('/products', (req, res) => {
	const { category } = req.query;
	const query = category ? `SELECT * FROM products WHERE category = '${category}'` : `SELECT * FROM products`;
	connection.query(query, (err, results, fields) => {
		if (!err) {
			if (results[0]) {
				res.json(results);
			} else {
				res.json({
					err: 'user not found',
				});
			}
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
