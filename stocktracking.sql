-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2022 a las 01:58:20
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `stocktracking`
--

DROP DATABASE stocktracking;

CREATE DATABASE stocktracking;
USE stocktracking;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(254) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  `Descripcion` varchar(80) NOT NULL,
  `Cantidad` int(254) NOT NULL,
  `Unidad` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `Nombre`, `Descripcion`, `Cantidad`, `Unidad`) VALUES
(1, 'ACEITE BOMBA VACIO x 5lts', '', 10, 'Litro'),
(2, 'ADENITIS EQUINA x 10 Ds', '', 14, 'Botella'),
(3, 'AGITA 10 WG x 400 grs', '', 2, 'Botella'),
(4, 'AGUJAS HIPOD. ACERO', '', 348, 'Dispositivo'),
(5, 'AGUJAS HIPODERMICAS Medidas Varias', '', 6, 'Dispositivo'),
(6, 'AQ30 X 22Kg (ACIDO PERACETICO)', '', 44, 'Mililitros'),
(7, 'ARMOR Sellador Barrera (1 Lts)', '', 1200, 'Litro'),
(8, 'ARRASA x 5 lts', '', 10, 'Dispositivo'),
(9, 'BAGO ADE3E Fsco X 250 CC', '', 4, 'Botella'),
(10, 'Boyero 220-12 volt. De 35Km', '', 1, 'Dispositivo'),
(11, 'BUSCAPINA COMPUESTA - Frasco x 50ml', '', 4, 'Botella'),
(12, 'BYKAHEPAR Fco x 100cc', '', 13, 'Botella'),
(13, 'Calierxicam', '', 6, 'Botella'),
(14, 'Camisas Sanitarias', '', 10, 'Dispositivo'),
(15, 'CARAV. ALLFLEX TAMPER MAXI S/N', '', 100, 'Dispositivo'),
(16, 'Caravanas Amarrillas Grandes S/N', '', 400, 'Dispositivo'),
(17, 'CARAVANAS SENASA DP- Celestes', '', 300, 'Dispositivo'),
(18, 'CARAVANAS VERDES GRANDES S/N', '', 250, 'Dispositivo'),
(19, 'Cefaximin (mast?tis)', '', 63, 'Tubo'),
(20, 'Ceftion Frasco x100cc', '', 1180, 'Mililitros'),
(21, '', '', 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(254) NOT NULL,
  `nombre` varchar(254) NOT NULL,
  `apellido` varchar(254) NOT NULL,
  `email` varchar(254) NOT NULL,
  `edad` int(254) NOT NULL,
  `rol` tinyint(1) DEFAULT 0,
  `password` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `email`, `edad`, `rol`, `password`) VALUES
(1, 'Waldo', 'Cuevas', 'Waldo@gmail.com', 24, 1, '1234'),
(2, 'Alejandro', 'Dalzotto', 'ale@gmail.com', 20, 0, '12345');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(254) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(254) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
