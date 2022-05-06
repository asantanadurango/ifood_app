const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database');

router.get('/products?/:category?', (req, res) => {
	const { category } = req.params;
	const query = category ? `SELECT * FROM products WHERE category = '${category}'` : `SELECT * FROM products`
	console.log('cate');
	console.log(category);
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
