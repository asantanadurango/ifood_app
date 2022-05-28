const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database/index');

router.put('/products/update/:id', (req, res) => {
	const { id, name, price, img_url, rating } = req.body;
	connection.query(
		'UPDATE products SET name = ?, price = ?, img_url = ?, rating = ? WHERE id = ?',
		[name, price, img_url, id, rating],
		(err, results, fields) => {
			if (!err) {
				res.json({
					res: 'record updated successfully',
				});
			} else {
				console.log(err);
			}
		}
	);
});

module.exports = router;
