-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2024 at 08:06 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `databitz`
--

-- --------------------------------------------------------

--
-- Table structure for table `animals`
--

CREATE TABLE `animals` (
  `animalsID` int(10) NOT NULL,
  `ownerID` int(10) NOT NULL,
  `petName` varchar(100) NOT NULL,
  `species` varchar(100) NOT NULL,
  `breed` varchar(100) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `Gender` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`animalsID`, `ownerID`, `petName`, `species`, `breed`, `dateOfBirth`, `Gender`) VALUES
(24, 4, 'Max', 'Dog', 'Labrador Retriever', '2021-03-04', 'Male'),
(25, 4, 'Luna', 'Cat', 'Siamese', '2022-03-04', 'Female'),
(26, 4, 'Snowball', 'Rabbit', 'Holland Lop', '2023-03-03', 'Male'),
(27, 4, 'Hexa', 'Guinea Pig', 'Abyssinian', '2024-02-07', 'Female'),
(28, 4, 'Chester', 'Hamster', 'Syrian', '2023-03-03', 'Male'),
(29, 4, 'Bull', 'Bird', 'Budgerigar', '2023-03-31', 'Male'),
(30, 4, 'Spikers', 'Snake', 'Ball Python', '2023-01-03', 'Female'),
(31, 4, 'Whiskers', 'Rodents', 'Fancy Mouse', '2024-02-01', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `aptID` int(10) NOT NULL,
  `animalsID` int(10) NOT NULL,
  `docserviceID` int(10) NOT NULL,
  `aptDate` date NOT NULL,
  `aptTime` varchar(100) NOT NULL,
  `book` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`aptID`, `animalsID`, `docserviceID`, `aptDate`, `aptTime`, `book`) VALUES
(35, 24, 1029, '2024-03-16', '1:00 PM-3:00 PM', '2024-03-02 09:48:43'),
(36, 25, 1038, '2024-03-23', '1:00 PM-3:00 PM', '2024-03-02 09:49:18'),
(37, 26, 1020, '2024-03-22', '1:00 PM-3:00 PM', '2024-03-02 09:52:01'),
(38, 27, 1038, '2024-03-30', '1:00 PM-3:00 PM', '2024-03-02 09:53:32'),
(39, 28, 1039, '2024-03-21', '1:00 PM-3:00 PM', '2024-03-02 09:55:26'),
(40, 29, 1042, '2024-03-22', '1:00 PM-3:00 PM', '2024-03-02 09:56:13'),
(41, 30, 1037, '2024-04-09', '8:00 AM-10:00 AM', '2024-03-02 09:57:16'),
(42, 31, 1020, '2024-03-22', '8:00 AM-10:00 AM', '2024-03-02 09:58:44');

--
-- Triggers `appointments`
--
DELIMITER $$
CREATE TRIGGER `appointment_insert_trigger` AFTER INSERT ON `appointments` FOR EACH ROW BEGIN
    INSERT INTO `TRANSACTION` (aptID, empID, totalAmount, transTime)
    SELECT NEW.aptID, 1, (d.professionFee + s.serviceFee), CURRENT_TIMESTAMP
    FROM docservice ds
    INNER JOIN doctor d ON ds.docID = d.docID
    INNER JOIN service s ON ds.serviceID = s.serviceID
    WHERE ds.docserviceID = NEW.docserviceID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `docservice`
--

CREATE TABLE `docservice` (
  `docserviceID` int(10) NOT NULL,
  `docID` int(10) NOT NULL,
  `serviceID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `docservice`
--

INSERT INTO `docservice` (`docserviceID`, `docID`, `serviceID`) VALUES
(1020, 1, 2),
(1021, 2, 1),
(1022, 2, 10),
(1024, 3, 3),
(1025, 3, 7),
(1026, 4, 5),
(1027, 4, 8),
(1028, 5, 11),
(1029, 5, 4),
(1030, 6, 9),
(1031, 6, 6),
(1032, 7, 6),
(1035, 7, 9),
(1036, 8, 1),
(1037, 8, 10),
(1038, 9, 7),
(1039, 9, 3),
(1041, 10, 2),
(1042, 11, 4),
(1044, 11, 11);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `docID` int(10) NOT NULL,
  `docName` varchar(100) DEFAULT NULL,
  `availSched` varchar(100) DEFAULT NULL,
  `contactNum` varchar(50) DEFAULT NULL,
  `cEmail` varchar(100) DEFAULT NULL,
  `Specialization` varchar(100) DEFAULT NULL,
  `professionFee` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`docID`, `docName`, `availSched`, `contactNum`, `cEmail`, `Specialization`, `professionFee`) VALUES
(1, 'David Wilson', 'Monday-Wednesday-Friday', '9987654321', 'david.wilson@nun.com', 'Anesthesiologist', 20000.00),
(2, 'Emily Jones', 'Monday-Wednesday-Friday', '9256789012', 'emily.jones@saith.com', 'Certified Pet Stylist ', 0.00),
(3, 'Laura Davis', 'Monday-Tuesday-Wednesday', '9554321092', 'laura.davis@can.com', 'Food Safety Inspector', 5000.00),
(4, 'Robert Thomas', 'Friday and Saturday', '9267890123', 'robert.thomas@example.com', 'Veterinary Surgeon', 40000.00),
(5, 'Jennifer White', 'Saturday-Sunday', '9334567290', 'jennifer.white@example.com', 'Veterinary Internist', 40000.00),
(6, 'Michael Brown', 'Monday to Wednesday', '9123456789', 'michael.brown@exammple.com', 'Canine Behaviorist', 0.00),
(7, 'Saran Smith', 'Thursday to Sunday', '9171234567', 'sarah.smith@example.com', 'Canine Behaviorist', 0.00),
(8, 'Gabriella Styles', 'Tuesday-Thursday-Saturday', '9878237482', 'gabriella.styles@example.com', 'Certified Pet Stylist ', 0.00),
(9, 'Mark Pawsley', 'Thursday-Friday-Saturday', '9997283458', 'mark.pawsley@example.com', 'Food Safety Inspector', 5000.00),
(10, 'Lily Tailor', 'Tuesday-Thursday-Saturday', '9230574582', 'lilytaylor@out.in', 'Anesthesiologist', 20000.00),
(11, 'Neil Kin', 'Monday-Wednesday-Friday', '9890347642', 'neilKinl23@out.in', 'Veterinary Internist', 40000.00);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empID` int(10) NOT NULL,
  `empName` varchar(100) DEFAULT NULL,
  `empJob` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empID`, `empName`, `empJob`) VALUES
(1, 'Liam Johnson', 'Cashier');

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `ownerID` int(10) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contactNum` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`ownerID`, `fullname`, `email`, `contactNum`, `password`) VALUES
(1, 'ariel', 'ariel@gmail.com', '09123432893', 'yel123'),
(2, 'yel', 'arieljul@gmail.com', '09123894381', 'yel'),
(3, 'sa', '@', '12345678987', '1'),
(4, 'ariel', 'yel@gmail.com', '09891234578', 'yel'),
(5, 'asa', 'yel1@gmail.com', '12345678912', 'yel');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceID` int(10) NOT NULL,
  `serviceName` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `serviceFee` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceID`, `serviceName`, `description`, `serviceFee`) VALUES
