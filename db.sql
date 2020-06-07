-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`username` VARCHAR(64) UNIQUE NOT NULL,
		`password` VARCHAR(64) DEFAULT NULL,
		`avatar` VARCHAR(2500) DEFAULT NULL COMMENT '头像',
		`email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
		`tel` VARCHAR(100) DEFAULT NULL COMMENT '电话',
		`auth` VARCHAR(100) DEFAULT 'ROLE_USER' COMMENT '角色',
		`nickname` VARCHAR(200) DEFAULT NULL COMMENT '昵称',
		`signature` VARCHAR(500) DEFAULT NULL COMMENT '个性签名',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		`views` BIGINT(20) DEFAULT 0 COMMENT '用户访问量',
		`status` INT(1) DEFAULT 1 COMMENT '账户状态，1正常，0异常',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

INSERT `user` VALUES(1000, 'ecin520', 'guowei00a', '', '15607942340@163.com', '15607942340', 'ROLE_ADMIN', 'Ecin520', '我是一名普通的程序员，喜欢写文章和分享软件。希望你们能够喜欢我和我的软件。', now(), 0, 1);


-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`creater` BIGINT(20) NOT NULL  COMMENT '作者',
		`title` VARCHAR(3600) NOT NULL COMMENT '文章标题',
		`generalize` VARCHAR(5600) DEFAULT NULL COMMENT '文章概览',
		`content` LONGTEXT DEFAULT NULL COMMENT '内容',
		`time` VARCHAR(20) DEFAULT NULL COMMENT '发布时间',
		`show_image` VARCHAR(3600) DEFAULT NULL COMMENT '展示图片',
		`recommend` INT(1) DEFAULT 0 COMMENT '是否推荐，1-推荐，0-不推荐',
		`likes` BIGINT(20) DEFAULT 0 COMMENT '点赞数',
		`views` BIGINT(20) DEFAULT 0 COMMENT '访问量',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='文章表';


INSERT `article` VALUES(1000, 1000, 'Java是世界上最好的语言', '毋庸置疑的', now(), ``, 1, 0, 0);

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(100) NOT NULL UNIQUE COMMENT '分类名',
		`description` VARCHAR(3600) DEFAULT NULL COMMENT '分类描述',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='分类表';


-- ----------------------------
-- Table structure for article_categories
-- ----------------------------
DROP TABLE IF EXISTS `article_categories`;
CREATE TABLE `article_categories`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`article_id` BIGINT(20) NOT NULL COMMENT '文章ID',
		`categories_id` BIGINT(20) NOT NULL COMMENT '分类ID',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='文章分类表';

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(100) NOT NULL UNIQUE COMMENT '标签名',
		`description` VARCHAR(3600) DEFAULT NULL COMMENT '标签描述',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='标签表';


-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`article_id` BIGINT(20) NOT NULL COMMENT '文章ID',
		`tag_id` BIGINT(20) NOT NULL COMMENT '标签ID',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='文章标签表';


-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`article_id` BIGINT(20) NOT NULL COMMENT '文章ID',
		`commentator` BIGINT(20) NOT NULL COMMENT '评论者',
		`commentator_name` VARCHAR(100) DEFAULT NULL COMMENT '评论者名称',
		`commentator_avatar` VARCHAR(2500) DEFAULT NULL COMMENT '头像',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		`likes` BIGINT(20) DEFAULT 0 COMMENT '点赞数',
		`content` VARCHAR(3600) DEFAULT NULL COMMENT '评论内容',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';


-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`comment_id` BIGINT(20) NOT NULL COMMENT '评论ID',
		`commentator` BIGINT(20) NOT NULL COMMENT '评论者',
		`commentator_name` VARCHAR(100) DEFAULT NULL COMMENT '评论者名称',
		`commentator_avatar` VARCHAR(2500) DEFAULT NULL COMMENT '头像',
		`create_time` VARCHAR(20) DEFAULT NULL COMMENT '创建时间',
		`content` VARCHAR(3600) DEFAULT NULL COMMENT '评论内容',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='评论回复表';


-- ----------------------------
-- Table structure for views
-- ----------------------------
DROP TABLE IF EXISTS `views`;
CREATE TABLE `views`(
		`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
		`all_views` BIGINT(20),
		`day_views` BIGINT(20),
		`vis_num` BIGINT(20),
		`ip_num` BIGINT(20),
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8mb4 COMMENT='访问量';

INSERT `views` VALUES(1000, 0, 0, 0, 0);