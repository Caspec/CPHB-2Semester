-- Fog Database
-- Copyright Sjov med skæg 2017 - Casper, Stephan og Nicklas

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fogdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fogdb` DEFAULT CHARACTER SET utf8;

USE `fogdb`;

DROP TABLE IF EXISTS Offer;
DROP TABLE IF EXISTS OrderData;
DROP TABLE IF EXISTS OrderDetail;
DROP TABLE IF EXISTS Item;
DROP TABLE IF EXISTS ItemType;
DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS Role;

-- -----------------------------------------------------
-- Table `fogdb`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`Role` (
  `Role_id` INT NOT NULL AUTO_INCREMENT,
  `Role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Role_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`Department` (
  `Department_id` INT NOT NULL,
  `Department_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Department_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`User` (
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
    REFERENCES `fogdb`.`Role` (`Role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Department1`
    FOREIGN KEY (`FK_Department_id`)
    REFERENCES `fogdb`.`Department` (`Department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`Order` (
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
    REFERENCES `fogdb`.`User` (`User_id` , `FK_role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`ItemType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`ItemType` (
  `ItemType_id` INT NOT NULL AUTO_INCREMENT,
  `ItemType_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ItemType_id`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `fogdb`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`Item` (
  `Item_id` INT NOT NULL AUTO_INCREMENT,
  `Item_name` VARCHAR(45) NOT NULL,
  `Item_info` VARCHAR(45) NOT NULL,
  `Item_price` DOUBLE NOT NULL,
  `FK_Item_id` INT NOT NULL,
  FOREIGN KEY (`FK_Item_id`)
    REFERENCES `fogdb`.`ItemType` (`ItemType_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  PRIMARY KEY (`Item_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`OrderDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`OrderDetail` (
  `Orderdetail_id` INT NOT NULL AUTO_INCREMENT,
  `Orderdetail_quantity` INT NOT NULL,
  `Orderdetail_measurement` INT NOT NULL,
  `FK_Order_id` INT NOT NULL,
  `FK_Item_id` INT NOT NULL,
  PRIMARY KEY (`Orderdetail_id`, `FK_Order_id`, `FK_Item_id`),
  INDEX `fk_OrderDetail_Order1_idx` (`FK_Order_id` ASC),
  INDEX `fk_OrderDetail_Item1_idx` (`FK_Item_id` ASC),
  CONSTRAINT `fk_OrderDetail_Order1`
    FOREIGN KEY (`FK_Order_id`)
    REFERENCES `fogdb`.`Order` (`Order_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderDetail_Item1`
    FOREIGN KEY (`FK_Item_id`)
    REFERENCES `fogdb`.`Item` (`Item_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`OrderData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`OrderData` (
  `Orderdata_length` INT NOT NULL,
  `Orderdata_width` INT NOT NULL,
  `Orderdata_height` INT NOT NULL,
  `Orderdata_floor` INT NOT NULL,
  `Orderdata_roof` INT NOT NULL,
  `Orderdata_side` INT NOT NULL,
  `FK_Order_id` INT NOT NULL,
  PRIMARY KEY (`FK_Order_id`),
  CONSTRAINT `fk_OrderData_Order`
    FOREIGN KEY (`FK_Order_id`)
    REFERENCES `fogdb`.`Order` (`Order_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `fogdb`.`Offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`Offer` (
  `Offer_id` INT NOT NULL AUTO_INCREMENT,
  `Offer_headline` VARCHAR(45) NOT NULL,
  `Offer_img` VARCHAR(45) NOT NULL,
  `Offer_text` VARCHAR(45) NOT NULL,
  `Offer_discount` INT NOT NULL,
  PRIMARY KEY (`Offer_id`))
ENGINE = InnoDB;

-- Role
INSERT INTO `fogdb`.`Role` (`Role_name`) VALUES ('Kunde');
INSERT INTO `fogdb`.`Role` (`Role_name`) VALUES ('Sælger');
INSERT INTO `fogdb`.`Role` (`Role_name`) VALUES ('Lager');
INSERT INTO `fogdb`.`Role` (`Role_name`) VALUES ('Administrator');

-- Department
INSERT INTO `fogdb`.`Department` (`Department_id`, `Department_name`) VALUES ('1', 'Kunder');
INSERT INTO `fogdb`.`Department` (`Department_id`, `Department_name`) VALUES ('2', 'Salg');
INSERT INTO `fogdb`.`Department` (`Department_id`, `Department_name`) VALUES ('3', 'Logistik');
INSERT INTO `fogdb`.`Department` (`Department_id`, `Department_name`) VALUES ('4', 'Administrator');

-- Offer
INSERT INTO `fogdb`.`Offer` (`Offer_headline`, `Offer_img`, `Offer_text`, `Offer_discount`) VALUES ('Headline', 'noimg.png', 'tekst til offer', '10');

-- User
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Casper', 'noimgperson.png', '4', '4', 'hest@cphbusiness.dk', 'Hestegade 16', '11223344', '2730', '1234');
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Stephan', 'noimgperson.png', '4', '4', 'hestmeddværg@cphbusiness.dk', 'Hestegade 20', '44332211', '2200', '1234');
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Nicklas', 'noimgperson.png', '4', '4', 'jegerhest@cphbusiness.dk', 'Hestegade 30', '44221133', '2500', '1234');
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Kunde1', 'noimgperson.png', '1', '1', 'kunde@kundemail.dk', 'Kundegade 10', '11223344', '2000', '1234');
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Kunde2', 'noimgperson.png', '1', '1', 'Kunde2@kundemail.dk', 'Kundegade 25', '11223344', '2730', '1234');
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Knud', 'noimgperson.png', '2', '2', 'sælger@cphbusiness.dk', 'Sælgergade 16', '11223344', '2730', '1234');
INSERT INTO `fogdb`.`User` (`User_name`, `User_img`, `FK_role_id`, `FK_Department_id`, `User_email`, `User_adress`, `User_phone`, `User_zip`, `User_password`) VALUES ('Franz', 'noimgperson.png', '3', '3', 'lager@cphbusiness.dk', 'Lagergade 16', '11223344', '2730', '1234');

-- ItemType
INSERT INTO `fogdb`.`ItemType` (`ItemType_name`) VALUES ('Andet');
INSERT INTO `fogdb`.`ItemType` (`ItemType_name`) VALUES ('Tag');
INSERT INTO `fogdb`.`ItemType` (`ItemType_name`) VALUES ('Sider');
INSERT INTO `fogdb`.`ItemType` (`ItemType_name`) VALUES ('Gulv');

-- Item
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Træ Stolpe', 'Træ Stolpens Brede: 30cm ', '30', '1');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Skruer',  'Skruer 7cm, 50stk', '20', '1');

INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Plastik', 'Plastik, Målt. 30x30cm', '30', '2');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Glas', 'Glas Målt pr. 30x30cm', '30', '2');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Træ', 'Træ Målt pr.: 30x30cm', '30', '2');

INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Træ', 'Træ Målt pr. 30x30cm', '30', '3');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Glas', 'Træ Målt pr.: 30x30cm', '30', '3');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Plastik', 'Plastik Målt pr.: 30x30cm', '30', '3');

INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Træ', 'Træ Målt pr.: 30x30cm', '30', '4');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Glas', 'Glas Målt pr.: 30x30cm', '30', '4');
INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES ('Sten Fliser', 'Sten Flise Målt pr.: 30x30cm', '30', '4');

-- Order
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Ikke godkendt', '0', '4', '1', '2017-02-07');
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Ikke godkendt', '0', '4', '1', '2017-02-10');
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Godkendt', '0', '4', '1', '2017-03-29');
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Godkendt', '0', '5', '1', '2017-03-29'); 
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Pakket', '0', '5', '1', '2017-03-29');   
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Pakket', '0', '5', '1', '2017-03-29');
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Afsendt', '0', '4', '1', '2017-03-27');
INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`, `Order_delivered`) VALUES ('Afsendt', '1', '5', '1', '2017-03-27', '2017-01-04');

-- Order Data
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('120', '200', '150', '1', '1', '2', '1');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('150', '250', '150', '2', '2', '2', '2');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('160', '250', '150', '3', '3', '2', '3');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('160', '250', '150', '3', '2', '1', '4');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('160', '250', '150', '2', '2', '1', '5');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('160', '250', '150', '1', '2', '3', '6');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('160', '250', '150', '2', '1', '3', '7');
INSERT INTO `fogdb`.`OrderData` (`Orderdata_length`, `Orderdata_width`, `Orderdata_height`, `Orderdata_floor`, `Orderdata_roof`, `Orderdata_side`, `FK_Order_id`) VALUES ('160', '250', '150', '3', '1', '2', '8');

-- Order Detail
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('4', '30', '1', '1');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('2', '10', '1', '2');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('2', '53', '1', '3');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('2', '20', '1', '4');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('2', '24', '1', '6');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('2', '24', '1', '7');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('4', '30', '2', '9');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('2', '44', '3', '11');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('13', '34', '3', '5');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('18', '7', '3', '9');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('14', '14', '3', '6');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('4', '74', '3', '3');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('15', '64', '3', '7');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('3', '6', '4', '4');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('7', '8', '5', '11');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('8', '6', '6', '10');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('6', '9', '7', '2');
INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES ('3', '9', '8', '9');