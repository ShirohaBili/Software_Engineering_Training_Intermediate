SELECT
	* 
FROM
	`user` CREATE TABLE `authentication` (
		`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
		`description` VARCHAR ( 255 ) CHARACTER 
		SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`name` VARCHAR ( 255 ) CHARACTER 
		SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		PRIMARY KEY ( `id` ) USING BTREE 
	) ENGINE = INNODB AUTO_INCREMENT = 3 CHARACTER 
	SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `authentication`
VALUES
	( 1, '管理员', 'Admin' );
INSERT INTO `authentication`
VALUES
	( 2, '用户', 'User' );
	
	
	CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


INSERT INTO `user` VALUES (1, 'admin', '$2a$10$O0LmLvs6sPVR4oy7StpgzuIaZY2jnToS/u38EsWxfKofIBY6W5POm', '13508108103', '不知道谁啊', 'Shiroha');

select * from user