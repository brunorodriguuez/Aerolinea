-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-08-2020 a las 23:36:38
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examenfinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE `avion` (
  `IDAvion` int(40) NOT NULL,
  `Nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `avion`
--

INSERT INTO `avion` (`IDAvion`, `Nombre`) VALUES
(1, 'Airbus A300'),
(2, 'Boeing B-737'),
(3, 'Canadair Regional Jet'),
(4, 'Caravelle X'),
(5, 'Douglas DC-2'),
(6, 'Junker JU-52'),
(7, 'Boieng 724'),
(8, 'Boing 987');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IDCliente` int(40) NOT NULL,
  `Nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Direccion` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Telefono` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IDCliente`, `Nombre`, `Direccion`, `Telefono`) VALUES
(1, 'Cliente 1', 'Direccion 1', '+5492235123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `IDFactura` int(50) NOT NULL,
  `MetodoPago` varchar(50) NOT NULL,
  `MontoTotal` double NOT NULL,
  `IDCliente` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`IDFactura`, `MetodoPago`, `MontoTotal`, `IDCliente`) VALUES
(1, 'Efectivo', 96000, 1),
(2, 'Efectivo', 120000, 1),
(3, 'Efectivo', 81393.44, 1),
(4, 'Tarjeta de Debito', 55000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

CREATE TABLE `mantenimiento` (
  `IDMantenimiento` int(40) NOT NULL,
  `Fecha` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Valor` double NOT NULL,
  `Descripcion` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `IDAvion` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `mantenimiento`
--

INSERT INTO `mantenimiento` (`IDMantenimiento`, `Fecha`, `Valor`, `Descripcion`, `IDAvion`) VALUES
(10, '19/7/2020', 500.5, 'Arreglo de Puertas', 3),
(11, '19/07/2020', 405, 'Mantenimiento general', 2),
(12, '19/07/2020', 600.5, 'Reparacion', 7),
(14, '19/07/2020', 10000, 'Reparo General', 8),
(15, '19/07/2020', 5000, 'Limpieza', 8),
(24, '21/07/2020', 100, 'Reparo de 100', 2),
(25, '21/07/2020', 200, 'Reparo de 200', 2),
(26, '21/07/2020', 300, 'Reparo de 300', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ruta`
--

CREATE TABLE `ruta` (
  `IDRuta` int(40) NOT NULL,
  `Origen` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Destino` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `ruta`
--

INSERT INTO `ruta` (`IDRuta`, `Origen`, `Destino`) VALUES
(1, 'Argentina', 'Estados Unidos'),
(2, 'Argentina', 'España'),
(3, 'Argentina', 'Rusia'),
(4, 'Buenos Aires', 'Madrid'),
(5, 'Buenos Aires', 'Chaco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tripulacion`
--

CREATE TABLE `tripulacion` (
  `IDTripulante` int(40) NOT NULL,
  `Nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `Valor_hora` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `tripulacion`
--

INSERT INTO `tripulacion` (`IDTripulante`, `Nombre`, `Valor_hora`) VALUES
(1, 'Elite', 150.5),
(2, 'Premium', 100.4),
(3, 'Silver', 500.4),
(4, 'Bronce', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `IDVenta` int(50) NOT NULL,
  `Fecha` varchar(50) NOT NULL,
  `MontoUnitario` double NOT NULL,
  `IDViaje` int(50) NOT NULL,
  `IDFactura` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`IDVenta`, `Fecha`, `MontoUnitario`, `IDViaje`, `IDFactura`) VALUES
(1, '21/07/2020', 100000, 6, 1),
(2, '21/07/2020', 20000, 9, 1),
(3, '21/07/2020', 30000, 7, 2),
(4, '21/07/2020', 20000, 9, 2),
(5, '21/07/2020', 100000, 6, 2),
(6, '10/08/2020', 50500.4, 3, 3),
(7, '10/08/2020', 31241.4, 5, 3),
(8, '10/08/2020', 20000, 9, 3),
(9, '10/08/2020', 30000, 7, 4),
(10, '10/08/2020', 20000, 9, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `IDViaje` int(40) NOT NULL,
  `ValorViaje` double NOT NULL,
  `IDTripulante` int(11) NOT NULL,
  `IDAvion` int(11) NOT NULL,
  `IDRuta` int(11) NOT NULL,
  `Fecha` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `viaje`
--

INSERT INTO `viaje` (`IDViaje`, `ValorViaje`, `IDTripulante`, `IDAvion`, `IDRuta`, `Fecha`) VALUES
(3, 50500.4, 1, 1, 1, '14/04/2020'),
(5, 31241.4, 1, 5, 2, '12/05/2020'),
(6, 100000, 2, 3, 3, '25/11/2021'),
(7, 30000, 3, 7, 4, '12/09/2022'),
(9, 20000, 4, 8, 5, '25/05/2021');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`IDAvion`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IDCliente`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`IDFactura`,`IDCliente`),
  ADD KEY `IDCliente` (`IDCliente`);

--
-- Indices de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD PRIMARY KEY (`IDMantenimiento`,`IDAvion`),
  ADD KEY `IDAvion` (`IDAvion`);

--
-- Indices de la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`IDRuta`);

--
-- Indices de la tabla `tripulacion`
--
ALTER TABLE `tripulacion`
  ADD PRIMARY KEY (`IDTripulante`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`IDVenta`,`IDViaje`,`IDFactura`),
  ADD KEY `IDViaje` (`IDViaje`),
  ADD KEY `IDFactura` (`IDFactura`);

--
-- Indices de la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`IDViaje`,`IDTripulante`,`IDAvion`,`IDRuta`),
  ADD KEY `IDTripulante` (`IDTripulante`),
  ADD KEY `IDRuta` (`IDRuta`),
  ADD KEY `IDAvion` (`IDAvion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `avion`
--
ALTER TABLE `avion`
  MODIFY `IDAvion` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IDCliente` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `IDFactura` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  MODIFY `IDMantenimiento` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `ruta`
--
ALTER TABLE `ruta`
  MODIFY `IDRuta` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tripulacion`
--
ALTER TABLE `tripulacion`
  MODIFY `IDTripulante` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `IDVenta` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `viaje`
--
ALTER TABLE `viaje`
  MODIFY `IDViaje` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `cliente` (`IDCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD CONSTRAINT `mantenimiento_ibfk_1` FOREIGN KEY (`IDAvion`) REFERENCES `avion` (`IDAvion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`IDViaje`) REFERENCES `viaje` (`IDViaje`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`IDFactura`) REFERENCES `factura` (`IDFactura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `viaje_ibfk_1` FOREIGN KEY (`IDTripulante`) REFERENCES `tripulacion` (`IDTripulante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `viaje_ibfk_2` FOREIGN KEY (`IDRuta`) REFERENCES `ruta` (`IDRuta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `viaje_ibfk_3` FOREIGN KEY (`IDAvion`) REFERENCES `avion` (`IDAvion`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
