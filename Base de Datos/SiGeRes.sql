-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.26-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para sigeres
CREATE DATABASE IF NOT EXISTS `sigeres` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sigeres`;


-- Volcando estructura para tabla sigeres.articulos
CREATE TABLE IF NOT EXISTS `articulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_marca` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  `id_grupo` int(11) DEFAULT NULL,
  `id_subgrupo` int(11) DEFAULT NULL,
  `codigo` varchar(20) NOT NULL,
  `codigobarra` varchar(25) DEFAULT NULL,
  `descripcion` varchar(50) NOT NULL,
  `impuesto` double NOT NULL,
  `preciocompra` double NOT NULL,
  `preciobase` double NOT NULL,
  `medida1` double DEFAULT NULL,
  `medida2` double DEFAULT NULL,
  `medida3` double DEFAULT NULL,
  `medida4` double DEFAULT NULL,
  `unidadmedida1` varchar(20) DEFAULT NULL,
  `unidadmedida2` varchar(20) DEFAULT NULL,
  `unidadmedida3` varchar(20) DEFAULT NULL,
  `unidadmedida4` varchar(20) DEFAULT NULL,
  `aplicacion` varchar(100) DEFAULT NULL,
  `imagen` binary(1) DEFAULT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `codigobarra` (`codigobarra`),
  KEY `estado` (`estado`),
  KEY `FK_Articulo_Proveedor` (`id_proveedor`),
  KEY `FK_Articulo_grupo` (`id_grupo`),
  KEY `FK_Articulo_Subgrupo` (`id_subgrupo`),
  KEY `FK_Articulo_Marca` (`id_marca`),
  CONSTRAINT `FK_Articulo_Marca` FOREIGN KEY (`id_marca`) REFERENCES `marcas` (`id`),
  CONSTRAINT `FK_Articulo_Proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`),
  CONSTRAINT `FK_Articulo_Subgrupo` FOREIGN KEY (`id_subgrupo`) REFERENCES `sub_grupos` (`id`),
  CONSTRAINT `FK_Articulo_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.articulos: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT IGNORE INTO `articulos` (`id`, `id_marca`, `id_proveedor`, `id_grupo`, `id_subgrupo`, `codigo`, `codigobarra`, `descripcion`, `impuesto`, `preciocompra`, `preciobase`, `medida1`, `medida2`, `medida3`, `medida4`, `unidadmedida1`, `unidadmedida2`, `unidadmedida3`, `unidadmedida4`, `aplicacion`, `imagen`, `estado`) VALUES
	(1, NULL, NULL, NULL, NULL, 'articuloprueba', '02162431', 'articulo de prueba ', 10, 10000, 15000, 15, NULL, NULL, NULL, 'centimetro', '', '', '', 'toyota', NULL, 'ACTIVO'),
	(2, NULL, NULL, NULL, NULL, 'pe046', '8431684315', 'Penta Pedra', 10, 50000, 70000, NULL, NULL, NULL, NULL, '', '', '', '', '', NULL, 'ACTIVO');
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.ciudades
CREATE TABLE IF NOT EXISTS `ciudades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_departamento` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `estado` (`estado`),
  KEY `FK_Ciudad_Departamento` (`id_departamento`),
  CONSTRAINT `FK_Ciudad_Departamento` FOREIGN KEY (`id_departamento`) REFERENCES `departamentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.ciudades: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT IGNORE INTO `ciudades` (`id`, `id_departamento`, `descripcion`, `estado`) VALUES
	(1, 1, 'Lambare', 'ACTIVO'),
	(2, 1, 'Asuncion', 'ACTIVO'),
	(3, 4, 'Una Ciudad', 'ACTIVO'),
	(4, 4, 'Ciudad Prueba', 'INACTIVO');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipocliente` int(11) NOT NULL,
  `codigo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `razonSocial` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nombreFantasia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombreContacto` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `ruc` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `celular` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contacto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_formapago` int(11) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `id_listaprecio` int(11) NOT NULL,
  `limiteCredito` double DEFAULT NULL,
  `estado` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Cliente_Ciudad` (`id_ciudad`),
  KEY `FK_Cliente_Departamento` (`id_departamento`),
  KEY `FK_Cliente_ListaPrecio` (`id_listaprecio`),
  KEY `codigo` (`codigo`),
  KEY `estado` (`estado`),
  KEY `razonsocial` (`razonSocial`),
  KEY `nombrefantasia` (`nombreFantasia`),
  KEY `ruc` (`ruc`),
  KEY `nombrecontacto` (`nombreContacto`),
  KEY `FK_Cliente_FormaPago` (`id_formapago`),
  KEY `FK_Clietne_TipoCliente` (`id_tipocliente`),
  CONSTRAINT `FK_Cliente_Ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudades` (`id`),
  CONSTRAINT `FK_Cliente_Departamento` FOREIGN KEY (`id_departamento`) REFERENCES `departamentos` (`id`),
  CONSTRAINT `FK_Cliente_FormaPago` FOREIGN KEY (`id_formapago`) REFERENCES `formas_pagos` (`id`),
  CONSTRAINT `FK_Cliente_ListaPrecio` FOREIGN KEY (`id_listaprecio`) REFERENCES `listas_precios` (`id`),
  CONSTRAINT `FK_Clietne_TipoCliente` FOREIGN KEY (`id_tipocliente`) REFERENCES `tipos_clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla sigeres.clientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.departamentos
CREATE TABLE IF NOT EXISTS `departamentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `descripcion` (`descripcion`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.departamentos: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT IGNORE INTO `departamentos` (`id`, `descripcion`, `estado`) VALUES
	(1, 'Central', 'ACTIVO'),
	(2, 'prueba', 'INACTIVO'),
	(3, 'Limpio', 'ACTIVO'),
	(4, 'Roque Alonzo', 'ACTIVO'),
	(5, 'Prueba', 'INACTIVO');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.depositos
CREATE TABLE IF NOT EXISTS `depositos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.depositos: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `depositos` DISABLE KEYS */;
INSERT IGNORE INTO `depositos` (`id`, `descripcion`, `estado`) VALUES
	(1, 'PREUBA', 'INACTIVO'),
	(2, 'Deposito A', 'ACTIVO'),
	(3, 'Deposito B', 'ACTIVO'),
	(4, 'Deposito C', 'INACTIVO'),
	(5, 'asdfa', 'INACTIVO'),
	(6, 'asfdasf', 'ACTIVO'),
	(7, 'asdfasf', 'ACTIVO'),
	(8, 'asdfasdfa', 'ACTIVO'),
	(9, 'asfasdf', 'ACTIVO'),
	(10, 'asdfasfd', 'ACTIVO'),
	(11, 'afdasdf', 'ACTIVO'),
	(12, 'Deposito C', 'ACTIVO'),
	(13, 'Deposito B', 'ACTIVO');
/*!40000 ALTER TABLE `depositos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.existencias
CREATE TABLE IF NOT EXISTS `existencias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_deposito` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `bloque` varchar(20) DEFAULT NULL,
  `sector` varchar(20) DEFAULT NULL,
  `fila` varchar(20) DEFAULT NULL,
  `codigoidentificador` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Existencia_Articulo` (`id_articulo`),
  KEY `FK_Existencia_Deposito` (`id_deposito`),
  CONSTRAINT `FK_Existencia_Articulo` FOREIGN KEY (`id_articulo`) REFERENCES `articulos` (`id`),
  CONSTRAINT `FK_Existencia_Deposito` FOREIGN KEY (`id_deposito`) REFERENCES `depositos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.existencias: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `existencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `existencias` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.factura_compra
CREATE TABLE IF NOT EXISTS `factura_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_factura` varchar(20) DEFAULT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_factura` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total` double NOT NULL,
  `saldo` double NOT NULL,
  `estado` varchar(20) NOT NULL,
  `timbrado` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.factura_compra: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `factura_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura_compra` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.grupos
CREATE TABLE IF NOT EXISTS `grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `codigo` (`codigo`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.grupos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.marcas
CREATE TABLE IF NOT EXISTS `marcas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `codigo` (`codigo`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.marcas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.pagos
CREATE TABLE IF NOT EXISTS `pagos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monto` double NOT NULL,
  `motivo` varchar(100) DEFAULT NULL,
  `transaccion` varchar(50) NOT NULL,
  `id_TipoTransaccion` int(11) NOT NULL,
  `estado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.pagos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.pedidos_compras
CREATE TABLE IF NOT EXISTS `pedidos_compras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(50) NOT NULL DEFAULT 'ACTIVO',
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_proveedor` int(11) NOT NULL,
  `fecha_entrega` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `estado` (`estado`),
  KEY `FK_PedidoCompra_Proveedor` (`id_proveedor`),
  KEY `FK_PedidoCompra_Usuario` (`id_usuario`),
  CONSTRAINT `FK_PedidoCompra_Proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`),
  CONSTRAINT `FK_PedidoCompra_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.pedidos_compras: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `pedidos_compras` DISABLE KEYS */;
INSERT IGNORE INTO `pedidos_compras` (`id`, `estado`, `fecha`, `id_proveedor`, `fecha_entrega`, `id_usuario`) VALUES
	(2, 'ACTIVO', '2015-09-28 16:32:55', 1, '2015-09-29', 2),
	(3, 'PRESUPUESTADO', '2015-09-28 16:41:53', 1, '2015-09-29', 2);
/*!40000 ALTER TABLE `pedidos_compras` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.pedido_compra_detalle
CREATE TABLE IF NOT EXISTS `pedido_compra_detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL DEFAULT '0',
  `id_articulo` int(11) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL DEFAULT '0',
  `precio` double NOT NULL DEFAULT '0',
  `presentacion` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_Pedido_Detalle_Articulo` (`id_articulo`),
  KEY `FK_Pedido_Detalle_Pedido_Compra` (`id_pedido`),
  CONSTRAINT `FK_Pedido_Detalle_Articulo` FOREIGN KEY (`id_articulo`) REFERENCES `articulos` (`id`),
  CONSTRAINT `FK_Pedido_Detalle_Pedido_Compra` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos_compras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.pedido_compra_detalle: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido_compra_detalle` DISABLE KEYS */;
INSERT IGNORE INTO `pedido_compra_detalle` (`id`, `id_pedido`, `id_articulo`, `cantidad`, `precio`, `presentacion`) VALUES
	(1, 2, 1, 10, 0, 0);
/*!40000 ALTER TABLE `pedido_compra_detalle` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.permisos
CREATE TABLE IF NOT EXISTS `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.permisos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_ciudad` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `razonsocial` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `celular` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.proveedores: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT IGNORE INTO `proveedores` (`id`, `id_ciudad`, `id_departamento`, `codigo`, `razonsocial`, `telefono`, `celular`, `estado`) VALUES
	(1, 1, 1, 'pro1', 'Proveedor Prueba', '12346', '123456', 'ACTIVO'),
	(2, 1, 1, 'Pro', '<h1>holaaaa</h1>', '123456', '65489', 'ACTIVO');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.sub_grupos
CREATE TABLE IF NOT EXISTS `sub_grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `codigo` (`codigo`),
  KEY `estado` (`estado`),
  KEY `FK_GRUPO` (`id_grupo`),
  CONSTRAINT `FK_GRUPO` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.sub_grupos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sub_grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_grupos` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.tipos_clientes
CREATE TABLE IF NOT EXISTS `tipos_clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.tipos_clientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_clientes` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.tipos_usuarios
CREATE TABLE IF NOT EXISTS `tipos_usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_permiso` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `chkinventario` int(4) NOT NULL,
  `chkfacturacion` int(4) NOT NULL,
  `chkcaja` int(4) NOT NULL,
  `chkcompra` int(4) NOT NULL,
  `chkseguridad` int(4) NOT NULL,
  `chkventa` int(4) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sigeres.tipos_usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipos_usuarios` DISABLE KEYS */;
INSERT IGNORE INTO `tipos_usuarios` (`id`, `id_permiso`, `codigo`, `descripcion`, `chkinventario`, `chkfacturacion`, `chkcaja`, `chkcompra`, `chkseguridad`, `chkventa`, `estado`) VALUES
	(1, 1, 'admin', 'administrador', 1, 1, 1, 1, 1, 1, '1');
/*!40000 ALTER TABLE `tipos_usuarios` ENABLE KEYS */;


-- Volcando estructura para tabla sigeres.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `id_tipousuario` int(20) DEFAULT NULL,
  `id_deposito` int(11) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `photo` binary(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `id` (`id`),
  KEY `estado` (`estado`),
  KEY `FK_Usuario_TipoUsuario` (`id_tipousuario`),
  KEY `FK_Usuario_deposito` (`id_deposito`),
  CONSTRAINT `FK_Usuario_TipoUsuario` FOREIGN KEY (`id_tipousuario`) REFERENCES `tipos_usuarios` (`id`),
  CONSTRAINT `FK_Usuario_deposito` FOREIGN KEY (`id_deposito`) REFERENCES `depositos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabla de usuarios para el sistema';

-- Volcando datos para la tabla sigeres.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT IGNORE INTO `usuarios` (`id`, `codigo`, `nombre`, `apellido`, `clave`, `id_tipousuario`, `id_deposito`, `estado`, `photo`) VALUES
	(2, 'cgernoffer', 'Christian', 'Gernoffer', '123', 1, 1, 'ACTIVO', NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
