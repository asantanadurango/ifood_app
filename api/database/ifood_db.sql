--
-- Base de datos: `ifood_db`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `img_url` varchar(1000) NOT NULL,
  `rating` int(11) NOT NULL,
  `category` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;


INSERT INTO `products` (`id`, `name`, `price`, `img_url`, `rating`, `category`) VALUES
(1, 'Hamburguesa sencilla', 3000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDVLKI7QqOKHbZXwCO2FkOSq7dgcaC_iJ9-w&usqp=CAU', 3, 'Burgers'),
(2, 'hot dog sencillo', 2000, 'http://eltortazoo.weebly.com/uploads/2/5/5/3/25531214/6729947_orig.jpg', 4, 'Hotdogs'),
(3, 'coca-cola 1lt', 1000, 'https://m.media-amazon.com/images/I/5156FefjlqL._SX425_.jpg', 5, 'Bebidas'),
(4, 'Hambuerguesa Delux', 14000, 'https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2020/08/hamburguesa-2028707.jpg', 5, 'Burgers'),
(5, 'Hamburguesa Morgan', 9900, 'https://media-cdn.tripadvisor.com/media/photo-s/1c/91/5a/42/burger-doble.jpg', 4, 'Burgers'),
(6, 'Hotdog Deluxe', 15000, 'https://www.elviajerofisgon.com/wp-content/uploads/2016/09/Portada-iStock-1280x720.jpg', 4, 'Hotdogs'),
(7, 'Hotdog Morgan', 9800, 'https://thumbs.dreamstime.com/z/perrito-caliente-de-lujo-1837971.jpg', 3, 'Hotdogs'),
(8, 'Cerveza Pilsen', 2500, 'https://img.lalr.co/cms/2017/12/07194807/Pilsen.png?size=xl&ratio=r40_21', 2, 'Bebidas'),
(9, 'Aguila', 3000, 'https://www.cervezaaguila.com/sites/g/files/yrakuj311/files/2022-02/banner-home-main-mobil_0_0.png', 4, 'Bebidas'),
(10, 'People Pizza', 20000, 'http://peoplepizzas.com/wp-content/uploads/2019/06/logo_people_pizzas.png', 5, 'Pizzas'),
(11, 'Pïzza Piccolo', 18550, 'https://www.pizzaspiccolo.com.co//wp-content/uploads/2020/08/Piccolo-Foto-Pdcto-2x1-Marzo-.jpg', 3, 'Pizzas'),
(12, 'Pizza Ekono', 2500, 'https://media-cdn.tripadvisor.com/media/photo-s/0b/57/6f/2d/complete-pizza.jpg', 1, 'Pizzas'),
(13, 'Flan de Chocolate', 7000, 'https://content-cocina.lecturas.com/medio/2022/01/19/paso_a_paso_para_realizar_tarta_de_flan_con_galletas_y_chocolate_sin_azucar_resultado_final_1ce8842f_600x600.jpg', 1, 'Postres'),
(14, 'Torta de chocolate', 4800, 'https://www.cocinayvino.com/wp-content/uploads/2016/12/43120216_m-696x464.jpg', 5, 'Postres'),
(15, 'Postre de Melocoton', 9300, 'https://recetasfacil.online/wp-content/uploads/2018/06/postres-sin-horno-1.jpg', 3, 'Postres'),
(16, 'Brasa Paisa', 35000, 'https://restaurante.guide/wp-content/uploads/2019/10/la-brasa-paisa-logo.jpg', 4, 'Pollos'),
(17, 'KFC Pollo Entero', 39900, 'https://i.pinimg.com/originals/8f/17/7e/8f177ebf696f23a82d95ce36bdf83d02.jpg', 4, 'Pollos'),
(18, 'Desayuno Completo', 15000, 'https://pbs.twimg.com/media/Ezvr0KVWEAMF_6W.jpg', 5, 'Desayunos'),
(19, 'French Toast', 12000, 'https://okdiario.com/img/2019/04/14/tostadas-francesas-2.jpg', 5, 'Almuerzos'),
(20, 'Tamagochi Ramen', 22000, 'https://media-cdn.tripadvisor.com/media/photo-s/1c/47/23/72/classic-ramen-strong.jpg', 4, 'Oriental'),
(21, 'Sarku Japan', 22000, 'https://www.portafolio.co/files/article_multimedia/uploads/2022/01/31/61f83d6a1fc4b.png', 2, 'Oriental'),
(22, 'Sushi Grill', 24000, 'https://s1.eestatic.com/2015/05/11/cocinillas/cocinillas_32506750_116175094_1024x576.jpg', 1, 'Oriental'),
(23, 'Veggie Bowl', 16500, 'https://post.healthline.com/wp-content/uploads/2020/09/vegetarian-diet-plan-732x549-thumbnail-732x549.jpg', 5, 'Veggie'),
(24, 'Una Zanahoria', 450, 'https://www.collinsdictionary.com/images/full/carrot_125262134.jpg', 1, 'Veggie'),
(25, 'Cazuela de Frijoles', 22700, 'https://elrancherito.com.co/wp-content/uploads/2020/06/Cazuela-Vegetariana-600x600.jpg', 5, 'Desayunos'),
(26, 'Plato Tipico', 15000, 'https://thumbs.dreamstime.com/z/paisa-de-bandeja-plato-t%C3%ADpico-en-la-regi%C3%B3n-antioque%C3%A3%C2%B1o-colombia-antioque%C3%A3%C2%B1a-consiste-el-%C2%B3-n-del-chicharr%C3%A3-fri%C3%B3-vientre-148723556.jpg', 5, 'Desayunos'),
(27, 'Asados Al Carbon', 18900, 'https://restaurante.guide/wp-content/uploads/2019/07/alcarbon-logo.jpg', 4, 'Desayunos'),
(28, 'Taco Azteca', 43500, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFm7n6GYv-n-OlRXcEvbBXRrzoNXUr1p3Vlw&usqp=CAU', 5, 'Tacos'),
(29, 'Tacos', 18500, 'https://friendlystock.com/wp-content/uploads/2020/04/7-angry-mexican-taco-cartoon-clipart.jpg', 4, 'Tacos');

-- --------------------------------------------------------


CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `state` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;


INSERT INTO `users` (`id`, `name`, `email`, `password`, `adress`, `state`) VALUES
(1, 'usuario', 'usuario@gmail.com', '123', 'cll 1 cra 23', 0);


CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `img_url` varchar(1000) NOT NULL,
  `cant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
  COMMIT;

