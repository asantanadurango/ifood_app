const express = require('express');
const router = express.Router();

// Routes
// Products
const routerGetAllProducts = require('./products/route.getAllProducts.js');
const routerAddProduct = require('./products/route.addProduct');
const routerUpdateProduct = require('./products/route.updateProduct');
const routerDeleteProductById = require('./products/route.deleteProductById');
router.use(routerGetAllProducts);
router.use(routerAddProduct);
router.use(routerUpdateProduct);
router.use(routerDeleteProductById);

// Users
const routerAddUser = require('./users/route.addUser');
const routerGetAllUsers = require('./users/route.getAllData.js');
const routerUserLogin = require('./users/route.userLogin.js');
router.use(routerAddUser);
router.use(routerGetAllUsers);
router.use(routerUserLogin);

// Cart
const routerGetAllCart = require('./cart/route.getAllCart.js')
const routerAddCart = require('./cart/route.addCart.js')
const routerDeleteCartById = require('./cart/route.deleteCartById.js')
const routerSearchCartById = require('./cart/route.searchCartById')
router.use(routerGetAllCart);
router.use(routerAddCart);
router.use(routerDeleteCartById);
router.use(routerSearchCartById);






module.exports = router;
