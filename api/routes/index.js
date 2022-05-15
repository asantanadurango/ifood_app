const express = require('express');
const router = express.Router();

// Middlewares
const userExist = require('./middlewares/userExist.js');

// Routes
// Products
const routerGetAllProducts = require('./products/route.getAllProducts.js');
const routerAddProduct = require('./products/route.addProduct');
const routerUpdateProduct = require('./products/route.updateProduct');
const routerDeleteProductById = require('./products/route.deleteProductById');

// Users
const routerAddUser = require('./users/route.addUser');
const routerGetAllUsers = require('./users/route.getAllData.js');
const routerUserLogin = require('./users/route.userLogin.js');

// Cart
const routerGetAllCart = require('./cart/route.getAllCart.js')
const routerAddCart = require('./cart/route.addCart.js')
const routerDeleteCartById = require('./cart/route.deleteCartById.js')
const routerSearchCartById = require('./cart/route.searchCartById')


// Products
router.use(routerGetAllProducts);
router.use(routerAddProduct);
router.use(routerUpdateProduct);
router.use(routerDeleteProductById);

//Cart
router.use(routerGetAllCart);
router.use(routerAddCart);
router.use(routerDeleteCartById);
router.use(routerSearchCartById);

// Users
router.use(routerAddUser);
router.use(routerGetAllUsers);
router.use(userExist, routerUserLogin);





module.exports = router;
