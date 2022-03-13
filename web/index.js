const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.use(express.static('public/form_users'));

app.get('/', function (req, res) {
	res.send('hello');
});
app.listen(PORT, () => {
	console.clear();
	console.log('form on port', PORT);
});
