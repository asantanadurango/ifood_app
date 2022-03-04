const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../database/index');

router.put('/', (req, res) => {
	const { id, name, price, img_url } = req.body;
	connection.query(
		'UPDATE products SET name = ?, price = ?, img_url = ? WHERE id = ?',
		[name, price, img_url, id],
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
