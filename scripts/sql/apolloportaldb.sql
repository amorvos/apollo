/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS ApolloPortalDB
  DEFAULT CHARACTER SET = utf8mb4;

USE ApolloPortalDB;

# Dump of table app
# ------------------------------------------------------------

DROP TABLE IF EXISTS `App`;

CREATE TABLE `App` (
  `Id`                        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `AppId`                     VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'AppID',
  `Name`                      VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT '应用名',
  `OrgId`                     VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '部门Id',
  `OrgName`                   VARCHAR(64)      NOT NULL DEFAULT 'default'
  COMMENT '部门名字',
  `OwnerName`                 VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'ownerName',
  `OwnerEmail`                VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'ownerEmail',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Name` (`Name`(191))
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='应用表';

# Dump of table appnamespace
# ------------------------------------------------------------

DROP TABLE IF EXISTS `AppNamespace`;

CREATE TABLE `AppNamespace` (
  `Id`                        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增主键',
  `Name`                      VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT 'namespace名字，注意，需要全局唯一',
  `AppId`                     VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT 'app id',
  `Format`                    VARCHAR(32)      NOT NULL DEFAULT 'properties'
  COMMENT 'namespace的format类型',
  `IsPublic`                  BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT 'namespace是否为公共',
  `Comment`                   VARCHAR(64)      NOT NULL DEFAULT ''
  COMMENT '注释',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_AppId` (`AppId`),
  KEY `Name_AppId` (`Name`, `AppId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='应用namespace定义';

# Dump of table consumer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Consumer`;

CREATE TABLE `Consumer` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `AppId`                     VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'AppID',
  `Name`                      VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT '应用名',
  `OrgId`                     VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '部门Id',
  `OrgName`                   VARCHAR(64)      NOT NULL DEFAULT 'default'
  COMMENT '部门名字',
  `OwnerName`                 VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'ownerName',
  `OwnerEmail`                VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'ownerEmail',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='开放API消费者';

# Dump of table consumeraudit
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ConsumerAudit`;

CREATE TABLE `ConsumerAudit` (
  `Id`                     INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `ConsumerId`             INT(11) UNSIGNED          DEFAULT NULL
  COMMENT 'Consumer Id',
  `Uri`                    VARCHAR(1024)    NOT NULL DEFAULT ''
  COMMENT '访问的Uri',
  `Method`                 VARCHAR(16)      NOT NULL DEFAULT ''
  COMMENT '访问的Method',
  `DataChange_CreatedTime` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastTime`    TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_ConsumerId` (`ConsumerId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='consumer审计表';

# Dump of table consumerrole
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ConsumerRole`;

CREATE TABLE `ConsumerRole` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `ConsumerId`                INT(11) UNSIGNED          DEFAULT NULL
  COMMENT 'Consumer Id',
  `RoleId`                    INT(10) UNSIGNED          DEFAULT NULL
  COMMENT 'Role Id',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)               DEFAULT ''
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_RoleId` (`RoleId`),
  KEY `IX_ConsumerId_RoleId` (`ConsumerId`, `RoleId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='consumer和role的绑定表';

# Dump of table consumertoken
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ConsumerToken`;

CREATE TABLE `ConsumerToken` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `ConsumerId`                INT(11) UNSIGNED          DEFAULT NULL
  COMMENT 'ConsumerId',
  `Token`                     VARCHAR(128)     NOT NULL DEFAULT ''
  COMMENT 'token',
  `Expires`                   DATETIME         NOT NULL DEFAULT '2099-01-01 00:00:00'
  COMMENT 'token失效时间',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_Token` (`Token`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='consumer token表';

# Dump of table favorite
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Favorite`;

CREATE TABLE `Favorite` (
  `Id`                        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `UserId`                    VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '收藏的用户',
  `AppId`                     VARCHAR(500)     NOT NULL DEFAULT 'default'
  COMMENT 'AppID',
  `Position`                  INT(32)          NOT NULL DEFAULT '10000'
  COMMENT '收藏顺序',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `IX_UserId` (`UserId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 23
  DEFAULT CHARSET = utf8mb4
  COMMENT ='应用收藏表';

# Dump of table permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Permission`;

CREATE TABLE `Permission` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `PermissionType`            VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '权限类型',
  `TargetId`                  VARCHAR(256)     NOT NULL DEFAULT ''
  COMMENT '权限对象类型',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT ''
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_TargetId_PermissionType` (`TargetId`(191), `PermissionType`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='permission表';

# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Role`;

CREATE TABLE `Role` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `RoleName`                  VARCHAR(256)     NOT NULL DEFAULT ''
  COMMENT 'Role name',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_RoleName` (`RoleName`(191)),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='角色表';

# Dump of table rolepermission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `RolePermission`;

CREATE TABLE `RolePermission` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `RoleId`                    INT(10) UNSIGNED          DEFAULT NULL
  COMMENT 'Role Id',
  `PermissionId`              INT(10) UNSIGNED          DEFAULT NULL
  COMMENT 'Permission Id',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)               DEFAULT ''
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_RoleId` (`RoleId`),
  KEY `IX_PermissionId` (`PermissionId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='角色和权限的绑定表';

# Dump of table serverconfig
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ServerConfig`;

CREATE TABLE `ServerConfig` (
  `Id`                        INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `Key`                       VARCHAR(64)      NOT NULL DEFAULT 'default'
  COMMENT '配置项Key',
  `Value`                     VARCHAR(2048)    NOT NULL DEFAULT 'default'
  COMMENT '配置项值',
  `Comment`                   VARCHAR(1024)             DEFAULT ''
  COMMENT '注释',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)      NOT NULL DEFAULT 'default'
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_Key` (`Key`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='配置服务自身配置';

# Dump of table userrole
# ------------------------------------------------------------

DROP TABLE IF EXISTS `UserRole`;

CREATE TABLE `UserRole` (
  `Id`                        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `UserId`                    VARCHAR(128)              DEFAULT ''
  COMMENT '用户身份标识',
  `RoleId`                    INT(10) UNSIGNED          DEFAULT NULL
  COMMENT 'Role Id',
  `IsDeleted`                 BIT(1)           NOT NULL DEFAULT b'0'
  COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy`      VARCHAR(32)               DEFAULT ''
  COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime`    TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `DataChange_LastModifiedBy` VARCHAR(32)               DEFAULT ''
  COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime`       TIMESTAMP        NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_RoleId` (`RoleId`),
  KEY `IX_UserId_RoleId` (`UserId`, `RoleId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户和role的绑定表';

# Dump of table Users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Users`;

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

# Dump of table Authorities
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Authorities`;

CREATE TABLE `Authorities` (
  `Id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '自增Id',
  `Username`  VARCHAR(50)      NOT NULL,
  `Authority` VARCHAR(50)      NOT NULL,
  PRIMARY KEY (`Id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# Config
# ------------------------------------------------------------
INSERT INTO `ServerConfig` (`Key`, `Value`, `Comment`)
VALUES
  ('apollo.portal.envs', 'dev', '可支持的环境列表'),
  ('organizations',
   '[{\"orgId\":\"TEST1\",\"orgName\":\"样例部门1\"},{\"orgId\":\"TEST2\",\"orgName\":\"样例部门2\"}]',
   '部门列表'),
  ('superAdmin', 'apollo', 'Portal超级管理员'),
  ('api.readTimeout', '10000', 'http接口read timeout'),
  ('consumer.token.salt', 'someSalt', 'consumer token salt');

INSERT INTO `Users` (`Username`, `Password`, `Email`, `Enabled`)
VALUES
  ('apollo', '$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS',
   'apollo@acme.com', 1);

INSERT INTO `Authorities` (`Username`, `Authority`)
VALUES ('apollo', 'ROLE_user');

# Sample Data
# ------------------------------------------------------------
INSERT INTO `App` (`AppId`, `Name`, `OrgId`, `OrgName`, `OwnerName`, `OwnerEmail`)
VALUES
  ('SampleApp', 'Sample App', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com');

INSERT INTO `AppNamespace` (`Name`, `AppId`, `Format`, `IsPublic`, `Comment`)
VALUES
  ('application', 'SampleApp', 'properties', 0, 'default app namespace');

INSERT INTO `Permission` (`Id`, `PermissionType`, `TargetId`)
VALUES
  (1, 'CreateCluster', 'SampleApp'),
  (2, 'CreateNamespace', 'SampleApp'),
  (3, 'AssignRole', 'SampleApp'),
  (4, 'ModifyNamespace', 'SampleApp+application'),
  (5, 'ReleaseNamespace', 'SampleApp+application');

INSERT INTO `Role` (`Id`, `RoleName`)
VALUES
  (1, 'Master+SampleApp'),
  (2, 'ModifyNamespace+SampleApp+application'),
  (3, 'ReleaseNamespace+SampleApp+application');

INSERT INTO `RolePermission` (`RoleId`, `PermissionId`)
VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 4),
  (3, 5);

INSERT INTO `UserRole` (`UserId`, `RoleId`)
VALUES
  ('apollo', 1),
  ('apollo', 2),
  ('apollo', 3);

/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;