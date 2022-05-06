const connection = require('../../database/index');

const userExiste = (req, res, next) => {
	console.log(req.body);
	const { email, password } = req.body;
	connection.query('SElECT * FROM users WHERE email = ? AND password = ?', [email, password], (err, results, fields) => {
		// console.log(results[0]);
		if (!err) {
			if (results[0]) {
				const user = results[0];
				user.state = 1;
				req.body.user = user;
				next();
			} else {
				// console.log('false');
				res.json(null);
			}
		} else {
			console.log(err);
			res.json({ res: new Error(err) });
		}
	});
};
module.exports = userExiste;
