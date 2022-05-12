const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database/index');

router.post('/cart/add', (req, res) => {
	const { name, price, img_url, cant } = req.body;
	connection.query('INSERT INTO cart VALUES(?, ?, ?, ?, ?)', [null, name, price, img_url, cant], (err, results, fields) => {
		if (!err) {
			res.json({
				res: 'record saved successfully at cart',
			});
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
