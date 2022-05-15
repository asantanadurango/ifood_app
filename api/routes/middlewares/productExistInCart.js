const connection = require('../../database/index');

const productExistInCart = (req, res, next) => {
	console.log("middleware cart")
	// console.log(req.body);
	const { name, cant } = req.body;
	connection.query('SElECT * FROM cart WHERE name = ?', [name], (err, results, fields) => {
		console.log(results[0])
		if (!err) {
			if (results[0]) {
				const newCant = Number(results[0].cant) + Number(cant)
				req.queryCart=`UPDATE cart SET cant = '${newCant}' WHERE name = '${name}'`
			} else {
				req.queryCart = 'INSERT INTO cart VALUES(?, ?, ?, ?, ?)'
				// res.json(null);
			}
				next();
		} else {
			console.log(err);
			res.json({ res: new Error(err) });
		}
	});
};
module.exports = productExistInCart;