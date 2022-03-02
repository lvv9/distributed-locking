-- locking.`lock` definition

CREATE TABLE `lock` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `space` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `token_space_IDX` (`space`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- locking.token definition

CREATE TABLE `token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `resource_key` varchar(100) NOT NULL,
  `token_aka_locking_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `token_resource_key_IDX` (`resource_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- locking.resource definition

CREATE TABLE `resource` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `resource_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resource_resource_key_IDX` (`resource_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;