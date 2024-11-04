-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 04, 2024 at 08:32 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `imagens`
--

CREATE TABLE `imagens` (
  `id_imagem` int NOT NULL,
  `id_imovel` int NOT NULL,
  `nome_arquivo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `imagens`
--

INSERT INTO `imagens` (`id_imagem`, `id_imovel`, `nome_arquivo`) VALUES
(54, 1, '1_1920x1080-px-Castlevania-Castlevania-Lords-of-Shadow-1309603-wallhere.com.jpg'),
(55, 14, '14_sc8969.png'),
(56, 27, '27_sc88i3.jpg'),
(57, 27, '27_sc8968.png'),
(58, 29, '29_city-big.png'),
(59, 29, '29_big-blizard.png'),
(60, 29, '29_wallpaperflare.com_wallpaper (6).jpg'),
(61, 29, '29_1600x900_px_Bloodstained_Ritual_Of_The_Night_fantasy_Art_Miriam_Bloodstained_video_games-691438.jpg'),
(62, 29, '29_42dgnmdfcw311.png'),
(63, 29, '29_wallpaperflare.com_wallpaper (11).jpg');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `imobiliarias`
--

INSERT INTO `imobiliarias` (`id_imobiliaria`, `nome`, `email`, `telefone`, `cnpj`, `senha`) VALUES
(1, 'Imobiliaria Teste', 'teste@email.com', '+55 (11) 11111-1113', '82.997.817/0001-40', 'teste123'),
(3, 'maloi', 'mala@email.com', '+55 (11) 11111-1112', '18.321.826/0001-18', 'maloi123'),
(4, 'miojooi', 'miojooi@email.com', '+55 (40) 11111-1113', '35.062.399/0001-10', 'miojooi123'),
(5, 'meiopaia', 'meiopaia@mail.com', '+55 (34) 43232-1332', '78.903.412/3553-24', 'meiopaia123'),
(6, 'Lola', 'lola@email.com', '+55 (44) 44444-4444', '13.131.313/1313-13', 'lola123'),
(7, 'imobiliaria', 'imobiliaria@mail.com', '+55 (11) 11111-1111', '11.111.111/1111-11', 'imobiliaria123'),
(8, 'xampp', 'xampp@email.com', '+55 (11) 98765-4321', '55.776.008/0001-36', 'xampp123');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `imoveis`
--

INSERT INTO `imoveis` (`id_imovel`, `id_imobiliaria`, `id_subtipo`, `tipo`, `tamanho`, `quartos`, `suites`, `vagas`, `banheiros`, `valor`, `taxa_condominio`, `iptu`, `tipo_negocio`, `bairro`, `cidade`, `endereco`, `cep`, `descricao`, `status_imovel`) VALUES
(1, 1, 6, 'Casa', 120.00, 2, 2, 2, 2, 12312112.00, 0.00, 1231212.00, 'Venda', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_12', '01001-000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium. Suspendisse elementum orci id congue feugiat. Maecenas felis felis, varius at metus non, convallis vestibulum neque. Curabitur venenatis non nisi ac fermentum. Duis facilisis ac nibh quis convallis. Integer venenatis enim quis eros blandit tincidunt. Sed venenatis lorem tristique libero bibendum, eget aliquet enim pulvinar. Maecenas in pulvinar nibh, eu pharetra quam. Quisque ullamcorper arcu in quam sollicitudin bibendum.', 'Available'),
(2, 3, 2, 'Apartamento', 134.00, 2, 3, 2, 2, 12312.12, 123.12, 12312.12, 'Locação', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_13', '01001-000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium. Suspendisse elementum orci id congue feugiat. Maecenas felis felis, varius at metus non, convallis vestibulum neque. Curabitur venenatis non nisi ac fermentum. Duis facilisis ac nibh quis convallis. Integer venenatis enim quis eros blandit tincidunt. Sed venenatis lorem tristique libero bibendum, eget aliquet enim pulvinar. Maecenas in pulvinar nibh, eu pharetra quam. Quisque ullamcorper arcu in quam sollicitudin bibendum.', 'Unavailable'),
(3, 1, 9, 'Terreno', 1230.00, 1, 1, 1, 1, 1231212.00, 0.00, 0.00, 'Venda', 'Centenário', 'Boa Vista', 'Boa Vista_Centenário_Rua Santo Agostinho_123', '69312-490', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium.', 'Available'),
(5, 3, 8, 'Terreno', 1230.00, 0, 0, 0, 0, 12323.12, 0.00, 0.00, 'Venda', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_123', '01001-000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium.', 'Available'),
(8, 4, 8, 'Terreno', 1230.00, 0, 0, 0, 0, 12312.12, 0.00, 0.00, 'Venda', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_123', '01001-000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium.', 'Available'),
(9, 6, 9, 'Terreno', 1230.00, 0, 0, 0, 0, 123123.12, 0.00, 0.00, 'Venda', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_123', '01001-000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium.', 'Available'),
(10, 5, 9, 'Terreno', 15230.00, 0, 0, 0, 0, 123132.12, 0.00, 0.00, 'Venda', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_123', '01001-000', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices neque vitae quam euismod faucibus. Suspendisse nisi magna, efficitur eget velit eu, interdum pharetra neque. Etiam scelerisque consequat congue. Pellentesque elementum augue sit amet rhoncus pretium.', 'Available'),
(12, 7, 8, 'Terreno', 153.00, 2, 2, 3, 3, 50000000.00, 0.00, 500000.00, 'Venda', 'Sé', 'São Paulo', 'São Paulo_Sé_Praça da Sé_13', '01001-000', '', 'Available'),
(13, 7, 1, 'Apartamento', 152.00, 5, 4, 2, 3, 123.00, 21.00, 123.00, 'Alugel', 'Gisélia Pinheiro', 'Crato', 'Crato_Gisélia Pinheiro_Rodovia CE _ 292_32', '63115-500', 'Apartamento aluguel muito legal bacaninha', 'Available'),
(14, 1, 5, 'Casa', 120.00, 2, 2, 2, 2, 123.00, 12.00, 12.00, 'Venda', 'Alto Alegre II', 'Maracanaú', 'Maracanaú_Alto Alegre II_Travessa 10_123', '61921-515', 'A sei lá mano, já não aguento mais', 'Available'),
(16, 1, 5, 'Casa', 121.00, 3, 3, 3, 3, 12312.12, 0.00, 123.12, 'Venda', 'Guaribas', 'Arapiraca', 'Arapiraca_Guaribas_Rua Alfredo Soares da Masena_123', '57303-728', 'Lorem Ipsum dolor sit amet!!!!', 'Available'),
(17, 1, 6, 'Casa', 120.00, 2, 3, 2, 3, 12312.12, 0.00, 12312.12, 'Venda', 'Mangueirão', 'Belém', 'Belém_Mangueirão_Rua D_13', '66640-558', 'Lorem Ipsum dolor sit amet!!! O ftp do infinty free vai funcionar, pfv eu espero!!!', 'Available'),
(27, 1, 5, 'Casa', 10.00, 1, 1, 1, 1, 123.00, 123.00, 123.00, 'Alugel', 'Loteamento Belo Horizonte', 'Barra Mansa', 'Barra Mansa_Loteamento Belo Horizonte_Rua J_123', '27320-340', 'Lorem ipsum dolor sit amet', 'Available'),
(28, 8, 5, 'Casa', 20.00, 1, 2, 3, 2, 1234512.00, 12312.00, 123412.00, 'Alugel', 'Conjunto Habitacional Dom Constantino Amstalden', 'São Carlos', 'São Carlos_Conjunto Habitacional Dom Constantino Amstalden_Rua Doutor Nelson Fonseca_8', '13568-829', 'Minha casa para alugar muito legal, ela tem condomínio e muito bem bonita ornamentada, eu sei escrever e esta é uma descrição muito linda, bacana legal e bunita', 'Available'),
(29, 8, 5, 'Casa', 121.00, 3, 3, 3, 3, 12345.12, 123.12, 1234.12, 'Alugel', 'Eucaliptal', 'Volta Redonda', 'Volta Redonda-Eucaliptal-Rua Vereador Raymundo Diogo-89', '27263-211', 'Minha casa condomínio legal, bem localizada, muito bacana e legal, barata, eu compraria se fosse você, ela é bem bonita e legal, compra aí mano na moral. Lorem ipsum dolor sit amet', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `subtipos`
--

CREATE TABLE `subtipos` (
  `id_subtipo` int NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `subtipos`
--

INSERT INTO `subtipos` (`id_subtipo`, `nome`) VALUES
(1, 'Apartamento_Cobertura'),
(2, 'Apartamento_Flat'),
(3, 'Apartamento_Ktinet'),
(4, 'Apartamento_Loft'),
(5, 'Casa_Condomínio'),
(6, 'Casa_Sobrado'),
(7, 'Casa_de_Vila'),
(8, 'Terreno_Chácara'),
(9, 'Terreno_Fazenda'),
(10, 'Terreno_Padrão'),
(11, 'Loteamento/Condomínio');

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
  MODIFY `id_imagem` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `imobiliarias`
--
ALTER TABLE `imobiliarias`
  MODIFY `id_imobiliaria` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `imoveis`
--
ALTER TABLE `imoveis`
  MODIFY `id_imovel` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `subtipos`
--
ALTER TABLE `subtipos`
  MODIFY `id_subtipo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
