const express = require('express');
const router = express.Router();
router.use(express.json());
// Middlewares
const userExist = require('../middlewares/userExist.js');

router.post('/users/login',userExist, (req, res) => {
	const { user } = req.body;
	console.log(user);
	res.json( user );
});

module.exports = router;
