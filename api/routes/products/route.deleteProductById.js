const express = require('express');
const router = express.Router();
const connection = require('../../database/index');

router.delete('/products/delete/:id', (req, res) => {
	const { id } = req.params;
	connection.query('DELETE FROM products WHERE id = ?', [id], (err, results, fields) => {
		if (!err) {
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
	});
});

module.exports = router;
