const connection = require('../../database/index');

const productExistInCart = (req, res, next) => {
	const { name, cant } = req.body;
	connection.query('SElECT * FROM cart WHERE name = ?', [name], (err, results, fields) => {
		if (!err) {
			if (results[0]) {
				const newCant = Number(results[0].cant) + Number(cant);
				req.queryCart = `UPDATE cart SET cant = '${newCant}' WHERE name = '${name}'`;
			} else {
				req.queryCart = 'INSERT INTO cart VALUES(?, ?, ?, ?, ?)';
			}
			next();
		} else {
			console.log(err);
			res.json({ res: new Error(err) });
		}
	});
};
module.exports = productExistInCart;
