CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `gender` enum('m','f') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `last_name` (`last_name`,`first_name`,`dob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
