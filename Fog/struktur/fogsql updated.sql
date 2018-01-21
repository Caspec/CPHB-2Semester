-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Role` (
  `Role_id` INT NOT NULL AUTO_INCREMENT,
  `Role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Department` (
  `Department_id` INT NOT NULL,
  `Department_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Department_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `User_id` INT NOT NULL AUTO_INCREMENT,
  `User_name` VARCHAR(45) NOT NULL,
  `User_img` VARCHAR(45) NOT NULL,
  `FK_role_id` INT NOT NULL,
  `FK_Department_id` INT NOT NULL,
  `User_email` VARCHAR(45) NOT NULL,
  `User_adress` VARCHAR(45) NOT NULL,
  `User_phone` VARCHAR(45) NOT NULL,
  `User_zip` INT NOT NULL,
  `User_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`User_id`, `FK_role_id`, `FK_Department_id`),
  INDEX `fk_User_Role1_idx` (`FK_role_id` ASC),
  INDEX `fk_User_Department1_idx` (`FK_Department_id` ASC),
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`FK_role_id`)
    REFERENCES `mydb`.`Role` (`Role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Department1`
    FOREIGN KEY (`FK_Department_id`)
    REFERENCES `mydb`.`Department` (`Department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `Order_id` INT NOT NULL AUTO_INCREMENT,
  `Order_status` VARCHAR(45) NOT NULL,
  `Order_logicstic` TINYINT(1) NOT NULL,
  `FK_User_id` INT NOT NULL,
  `FK_User_role_id` INT NOT NULL,
  `Order_recived` DATE NOT NULL,
  `Order_delivered` DATE NULL,
  PRIMARY KEY (`Order_id`, `FK_User_id`, `FK_User_role_id`),
  INDEX `fk_Order_User1_idx` (`FK_User_id` ASC, `FK_User_role_id` ASC),
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`FK_User_id` , `FK_User_role_id`)
    REFERENCES `mydb`.`User` (`User_id` , `FK_role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Item` (
  `Item_id` INT NOT NULL AUTO_INCREMENT,
  `Item_name` VARCHAR(45) NOT NULL,
  `Item_price` DOUBLE NOT NULL,
  `Item_measurement` INT NOT NULL,
  PRIMARY KEY (`Item_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrderDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrderDetail` (
  `Orderdetail_id` INT NOT NULL AUTO_INCREMENT,
  `Orderdetail_quantity` INT NOT NULL,
  `FK_Order_id` INT NOT NULL,
  `FK_Item_id` INT NOT NULL,
  PRIMARY KEY (`Orderdetail_id`, `FK_Order_id`, `FK_Item_id`),
  INDEX `fk_OrderDetail_Order1_idx` (`FK_Order_id` ASC),
  INDEX `fk_OrderDetail_Item1_idx` (`FK_Item_id` ASC),
  CONSTRAINT `fk_OrderDetail_Order1`
    FOREIGN KEY (`FK_Order_id`)
    REFERENCES `mydb`.`Order` (`Order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderDetail_Item1`
    FOREIGN KEY (`FK_Item_id`)
    REFERENCES `mydb`.`Item` (`Item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrderData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrderData` (
  `Orderdata_length` INT NOT NULL,
  `Orderdata_width` INT NOT NULL,
  `Orderdata_height` INT NOT NULL,
  `Orderdata_floor` VARCHAR(45) NOT NULL,
  `Orderdata_roof` VARCHAR(45) NOT NULL,
  `Orderdata_side` VARCHAR(45) NOT NULL,
  `FK_Order_id` INT NOT NULL,
  PRIMARY KEY (`FK_Order_id`),
  CONSTRAINT `fk_OrderData_Order`
    FOREIGN KEY (`FK_Order_id`)
    REFERENCES `mydb`.`Order` (`Order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Offer` (
  `Offer_id` INT NOT NULL AUTO_INCREMENT,
  `Offer_headline` VARCHAR(45) NOT NULL,
  `Offer_img` VARCHAR(45) NOT NULL,
  `Offer_text` VARCHAR(45) NOT NULL,
  `Offer_discount` INT NOT NULL,
  PRIMARY KEY (`Offer_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
