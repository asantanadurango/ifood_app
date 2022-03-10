const express = require('express');
const router = express.Router();

// Routes
const routerGetAllData = require('./products/route.getAllData.js');
const routerSearchById = require('./products/route.searchById');
const routerDeleteById = require('./products/route.deleteById');
const routerAddProduct = require('./products/route.addProduct');
const routerUpdateProduct = require('./products/route.updateProduct');

// Middlewares
router.use(routerGetAllData);
router.use(routerSearchById);
router.use(routerAddProduct);
router.use(routerUpdateProduct);
router.use(routerDeleteById);

module.exports = router;
