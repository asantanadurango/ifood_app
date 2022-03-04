const express = require('express');
const router = require('./routes/index');
const cors = require('cors');
const bodyParser = require('body-parser');
const app = express();

// Settings
const PORT = process.env.PORT || 8080;

// Middlewares
app.use(cors());
app.use(bodyParser.json());
app.use(router).listen(PORT, () => {
	console.clear();
	console.log('Api on', PORT);
});
