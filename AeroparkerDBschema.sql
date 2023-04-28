-- -----------------------------------------------------
-- Schema Aeroparker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Aeroparker` ;

-- -----------------------------------------------------
-- Schema Aeroparker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Aeroparker` DEFAULT CHARACTER SET utf8 ;
USE `Aeroparker` ;

-- -----------------------------------------------------
-- Table `Aeroparker`.`Customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Aeroparker`.`Customers` ;

CREATE TABLE IF NOT EXISTS `Aeroparker`.`Customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `registered` DATETIME NOT NULL,
  `email_address` VARCHAR(255) NOT NULL,
  `title` VARCHAR(5) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `address_line_1` VARCHAR(255) NOT NULL,
  `address_line_2` VARCHAR(255) NULL,
  `city` VARCHAR(255) NULL,
  `postcode` VARCHAR(10) NOT NULL,
  `phone_number` VARCHAR(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_address_UNIQUE` (`email_address` ASC) VISIBLE)
ENGINE = InnoDB;