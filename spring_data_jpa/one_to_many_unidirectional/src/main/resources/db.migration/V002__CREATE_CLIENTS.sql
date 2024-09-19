CREATE TABLE IF NOT EXISTS `clients`
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    first_name   VARCHAR(80),
    last_name    VARCHAR(80),
    phone_number VARCHAR(80),
    info         VARCHAR(80)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;