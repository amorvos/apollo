# delta schema to upgrade apollo portal db from v0.8.0 to v0.9.0

USE ApolloPortalDB;

CREATE TABLE `Users` (
  `Id`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `Username` VARCHAR(64)      NOT NULL DEFAULT 'default'
  COMMENT '用户名',
  `Password` VARCHAR(64)      NOT NULL DEFAULT 'default'
  COMMENT '密码',
  `Email`    VARCHAR(64)      NOT NULL DEFAULT 'default'
  COMMENT '邮箱地址',
  `Enabled`  TINYINT(4)                DEFAULT NULL
  COMMENT '是否有效',
  PRIMARY KEY (`Id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户表';

CREATE TABLE `Authorities` (
  `Id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `Username`  VARCHAR(50)      NOT NULL,
  `Authority` VARCHAR(50)      NOT NULL,
  PRIMARY KEY (`Id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `Users` (`Username`, `Password`, `Email`, `Enabled`)
VALUES
  ('apollo', '$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS',
   'apollo@acme.com', 1);

INSERT INTO `Authorities` (`Username`, `Authority`)
VALUES ('apollo', 'ROLE_user');
