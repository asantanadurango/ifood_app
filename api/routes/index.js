const express = require('express');
const router = express.Router();

// Routes

// Products
const routerGetAllProducts = require('./products/route.getAllProducts.js');
const routerSearchProductById = require('./products/route.searchProductById');
const routerAddProduct = require('./products/route.addProduct');
const routerUpdateProduct = require('./products/route.updateProduct');
const routerDeleteProductById = require('./products/route.deleteProductById');

// Users
const routerAddUser = require('./users/route.addUser');
const routerGetAllUsers = require('./users/route.getAllData.js');
const routerUserLogin = require('./users/route.userLogin.js');

// Middlewares
const userExist = require('./middlewares/userExist.js');
// Products
router.use(routerGetAllProducts);
router.use(routerSearchProductById);
router.use(routerAddProduct);
router.use(routerUpdateProduct);
router.use(routerDeleteProductById);

// Users
router.use(routerAddUser);
router.use(routerGetAllUsers);
router.use(userExist, routerUserLogin);

module.exports = router;
