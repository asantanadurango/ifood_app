const connection = require('../../database/index');

const userExiste = (req, res, next) => {
	const { email, password } = req.body;
	connection.query('SElECT * FROM users WHERE email = ? AND password = ?', [email, password], (err, results, fields) => {
		if (!err) {
			if (results[0]) {
				const user = results[0];
				req.body.user = "true";
				next();
			} else {
				res.json({ res: "false" });
			}
		} else {
			console.log(err);
			res.json({ res: new Error(err) });
		}
	});
};
module.exports = userExiste;
