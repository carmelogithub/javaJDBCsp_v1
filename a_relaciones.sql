-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2024 a las 18:02:55
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `a_relaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lectores`
--

CREATE TABLE `lectores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lectores`
--

INSERT INTO `lectores` (`id`, `nombre`, `ciudad`, `correo`) VALUES
(1, 'marta', 'sevilla', 'marta@gmail.com'),
(2, 'sofía', 'alicante', 'sofia@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `unidades` int(11) NOT NULL,
  `observaciones` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `titulo`, `unidades`, `observaciones`) VALUES
(1, 'El Quijote', 4, 'Es un libro de aventuras'),
(2, 'La insoportable levedad del ser', 25, 'libro de milan kundera');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_lector` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `fecha`, `id_lector`, `id_libro`) VALUES
(1, '2024-09-17', 1, 1),
(3, '2024-09-20', 2, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_resumen`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_resumen` (
`nombre` varchar(100)
,`titulo` varchar(100)
,`fecha` date
);

-- --------------------------------------------------------

--
-- Estructura para la vista `v_resumen`
--
DROP TABLE IF EXISTS `v_resumen`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_resumen`  AS SELECT `lectores`.`nombre` AS `nombre`, `libros`.`titulo` AS `titulo`, `reservas`.`fecha` AS `fecha` FROM ((`reservas` join `lectores` on(`reservas`.`id_lector` = `lectores`.`id`)) join `libros` on(`reservas`.`id_libro` = `libros`.`id`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `lectores`
--
ALTER TABLE `lectores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_reservas_lectores` (`id_lector`),
  ADD KEY `fk_reservas_libros` (`id_libro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `lectores`
--
ALTER TABLE `lectores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `fk_reservas_lectores` FOREIGN KEY (`id_lector`) REFERENCES `lectores` (`id`),
  ADD CONSTRAINT `fk_reservas_libros` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
