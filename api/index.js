const express = require('express');
const router = require('./routes/index.js');
const app = express();
require('dotenv').config();

// Settings
const PORT = process.env.PORT;

// Middlewares
app.use(express.json());
app.use(router).listen(PORT, () => {
	console.clear();
	console.log('Api on', PORT);
});
