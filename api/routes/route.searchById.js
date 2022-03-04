const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../database/index');

router.get('/:id', (req, res) => {
	const { id } = req.params;
	connection.query(
		'SELECT * FROM products WHERE id = ?',
		[id],
		(err, results, fields) => {
			console.log(results);
			if (!err) {
				if (results[0]) {
					res.json(results[0]);
				} else {
					res.json({
						err: 'user not found',
					});
				}
			} else {
				console.log(err);
			}
		}
	);
});

module.exports = router;
