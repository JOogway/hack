-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Maj 2017, 16:55
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `prototyp`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kontakty`
--

CREATE TABLE `kontakty` (
  `id` int(3) NOT NULL,
  `id_uzyt` int(3) NOT NULL,
  `id_znaj` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `status`
--

CREATE TABLE `status` (
  `id_status` int(3) NOT NULL,
  `id_uzytk` int(3) NOT NULL,
  `status_uzyt` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `status_zadl` int(3) NOT NULL,
  `id_znajom` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `id_uzytk` int(3) NOT NULL,
  `imie` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `numer_konta` varchar(26) COLLATE utf8_polish_ci NOT NULL,
  `numer_karty` varchar(16) COLLATE utf8_polish_ci NOT NULL,
  `data_waznosci` varchar(4) COLLATE utf8_polish_ci NOT NULL,
  `3cyfrowy_kod` int(3) NOT NULL,
  `numer_telefonu` varchar(9) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `pesel` varchar(11) COLLATE utf8_polish_ci NOT NULL,
  `stan_konta` varchar(3) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id_uzytk`, `imie`, `nazwisko`, `numer_konta`, `numer_karty`, `data_waznosci`, `3cyfrowy_kod`, `numer_telefonu`, `email`, `pesel`, `stan_konta`) VALUES
(1, 'baza', 'przyklad', '123123123123', '159159159', '1217', 789, '789654123', 'blabla@gmail.com', '98562324557', '27');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `kontakty`
--
ALTER TABLE `kontakty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`id_uzytk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `id_uzytk` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `kontakty`
--
ALTER TABLE `kontakty`
  ADD CONSTRAINT `kontakty_ibfk_1` FOREIGN KEY (`id`) REFERENCES `uzytkownicy` (`id_uzytk`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `status`
--
ALTER TABLE `status`
  ADD CONSTRAINT `status_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `uzytkownicy` (`id_uzytk`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
