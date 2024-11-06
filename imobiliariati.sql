-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 06, 2024 at 05:02 PM
-- Server version: 8.3.0
-- PHP Version: 8.1.2-1ubuntu2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imobiliariati`
--

CREATE DATABASE `imobiliariati`;

USE `imobiliariati`;

-- --------------------------------------------------------

--
-- Table structure for table `imagens`
--

CREATE TABLE `imagens` (
  `id_imagem` int NOT NULL,
  `id_imovel` int NOT NULL,
  `nome_arquivo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `imobiliarias`
--

CREATE TABLE `imobiliarias` (
  `id_imobiliaria` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `cnpj` varchar(20) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `imoveis`
--

CREATE TABLE `imoveis` (
  `id_imovel` int NOT NULL,
  `id_imobiliaria` int DEFAULT NULL,
  `id_subtipo` int NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `tamanho` decimal(10,2) NOT NULL,
  `quartos` int DEFAULT NULL,
  `suites` int DEFAULT NULL,
  `vagas` int DEFAULT NULL,
  `banheiros` int DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `taxa_condominio` decimal(10,2) DEFAULT NULL,
  `iptu` decimal(10,2) DEFAULT NULL,
  `tipo_negocio` varchar(255) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `descricao` longtext,
  `status_imovel` enum('Available','Unavailable','Sold','Rented') NOT NULL DEFAULT 'Available'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subtipos`
--

CREATE TABLE `subtipos` (
  `id_subtipo` int NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `imagens`
--
ALTER TABLE `imagens`
  ADD PRIMARY KEY (`id_imagem`);

--
-- Indexes for table `imobiliarias`
--
ALTER TABLE `imobiliarias`
  ADD PRIMARY KEY (`id_imobiliaria`),
  ADD UNIQUE KEY `cnpj` (`cnpj`),
  ADD UNIQUE KEY `unique_cnpj` (`cnpj`);

--
-- Indexes for table `imoveis`
--
ALTER TABLE `imoveis`
  ADD PRIMARY KEY (`id_imovel`),
  ADD KEY `id_imobiliaria` (`id_imobiliaria`),
  ADD KEY `id_subtipo` (`id_subtipo`);

--
-- Indexes for table `subtipos`
--
ALTER TABLE `subtipos`
  ADD PRIMARY KEY (`id_subtipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `imagens`
--
ALTER TABLE `imagens`
  MODIFY `id_imagem` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imobiliarias`
--
ALTER TABLE `imobiliarias`
  MODIFY `id_imobiliaria` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imoveis`
--
ALTER TABLE `imoveis`
  MODIFY `id_imovel` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subtipos`
--
ALTER TABLE `subtipos`
  MODIFY `id_subtipo` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `imoveis`
--
ALTER TABLE `imoveis`
  ADD CONSTRAINT `imoveis_ibfk_1` FOREIGN KEY (`id_imobiliaria`) REFERENCES `imobiliarias` (`id_imobiliaria`),
  ADD CONSTRAINT `imoveis_ibfk_3` FOREIGN KEY (`id_subtipo`) REFERENCES `subtipos` (`id_subtipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;