-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tasknew
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tasknew
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tasknew` DEFAULT CHARACTER SET utf8 ;
USE `tasknew` ;

-- -----------------------------------------------------
-- Table `tasknew`.`parent_task_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tasknew`.`parent_task_list` (
  `parent_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `parent_task_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`parent_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tasknew`.`user_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tasknew`.`user_details` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `employee_id` BIGINT(20) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tasknew`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tasknew`.`project` (
  `project_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `end_date` DATETIME NULL DEFAULT NULL,
  `priority` INT(11) NOT NULL,
  `project_name` VARCHAR(255) NOT NULL,
  `start_date` DATETIME NULL DEFAULT NULL,
  `status` VARCHAR(255) NOT NULL,
  `task_completed` INT(11) NOT NULL,
  `task_count` INT(11) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `FKchnmp6702if4ngvxqskgwx9dc` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKchnmp6702if4ngvxqskgwx9dc`
    FOREIGN KEY (`user_id`)
    REFERENCES `tasknew`.`user_details` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tasknew`.`task_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tasknew`.`task_details` (
  `task_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `end_date` DATETIME NOT NULL,
  `priority` INT(11) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  `task_name` VARCHAR(255) NOT NULL,
  `parent_id` BIGINT(20) NULL DEFAULT NULL,
  `project_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`task_id`),
  INDEX `FKc30w79ht1l57iu6nbpot9bbac` (`parent_id` ASC) VISIBLE,
  INDEX `FKdt1qb6s46r5we3j3iijyx11gw` (`project_id` ASC) VISIBLE,
  INDEX `FKbb0rfvs0kjqifkq1stvflj9jv` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKbb0rfvs0kjqifkq1stvflj9jv`
    FOREIGN KEY (`user_id`)
    REFERENCES `tasknew`.`user_details` (`user_id`),
  CONSTRAINT `FKc30w79ht1l57iu6nbpot9bbac`
    FOREIGN KEY (`parent_id`)
    REFERENCES `tasknew`.`parent_task_list` (`parent_id`),
  CONSTRAINT `FKdt1qb6s46r5we3j3iijyx11gw`
    FOREIGN KEY (`project_id`)
    REFERENCES `tasknew`.`project` (`project_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
