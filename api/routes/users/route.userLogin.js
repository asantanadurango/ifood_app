const express = require('express');
const router = express.Router();
const userExist = require('../middlewares/userExist.js');

router.post('/users/login', userExist, (req, res) => {
	const { user } = req.body;
	res.json(user);
});

module.exports = router;
