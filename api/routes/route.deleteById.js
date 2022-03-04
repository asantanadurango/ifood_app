const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../database/index');

router.delete('/:id', (req, res) => {
	const { id } = req.params;
	connection.query(
		'DELETE FROM products WHERE id = ?',
		[id],
		(err, results, fields) => {
			if (!err) {
				console.log(results);
				if (results[0]) {
					res.json({
						res: 'record deleted successfully',
					});
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
