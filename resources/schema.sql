-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 26, 2026 at 02:40 PM
-- Server version: 8.0.46
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proiect_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresa`
--

CREATE TABLE `adresa` (
  `id` bigint NOT NULL,
  `nume_strada` varchar(200) NOT NULL,
  `nr_strada` int NOT NULL,
  `cod_postal` int NOT NULL,
  `nr_apartament` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `angajat`
--

CREATE TABLE `angajat` (
  `id` bigint NOT NULL,
  `nume` varchar(200) NOT NULL,
  `prenume` varchar(200) NOT NULL,
  `nr_telefon` varchar(20) DEFAULT NULL,
  `salariu` decimal(12,2) NOT NULL,
  `este_curier` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `card_fidelitate`
--

CREATE TABLE `card_fidelitate` (
  `id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  `nr_produse_introduse` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `card_reducere`
--

CREATE TABLE `card_reducere` (
  `card_id` bigint NOT NULL,
  `reducere_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` bigint NOT NULL,
  `nume` varchar(200) NOT NULL,
  `prenume` varchar(200) NOT NULL,
  `nr_telefon` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `parola` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `client_adresa`
--

CREATE TABLE `client_adresa` (
  `client_id` bigint NOT NULL,
  `adresa_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `comanda`
--

CREATE TABLE `comanda` (
  `id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  `adresa_livrare_id` bigint DEFAULT NULL,
  `curier_id` bigint DEFAULT NULL,
  `locatie_id` bigint DEFAULT NULL,
  `data_plasare` datetime NOT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `comanda_produs`
--

CREATE TABLE `comanda_produs` (
  `comanda_id` bigint NOT NULL,
  `produs_id` bigint NOT NULL,
  `cantitate` bigint NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

CREATE TABLE `ingredient` (
  `id` bigint NOT NULL,
  `nume` varchar(200) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `stoc` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `locatie`
--

CREATE TABLE `locatie` (
  `id` bigint NOT NULL,
  `adresa_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `locatie_angajat`
--

CREATE TABLE `locatie_angajat` (
  `locatie_id` bigint NOT NULL,
  `angajat_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `produs`
--

CREATE TABLE `produs` (
  `id` bigint NOT NULL,
  `denumire` varchar(200) NOT NULL,
  `pret` decimal(12,2) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `discount_procent` decimal(5,2) DEFAULT '0.00',
  `popularitate` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `produs_ingredient`
--

CREATE TABLE `produs_ingredient` (
  `produs_id` bigint NOT NULL,
  `ingredient_id` bigint NOT NULL,
  `cantitate` bigint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `reducere`
--

CREATE TABLE `reducere` (
  `id` bigint NOT NULL,
  `descriere` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresa`
--
ALTER TABLE `adresa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `angajat`
--
ALTER TABLE `angajat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `card_fidelitate`
--
ALTER TABLE `card_fidelitate`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `client_id` (`client_id`);

--
-- Indexes for table `card_reducere`
--
ALTER TABLE `card_reducere`
  ADD PRIMARY KEY (`card_id`,`reducere_id`),
  ADD KEY `reducere_id` (`reducere_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `client_adresa`
--
ALTER TABLE `client_adresa`
  ADD PRIMARY KEY (`client_id`,`adresa_id`),
  ADD KEY `adresa_id` (`adresa_id`);

--
-- Indexes for table `comanda`
--
ALTER TABLE `comanda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `adresa_livrare_id` (`adresa_livrare_id`),
  ADD KEY `curier_id` (`curier_id`),
  ADD KEY `locatie_id` (`locatie_id`);

--
-- Indexes for table `comanda_produs`
--
ALTER TABLE `comanda_produs`
  ADD PRIMARY KEY (`comanda_id`,`produs_id`),
  ADD KEY `produs_id` (`produs_id`);

--
-- Indexes for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `locatie`
--
ALTER TABLE `locatie`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `adresa_id` (`adresa_id`);

--
-- Indexes for table `locatie_angajat`
--
ALTER TABLE `locatie_angajat`
  ADD PRIMARY KEY (`locatie_id`,`angajat_id`),
  ADD KEY `angajat_id` (`angajat_id`);

--
-- Indexes for table `produs`
--
ALTER TABLE `produs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produs_ingredient`
--
ALTER TABLE `produs_ingredient`
  ADD PRIMARY KEY (`produs_id`,`ingredient_id`),
  ADD KEY `ingredient_id` (`ingredient_id`);

--
-- Indexes for table `reducere`
--
ALTER TABLE `reducere`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adresa`
--
ALTER TABLE `adresa`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `angajat`
--
ALTER TABLE `angajat`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `card_fidelitate`
--
ALTER TABLE `card_fidelitate`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comanda`
--
ALTER TABLE `comanda`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `locatie`
--
ALTER TABLE `locatie`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produs`
--
ALTER TABLE `produs`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reducere`
--
ALTER TABLE `reducere`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `card_fidelitate`
--
ALTER TABLE `card_fidelitate`
  ADD CONSTRAINT `card_fidelitate_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Constraints for table `card_reducere`
--
ALTER TABLE `card_reducere`
  ADD CONSTRAINT `card_reducere_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `card_fidelitate` (`id`),
  ADD CONSTRAINT `card_reducere_ibfk_2` FOREIGN KEY (`reducere_id`) REFERENCES `reducere` (`id`);

--
-- Constraints for table `client_adresa`
--
ALTER TABLE `client_adresa`
  ADD CONSTRAINT `client_adresa_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `client_adresa_ibfk_2` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`id`);

--
-- Constraints for table `comanda`
--
ALTER TABLE `comanda`
  ADD CONSTRAINT `comanda_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `comanda_ibfk_2` FOREIGN KEY (`adresa_livrare_id`) REFERENCES `adresa` (`id`),
  ADD CONSTRAINT `comanda_ibfk_3` FOREIGN KEY (`curier_id`) REFERENCES `angajat` (`id`),
  ADD CONSTRAINT `comanda_ibfk_4` FOREIGN KEY (`locatie_id`) REFERENCES `locatie` (`id`);

--
-- Constraints for table `comanda_produs`
--
ALTER TABLE `comanda_produs`
  ADD CONSTRAINT `comanda_produs_ibfk_1` FOREIGN KEY (`comanda_id`) REFERENCES `comanda` (`id`),
  ADD CONSTRAINT `comanda_produs_ibfk_2` FOREIGN KEY (`produs_id`) REFERENCES `produs` (`id`);

--
-- Constraints for table `locatie`
--
ALTER TABLE `locatie`
  ADD CONSTRAINT `locatie_ibfk_1` FOREIGN KEY (`adresa_id`) REFERENCES `adresa` (`id`);

--
-- Constraints for table `locatie_angajat`
--
ALTER TABLE `locatie_angajat`
  ADD CONSTRAINT `locatie_angajat_ibfk_1` FOREIGN KEY (`locatie_id`) REFERENCES `locatie` (`id`),
  ADD CONSTRAINT `locatie_angajat_ibfk_2` FOREIGN KEY (`angajat_id`) REFERENCES `angajat` (`id`);

--
-- Constraints for table `produs_ingredient`
--
ALTER TABLE `produs_ingredient`
  ADD CONSTRAINT `produs_ingredient_ibfk_1` FOREIGN KEY (`produs_id`) REFERENCES `produs` (`id`),
  ADD CONSTRAINT `produs_ingredient_ibfk_2` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
