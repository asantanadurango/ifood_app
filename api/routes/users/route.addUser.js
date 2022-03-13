const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database/index');

router.post('/users/add', (req, res) => {
	const { name, price, img_url } = req.body;
	connection.query('INSERT INTO users VALUES(?, ?, ?, ?)', [null, name, email, password, adress], (err, results, fields) => {
		if (!err) {
			res.json({
				res: 'record saved successfully',
			});
		} else {
			console.log(err);
		}
	});
});

module.exports = router;
