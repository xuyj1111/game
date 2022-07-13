CREATE DATABASE IF NOT EXISTS okay CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci;
USE okay;

CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL COMMENT '用户名',
    `pwd` VARCHAR(255) NOT NULL COMMENT '密码',
    `record` INT(11) DEFAULT 1 COMMENT '闯关纪录',
    PRIMARY KEY (`id`),
    UNIQUE KEY `un_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
TRUNCATE `okay`.`user`;
INSERT INTO `okay`.`user`(`id`, `name`, `pwd`, `record`) VALUES (1, 'admin', 'admin', 20);

CREATE TABLE IF NOT EXISTS `level` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`level_id` BIGINT(20) NOT NULL COMMENT '关卡序号',
    `name` VARCHAR(255) NOT NULL COMMENT '关卡名',
    `map` LONGTEXT NOT NULL COMMENT '地图',
	`user` VARCHAR(255) DEFAULT NULL COMMENT '使用者',
	`is_system` TINYINT(1) DEFAULT 1 COMMENT '是否系统，0否1是',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uni_idx_levelId_user_system` (`level_id`,`user`,`is_system`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
TRUNCATE `okay`.`level`;