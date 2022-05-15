const express = require('express');
const router = express.Router();
router.use(express.json());
const productExistInCart = require('../middlewares/productExistInCart.js')

const connection = require('../../database/index');

router.post('/cart/add', productExistInCart, (req, res) => {
	const { name, price, img_url, cant } = req.body;
	const {queryCart} = req;
	connection.query(queryCart, [null, name, price, img_url, cant], (err, results, fields) => {
		console.log("mostrando results")
		console.log(results)
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
