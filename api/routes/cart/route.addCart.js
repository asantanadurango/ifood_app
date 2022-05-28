const express = require('express');
const router = express.Router();
const connection = require('../../database/index');
const productExistInCart = require('../middlewares/productExistInCart.js');


router.post('/cart/add', productExistInCart, (req, res) => {
	const { name, price, img_url, cant } = req.body;
	const { queryCart } = req;
	connection.query(queryCart, [null, name, price, img_url, cant], (err, results, fields) => {
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
