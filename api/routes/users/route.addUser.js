const express = require('express');
const router = express.Router();
const connection = require('../../database/index');

router.post('/users/add', (req, res) => {
	const { name, email, password, adress, state } = req.body;
	connection.query('INSERT INTO users VALUES(?, ?, ?, ?, ?, ?)', [null, name, email, password, adress, state], (err, results, fields) => {
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
