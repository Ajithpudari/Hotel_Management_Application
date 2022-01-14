CREATE TABLE `registration`
(
    `id`          int NOT NULL,
    `firstName`   varchar(20) DEFAULT NULL,
    `lastName`    varchar(20) DEFAULT NULL,
    `phoneNumber` varchar(20) DEFAULT NULL,
    `role`        varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `rooms`
(
    `id`           int NOT NULL,
    `date`         varchar(45) DEFAULT NULL,
    `roomNo`       varchar(45) DEFAULT NULL,
    `availability` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;