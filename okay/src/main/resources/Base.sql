CREATE DATABASE IF NOT EXISTS mygame CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci;
USE mygame;

CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL COMMENT '用户名',
    `pwd` VARCHAR(255) NOT NULL COMMENT '密码',
    `record` INT(11) DEFAULT 0 COMMENT '闯关纪录',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* map格式
{
    "shape": 3,
    "property": 1,
    "point": [
        {
            "number": 1,
            "x": 4,
            "y": 4
        },
        {
            "number": 2,
            "x": 6,
            "y": 4
        },
        {
            "number": 3,
            "x": 6,
            "y": 6
        },
        {
            "number": 4,
            "x": 4,
            "y": 6
        }
    ]

}
shape: 1-线，2-圆，3-多边形
property: 1-单次消除（灰色），2-双次消除（浅灰），3-障碍（黑色），4-黑洞（空心）
point：[number: 序号, x、y: 坐标]
 */
CREATE TABLE IF NOT EXISTS `level` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`level_id` BIGINT(20) NOT NULL COMMENT '关卡序号',
    `name` VARCHAR(255) NOT NULL COMMENT '关卡名',
    `map` LONGTEXT NOT NULL COMMENT '地图',
	`user` VARCHAR(255) DEFAULT NULL COMMENT '使用者',
	`is_system` TINYINT(1) DEFAULT 1 COMMENT '是否系统，0否1是',
    PRIMARY KEY (`id`),
    KEY `idx_level` (`level_id`),
    UNIQUE KEY `uni_idx_name_user_system` (`name`,`user`,`is_system`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;