const express = require('express');
const router = express.Router();

// Routes
const routerGetAllData = require('./route.getAllData');
const routerSearchById = require('./route.searchById');
const routerDeleteById = require('./route.deleteById');
const routerAddProduct = require('./route.addProduct');
const routerUpdateProduct = require('./route.updateProduct');

// Middlewares
router.use(routerGetAllData);
router.use(routerSearchById);
router.use(routerAddProduct);
router.use(routerUpdateProduct);
router.use(routerDeleteById);

module.exports = router;
