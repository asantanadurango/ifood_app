-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-04-2022 a las 10:35:12
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ifood_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `img_url` varchar(1000) NOT NULL,
  `rating` int(11) NOT NULL,
  `category` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `img_url`, `rating`, `category`) VALUES
(1, 'Hamburguesa sencilla', 3000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDVLKI7QqOKHbZXwCO2FkOSq7dgcaC_iJ9-w&usqp=CAU', 3, 'hamburger'),
(2, 'hot dog sencillo', 2000, 'http://eltortazoo.weebly.com/uploads/2/5/5/3/25531214/6729947_orig.jpg', 4, 'hotdogs'),
(3, 'coca-cola 1lt', 1000, 'https://m.media-amazon.com/images/I/5156FefjlqL._SX425_.jpg', 5, 'drinks'),
(10, 'Hambuerguesa Delux', 14000, 'https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2020/08/hamburguesa-2028707.jpg', 5, 'hamburguer'),
(11, 'Hamburguesa Morgan', 9900, 'https://media-cdn.tripadvisor.com/media/photo-s/1c/91/5a/42/burger-doble.jpg', 4, 'hamburguer'),
(12, 'Hotdog Deluxe', 15000, 'https://www.elviajerofisgon.com/wp-content/uploads/2016/09/Portada-iStock-1280x720.jpg', 4, 'hotdogs'),
(13, 'Hotdog Morgan', 9800, 'https://thumbs.dreamstime.com/z/perrito-caliente-de-lujo-1837971.jpg', 3, 'hotdogs'),
(14, 'Cerveza Pilsen', 2500, 'https://img.lalr.co/cms/2017/12/07194807/Pilsen.png?size=xl&ratio=r40_21', 2, 'drinks'),
(15, 'Aguila', 3000, 'https://www.cervezaaguila.com/sites/g/files/yrakuj311/files/2022-02/banner-home-main-mobil_0_0.png', 4, 'drinks'),
(16, 'People Pizza', 20000, 'http://peoplepizzas.com/wp-content/uploads/2019/06/logo_people_pizzas.png', 5, 'pizza'),
(17, 'Pïzza Piccolo', 18550, 'https://www.pizzaspiccolo.com.co//wp-content/uploads/2020/08/Piccolo-Foto-Pdcto-2x1-Marzo-.jpg', 3, 'pizza'),
(18, 'Pizza Ekono', 2500, 'https://media-cdn.tripadvisor.com/media/photo-s/0b/57/6f/2d/complete-pizza.jpg', 1, 'pizza'),
(19, 'Flan de Chocolate', 7000, 'https://content-cocina.lecturas.com/medio/2022/01/19/paso_a_paso_para_realizar_tarta_de_flan_con_galletas_y_chocolate_sin_azucar_resultado_final_1ce8842f_600x600.jpg', 1, 'desserts'),
(20, 'Torta de chocolate', 4800, 'https://www.cocinayvino.com/wp-content/uploads/2016/12/43120216_m-696x464.jpg', 5, 'desserts'),
(21, 'Postre de Melocoton', 9300, 'https://recetasfacil.online/wp-content/uploads/2018/06/postres-sin-horno-1.jpg', 3, 'desserts'),
(24, 'Brasa Paisa', 35000, 'https://restaurante.guide/wp-content/uploads/2019/10/la-brasa-paisa-logo.jpg', 4, 'chicken'),
(25, 'KFC Pollo Entero', 39900, 'https://i.pinimg.com/originals/8f/17/7e/8f177ebf696f23a82d95ce36bdf83d02.jpg', 4, 'chicken'),
(26, 'Desayuno Completo', 15000, 'https://pbs.twimg.com/media/Ezvr0KVWEAMF_6W.jpg', 5, 'breakfast'),
(27, 'French Toast', 12000, 'https://okdiario.com/img/2019/04/14/tostadas-francesas-2.jpg', 5, 'breakfast'),
(28, 'Tamagochi Ramen', 22000, 'https://media-cdn.tripadvisor.com/media/photo-s/1c/47/23/72/classic-ramen-strong.jpg', 4, 'oriental'),
(29, 'Sarku Japan', 22000, 'https://www.portafolio.co/files/article_multimedia/uploads/2022/01/31/61f83d6a1fc4b.png', 2, 'oriental'),
(30, 'Sushi Grill', 24000, 'https://s1.eestatic.com/2015/05/11/cocinillas/cocinillas_32506750_116175094_1024x576.jpg', 1, 'oriental'),
(31, 'Veggie Bowl', 16500, 'https://post.healthline.com/wp-content/uploads/2020/09/vegetarian-diet-plan-732x549-thumbnail-732x549.jpg', 5, 'veggie'),
(32, 'Una Zanahoria', 450, 'https://www.collinsdictionary.com/images/full/carrot_125262134.jpg', 1, 'veggie'),
(33, 'Cazuela de Frijoles', 22700, 'https://elrancherito.com.co/wp-content/uploads/2020/06/Cazuela-Vegetariana-600x600.jpg', 5, 'lunch'),
(34, 'Plato Tipico', 15000, 'https://thumbs.dreamstime.com/z/paisa-de-bandeja-plato-t%C3%ADpico-en-la-regi%C3%B3n-antioque%C3%A3%C2%B1o-colombia-antioque%C3%A3%C2%B1a-consiste-el-%C2%B3-n-del-chicharr%C3%A3-fri%C3%B3-vientre-148723556.jpg', 5, 'lunch'),
(37, 'Asados Al Carbon', 18900, 'https://restaurante.guide/wp-content/uploads/2019/07/alcarbon-logo.jpg', 4, 'lunch'),
(38, 'Taco Azteca', 43500, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFm7n6GYv-n-OlRXcEvbBXRrzoNXUr1p3Vlw&usqp=CAU', 5, 'tacos'),
(39, 'Tacos', 18500, 'https://friendlystock.com/wp-content/uploads/2020/04/7-angry-mexican-taco-cartoon-clipart.jpg', 4, 'tacos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products_x_tags`
--

CREATE TABLE `products_x_tags` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE `tags` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tags`
--

INSERT INTO `tags` (`id`, `name`) VALUES
(1, 'bebidas'),
(2, 'comidas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `state` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `adress`, `state`) VALUES
(1, 'usuario', 'usuario@gmail.com', '123', 'cll 1 cra 23', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `products_x_tags`
--
ALTER TABLE `products_x_tags`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product` (`product_id`),
  ADD KEY `fk_tag` (`tag_id`);

--
-- Indices de la tabla `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `products_x_tags`
--
ALTER TABLE `products_x_tags`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tags`
--
ALTER TABLE `tags`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `products_x_tags`
--
ALTER TABLE `products_x_tags`
  ADD CONSTRAINT `fk_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tag` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
