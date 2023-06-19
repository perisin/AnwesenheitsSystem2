-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 16. Jun 2023 um 16:17
-- Server-Version: 10.4.28-MariaDB
-- PHP-Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `anwesensheitssystem`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `break`
--

CREATE TABLE `break` (
  `breakID` int(11) NOT NULL,
  `breakStart` timestamp NOT NULL DEFAULT current_timestamp(),
  `breakEnd` timestamp NOT NULL DEFAULT current_timestamp(),
  `shiftID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `employee`
--

CREATE TABLE `employee` (
  `employeeID` int(99) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `is_Admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `employee`
--

INSERT INTO `employee` (`employeeID`, `firstName`, `lastName`, `password`, `is_Admin`) VALUES
(1, 'vladin', 'Put in', 'out', 0),
(2, 'alller', 'esh', 'psword', 0),
(3, 'aldin', 'ist krank', 'abc', 0),
(6, 'firstName', 'sheesh', 'pasword', 0),
(7, 'admin', 'person', 'password', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `shift`
--

CREATE TABLE `shift` (
  `shiftID` int(100) NOT NULL,
  `shiftStart` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `shiftEnd` timestamp(6) NOT NULL DEFAULT current_timestamp(6),
  `employeeID` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indizes für die Tabelle `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`shiftID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
