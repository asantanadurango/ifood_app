const express = require('express');
const router = express.Router();
router.use(express.json());

const connection = require('../../database/index');

router.get('/cart', (req, res) => {
	// console.log("yes")
	connection.query('SELECT * FROM cart', (err, results, fields) => {
		if (!err) {
			res.json(results);
		} else {
			console.log(err);
		}
	});
	// res.send("hola")
});

module.exports = router;
