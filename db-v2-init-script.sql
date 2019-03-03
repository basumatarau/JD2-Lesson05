-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db-v2(jd2-lesson05)
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db-v2(jd2-lesson05)
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db-v2` ;

-- -----------------------------------------------------
-- Schema db-v2(jd2-lesson05)
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db-v2` DEFAULT CHARACTER SET utf8 ;
USE `db-v2` ;

-- -----------------------------------------------------
-- Table `db-v2`.`user_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-v2`.`user_details` (
  `id_user_details` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `birthday` TIMESTAMP NULL,
  PRIMARY KEY (`id_user_details`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db-v2`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db-v2`.`users` (
  `user_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(60) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `password_salt` VARCHAR(45) NOT NULL,
  `last_update` TIMESTAMP NULL DEFAULT NULL,
  `fid_user_details` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_users_user_details_idx` (`fid_user_details` ASC),
  CONSTRAINT `fk_users_user_details`
    FOREIGN KEY (`fid_user_details`)
    REFERENCES `db-v2`.`user_details` (`id_user_details`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
