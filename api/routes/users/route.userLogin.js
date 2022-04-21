const express = require('express');
const router = express.Router();
router.use(express.json());

router.post('/users/login', (req, res) => {
	const { user } = req.body;
	console.log(user);
	res.json( user );
});

module.exports = router;