(1, 'Bathing and Grooming', 'Bathing, Brushing, and Nail Trimming', 2500.00),
(2, 'Anesthesia', 'Dental Cleanings, Tooth Extractions, or injuries in pets', 3200.00),
(3, 'Food Safety', 'Nutritional Consultations', 3000.00),
(4, 'Pet Surgery', 'Surgical Interventions for emergency and scheduled medical needs', 15000.00),
(5, 'Diagnostic and Therapeutic Services', 'X-rays, blood tests, or urinalysis to identify health issues', 8500.00),
(6, 'Dog Training', 'Basic obedience training for puppies or newly adopted dogs', 4500.00),
(7, 'Food Safety', 'Weight Management', 3000.00),
(8, 'Diagnostic and Therapeutic Services', 'Pet is Exhibiting signs of illness, injury, or discomfort', 8500.00),
(9, 'Dog Training', 'Behavioral Issues such as excessive barking, jumping, and aggression', 3000.00),
(10, 'Bathing and Grooming', 'Prevention of Matting and Skin Issues', 3000.00),
(11, 'Pet Surgery', 'Pets get sick or hurt and need surgery to get better like broken bone', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactID` int(10) NOT NULL,
  `aptID` int(10) NOT NULL,
  `empID` int(10) NOT NULL,
  `totalAmount` float(10,2) DEFAULT NULL,
  `transtime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactID`, `aptID`, `empID`, `totalAmount`, `transtime`) VALUES
(8, 35, 1, 55000.00, '09:48:43'),
(9, 36, 1, 8000.00, '09:49:18'),
(10, 37, 1, 23200.00, '09:52:01'),
(11, 38, 1, 8000.00, '09:53:14'),
(12, 39, 1, 8000.00, '09:55:26'),
(13, 40, 1, 55000.00, '09:56:13'),
(14, 41, 1, 3000.00, '09:57:00'),
(15, 42, 1, 23200.00, '09:58:44');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`animalsID`),
  ADD KEY `fk_ownerID` (`ownerID`);

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`aptID`),
  ADD KEY `fk_animalsID` (`animalsID`),
  ADD KEY `fk_docServiceID` (`docserviceID`);

--
-- Indexes for table `docservice`
--
ALTER TABLE `docservice`
  ADD PRIMARY KEY (`docserviceID`),
  ADD KEY `fk_docID` (`docID`),
  ADD KEY `fk_serviceID` (`serviceID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`docID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`ownerID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactID`),
  ADD KEY `fk_aptID` (`aptID`),
  ADD KEY `fk_empID` (`empID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animals`
--
ALTER TABLE `animals`
  MODIFY `animalsID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `aptID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `docservice`
--
ALTER TABLE `docservice`
  MODIFY `docserviceID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1045;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `docID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `empID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `ownerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `serviceID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transactID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `animals`
--
ALTER TABLE `animals`
  ADD CONSTRAINT `fk_ownerID` FOREIGN KEY (`ownerID`) REFERENCES `owner` (`ownerID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `fk_animalsID` FOREIGN KEY (`animalsID`) REFERENCES `animals` (`animalsID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_docServiceID` FOREIGN KEY (`docserviceID`) REFERENCES `docservice` (`docserviceID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `docservice`
--
ALTER TABLE `docservice`
  ADD CONSTRAINT `fk_docID` FOREIGN KEY (`docID`) REFERENCES `doctor` (`docID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_serviceID` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_aptID` FOREIGN KEY (`aptID`) REFERENCES `appointments` (`aptID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_empID` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
