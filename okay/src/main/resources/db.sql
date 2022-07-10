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
INSERT INTO `okay`.`user`(`id`, `name`, `pwd`, `record`) VALUES (1, 'admin', 'admin', 20);

/* map格式
[
    {
        "type":"POLYGON",
        "property":"ELIMINATION",
        "point":[
            {
                "number":0,
                "x":6,
                "y":9
            },
            {
                "number":1,
                "x":5,
                "y":11
            },
            {
                "number":2,
                "x":10,
                "y":8
            },
            {
                "number":3,
                "x":6,
                "y":9
            }
        ]
    }
]
type: "line"-线，"circle"-圆，"polygon"-多边形
property: "elimination"-单次消除（灰色），"double_elimination"-双次消除（浅灰），"obstacle"-障碍（黑色），"black_hole"-黑洞（空心）
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
    UNIQUE KEY `uni_idx_levelId_user_system` (`level_id`,`user`,`is_system`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
