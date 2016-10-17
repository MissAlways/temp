--
-- Database: `game`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemId` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `attack` int(11) DEFAULT NULL,
  `armor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemId`, `name`, `type`, `description`, `attack`, `armor`) VALUES
(1, 'Bronze Pickaxe', 'Tool', 'Tool to mine some minerals', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `itemperplayer`
--

CREATE TABLE `itemperplayer` (
  `itemId` int(11) NOT NULL,
  `playerId` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemperplayer`
--

INSERT INTO `itemperplayer` (`itemId`, `playerId`, `amount`) VALUES
(1, 1, 2),
(1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `playerId` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `movingSpeed` int(11) NOT NULL,
  `helthMax` int(11) NOT NULL,
  `lvl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`playerId`, `name`, `movingSpeed`, `helthMax`, `lvl`) VALUES
(2, 'Killer666', 100, 100, 0),
(3, 'H4kk3rm4n', 100, 100, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`itemId`);

--
-- Indexes for table `itemperplayer`
--
ALTER TABLE `itemperplayer`
  ADD PRIMARY KEY (`itemId`,`playerId`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`playerId`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `itemId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `playerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
