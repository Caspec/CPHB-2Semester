-- MySQL Script generated by MySQL Workbench
-- 02/27/17 09:57:12
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cupcakes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcakes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcakes` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema cupcakes
-- -----------------------------------------------------
USE `cupcakes`;

-- -----------------------------------------------------
-- Table `cupcakes`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakes`.`role` ;

CREATE TABLE IF NOT EXISTS `cupcakes`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcakes`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakes`.`customer` ;

CREATE TABLE IF NOT EXISTS `cupcakes`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `customer_password` VARCHAR(45) NOT NULL,
  `fk_role_id` INT NOT NULL,
  `customer_balance` DOUBLE NOT NULL,
  PRIMARY KEY (`customer_id`, `fk_role_id`),
  INDEX `fk_customer_role_idx` (`fk_role_id` ASC),
  CONSTRAINT `fk_customer_role`
    FOREIGN KEY (`fk_role_id`)
    REFERENCES `cupcakes`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcakes`.`topping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakes`.`topping` ;

CREATE TABLE IF NOT EXISTS `cupcakes`.`topping` (
  `topping_id` INT NOT NULL AUTO_INCREMENT,
  `topping_name` VARCHAR(45) NOT NULL,
  `topping_price` DOUBLE NOT NULL,
  `topping_img` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`topping_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcakes`.`bottom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakes`.`bottom` ;

CREATE TABLE IF NOT EXISTS `cupcakes`.`bottom` (
  `bottom_id` INT NOT NULL AUTO_INCREMENT,
  `bottom_name` VARCHAR(45) NOT NULL,
  `bottom_price` DOUBLE NOT NULL,
  `bottom_img` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`bottom_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcakes`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakes`.`order` ;

CREATE TABLE IF NOT EXISTS `cupcakes`.`order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `fk_topping_id` INT NOT NULL,
  `fk_bottom_id` INT NOT NULL,
  `fk_customer_id` INT NOT NULL,
  `order_quantity` INT NOT NULL,
  `order_totalprice` DOUBLE NOT NULL,
  PRIMARY KEY (`order_id`, `fk_topping_id`, `fk_bottom_id`, `fk_customer_id`),
  INDEX `fk_order_topping1_idx` (`fk_topping_id` ASC),
  INDEX `fk_order_bottom1_idx` (`fk_bottom_id` ASC),
  INDEX `fk_order_customer1_idx` (`fk_customer_id` ASC),
  CONSTRAINT `fk_order_topping1`
    FOREIGN KEY (`fk_topping_id`)
    REFERENCES `cupcakes`.`topping` (`topping_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_bottom1`
    FOREIGN KEY (`fk_bottom_id`)
    REFERENCES `cupcakes`.`bottom` (`bottom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`fk_customer_id`)
    REFERENCES `cupcakes`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Topping
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('Chocolate', '5', 'topping1.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('BlueBerry', '5', 'topping1.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('RasBerry', '5', 'topping1.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('Chrispy', '6', 'topping1.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('StrawBerry', '6', 'topping1.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('Rom/Raisin', '7', 'topping2.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('Orange', '8', 'topping2.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('Lemon', '8', 'topping2.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('BlueCheese', '9', 'topping2.png');
INSERT INTO `cupcakes`.`topping` (`topping_name`, `topping_price`, `topping_img`) VALUES ('OldGunni', '69', 'topping2.png');

-- Bottom
INSERT INTO `cupcakes`.`bottom` (`bottom_name`, `bottom_price`, `bottom_img`) VALUES ('Chocolate', '5', 'bottom.png');
INSERT INTO `cupcakes`.`bottom` (`bottom_name`, `bottom_price`, `bottom_img`) VALUES ('Vanilla', '5', 'bottom.png');
INSERT INTO `cupcakes`.`bottom` (`bottom_name`, `bottom_price`, `bottom_img`) VALUES ('NudgetMig', '5', 'bottom.png');
INSERT INTO `cupcakes`.`bottom` (`bottom_name`, `bottom_price`, `bottom_img`) VALUES ('Pistacio', '6', 'bottom.png');
INSERT INTO `cupcakes`.`bottom` (`bottom_name`, `bottom_price`, `bottom_img`) VALUES ('Almond', '7', 'bottom.png');

-- Role
INSERT INTO `cupcakes`.`role` (`role_name`) VALUES ('Admin');
INSERT INTO `cupcakes`.`role` (`role_name`) VALUES ('User');

-- Customer
INSERT INTO `cupcakes`.`customer` (`customer_name`, `customer_password`, `fk_role_id`, `customer_balance`) VALUES ('Stephan', '1234', '1', '10');
INSERT INTO `cupcakes`.`customer` (`customer_name`, `customer_password`, `fk_role_id`, `customer_balance`) VALUES ('Nicklas', '1234', '1', '10');
INSERT INTO `cupcakes`.`customer` (`customer_name`, `customer_password`, `fk_role_id`, `customer_balance`) VALUES ('Casper', '1234', '1', '10');
INSERT INTO `cupcakes`.`customer` (`customer_name`, `customer_password`, `fk_role_id`, `customer_balance`) VALUES ('Gunni', '1234', '2', '1');
INSERT INTO `cupcakes`.`customer` (`customer_name`, `customer_password`, `fk_role_id`, `customer_balance`) VALUES ('2biass', '1234', '2', '1');

-- Order
INSERT INTO `cupcakes`.`order` (`fk_topping_id`, `fk_bottom_id`, `fk_customer_id`, `order_quantity`, `order_totalprice`) VALUES ('1', '1', '1', '1', '5');
INSERT INTO `cupcakes`.`order` (`fk_topping_id`, `fk_bottom_id`, `fk_customer_id`, `order_quantity`, `order_totalprice`) VALUES ('2', '2', '1', '1', '5');
INSERT INTO `cupcakes`.`order` (`fk_topping_id`, `fk_bottom_id`, `fk_customer_id`, `order_quantity`, `order_totalprice`) VALUES ('2', '1', '1', '1', '5');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;