const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database');

router.post('/products/category', (req, res) => {
	const { category } = req.body;
	console.log(category);
	connection.query('SELECT * FROM products WHERE category = ?', [category], (err, results, fields) => {
		console.log(results);
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
