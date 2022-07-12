-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2022 at 10:17 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` varchar(255) NOT NULL,
  `description` text,
  `pages` bigint(20) DEFAULT NULL,
  `published_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `description`, `pages`, `published_date`, `title`) VALUES
('7k6fDAAAQBAJ', NULL, 336, '2016-12-06', 'Rest'),
('fE5aMQAACAAJ', NULL, 385, '2017-07-15', 'Pro RESTful APIs'),
('XZebDwAAQBAJ', 'Shortlisted for the British Psychological Society Book Award for Popular Science Much of value has been written about sleep, but rest is different; it is how we unwind, calm our minds and recharge our bodies. The Art of Rest draws on ground-breaking research Claudia Hammond collaborated on: ‘The Rest Test’, the largest global survey into rest ever undertaken, completed by 18,000 people across 135 different countries. The survey revealed how people get rest and how it is directly linked to your sense of wellbeing. Counting down through the top ten activities which people find most restful, Hammond explains why rest matters, examines the science behind the results to establish what really works and offers a roadmap for a new, more restful and balanced life.', 304, '2019-11-21', 'The Art of Rest');

-- --------------------------------------------------------

--
-- Table structure for table `book_author_list`
--

CREATE TABLE `book_author_list` (
  `book_id` varchar(255) NOT NULL,
  `author_list` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_author_list`
--

INSERT INTO `book_author_list` (`book_id`, `author_list`) VALUES
('fE5aMQAACAAJ', 'Sanjay Patni'),
('7k6fDAAAQBAJ', 'Alex Soojung-Kim Pang'),
('XZebDwAAQBAJ', 'Claudia Hammond');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, '123456', 'Gerdas123');

-- --------------------------------------------------------

--
-- Table structure for table `user_book`
--

CREATE TABLE `user_book` (
  `is_finished` bit(1) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `pages_read` int(11) NOT NULL,
  `id` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_book`
--

INSERT INTO `user_book` (`is_finished`, `notes`, `pages_read`, `id`, `user_id`) VALUES
(b'0', 'gera knyga', 10, '7k6fDAAAQBAJ', 1),
(b'0', 'gera knyga', 10, 'fE5aMQAACAAJ', 1),
(b'0', 'SUPER!', 50, 'XZebDwAAQBAJ', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_author_list`
--
ALTER TABLE `book_author_list`
  ADD KEY `FKrd4i2w3w6a9lir9ton00om5qd` (`book_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_book`
--
ALTER TABLE `user_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbc0bwdnndnxhct38sinbem0n0` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_author_list`
--
ALTER TABLE `book_author_list`
  ADD CONSTRAINT `FKrd4i2w3w6a9lir9ton00om5qd` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `user_book`
--
ALTER TABLE `user_book`
  ADD CONSTRAINT `FKbc0bwdnndnxhct38sinbem0n0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKhjxcnt615n8h5jx0yysbl51dg` FOREIGN KEY (`id`) REFERENCES `book` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
