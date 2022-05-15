const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database/index');

router.delete('/cart/delete/:id', (req, res) => {
	const { id } = req.params;
	connection.query('DELETE FROM cart WHERE id = ?', [id], (err, results, fields) => {
		if (!err) {
			console.log(results);
				res.json({
					res: 'record deleted successfully',
				});
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
