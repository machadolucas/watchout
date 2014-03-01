SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `test` ;

-- -----------------------------------------------------
-- Table `test`.`places`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`places` (
  `idplaces` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2048) NULL,
  `photo` MEDIUMBLOB NULL,
  `map_coordinates` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idplaces`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`transports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`transports` (
  `idtransports` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(512) NULL,
  `icon` MEDIUMBLOB NULL,
  PRIMARY KEY (`idtransports`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`transportationrisks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`transportationrisks` (
  `idrisks` INT NOT NULL AUTO_INCREMENT,
  `transports_idtransports` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2048) NULL,
  `risk_factor` DECIMAL(10,5) NULL,
  `frequency` DECIMAL(4,2) NOT NULL DEFAULT 1,
  `data` VARCHAR(10240) NULL,
  `cash_cost` DECIMAL(10,2) NOT NULL,
  `energy_cost` INT NOT NULL,
  PRIMARY KEY (`idrisks`),
  INDEX `fk_risks_transports1_idx` (`transports_idtransports` ASC),
  CONSTRAINT `fk_risks_transports1`
    FOREIGN KEY (`transports_idtransports`)
    REFERENCES `test`.`transports` (`idtransports`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`places_has_transports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`places_has_transports` (
  `places_origin` INT NOT NULL,
  `transportation` INT NOT NULL,
  `places_destination` INT NOT NULL,
  `money_cost` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`places_origin`, `transportation`, `places_destination`),
  INDEX `fk_places_has_transports_transports1_idx` (`transportation` ASC),
  INDEX `fk_places_has_transports_places1_idx` (`places_origin` ASC),
  CONSTRAINT `fk_places_has_transports_places1`
    FOREIGN KEY (`places_origin`)
    REFERENCES `test`.`places` (`idplaces`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_places_has_transports_transports1`
    FOREIGN KEY (`transportation`)
    REFERENCES `test`.`transports` (`idtransports`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_places_has_new_place`
    FOREIGN KEY (`places_origin`)
    REFERENCES `test`.`places` (`idplaces`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`admins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`admins` (
  `idadmins` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`idadmins`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`insurances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`insurances` (
  `idinsurances` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(512) NULL,
  `icon` MEDIUMBLOB NULL,
  `cost` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idinsurances`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`insurances_has_transportationrisks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`insurances_has_transportationrisks` (
  `insurances_idinsurances` INT NOT NULL,
  `risks_idrisks` INT NOT NULL,
  `cover` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`insurances_idinsurances`, `risks_idrisks`),
  INDEX `fk_insurances_has_risks_risks1_idx` (`risks_idrisks` ASC),
  INDEX `fk_insurances_has_risks_insurances1_idx` (`insurances_idinsurances` ASC),
  CONSTRAINT `fk_insurances_has_risks_insurances1`
    FOREIGN KEY (`insurances_idinsurances`)
    REFERENCES `test`.`insurances` (`idinsurances`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_insurances_has_risks_risks1`
    FOREIGN KEY (`risks_idrisks`)
    REFERENCES `test`.`transportationrisks` (`idrisks`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`players` (
  `idplayers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `cash` DECIMAL(10,2) NOT NULL,
  `energy` INT NOT NULL,
  PRIMARY KEY (`idplayers`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`players_has_insurances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`players_has_insurances` (
  `players_idplayers` INT NOT NULL,
  `insurances_idinsurances` INT NOT NULL,
  PRIMARY KEY (`players_idplayers`, `insurances_idinsurances`),
  INDEX `fk_players_has_insurances_insurances1_idx` (`insurances_idinsurances` ASC),
  INDEX `fk_players_has_insurances_players1_idx` (`players_idplayers` ASC),
  CONSTRAINT `fk_players_has_insurances_players1`
    FOREIGN KEY (`players_idplayers`)
    REFERENCES `test`.`players` (`idplayers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_players_has_insurances_insurances1`
    FOREIGN KEY (`insurances_idinsurances`)
    REFERENCES `test`.`insurances` (`idinsurances`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`quests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`quests` (
  `idquests` INT NOT NULL AUTO_INCREMENT,
  `destination` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(1024) NULL,
  `origin` INT NOT NULL,
  PRIMARY KEY (`idquests`),
  INDEX `fk_quests_places1_idx` (`destination` ASC),
  INDEX `fk_quests_places2_idx` (`origin` ASC),
  CONSTRAINT `fk_quests_places1`
    FOREIGN KEY (`destination`)
    REFERENCES `test`.`places` (`idplaces`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_quests_places2`
    FOREIGN KEY (`origin`)
    REFERENCES `test`.`places` (`idplaces`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`players_has_quests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`players_has_quests` (
  `players_idplayers` INT NOT NULL,
  `quests_idquests` INT NOT NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT false,
  `cash_amount` DECIMAL(10,2) NOT NULL,
  `energy_amount` INT NOT NULL,
  `last_place` INT NOT NULL,
  PRIMARY KEY (`players_idplayers`, `quests_idquests`),
  INDEX `fk_players_has_quests_quests1_idx` (`quests_idquests` ASC),
  INDEX `fk_players_has_quests_players1_idx` (`players_idplayers` ASC),
  INDEX `fk_players_has_quests_places1_idx` (`last_place` ASC),
  CONSTRAINT `fk_players_has_quests_players1`
    FOREIGN KEY (`players_idplayers`)
    REFERENCES `test`.`players` (`idplayers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_players_has_quests_quests1`
    FOREIGN KEY (`quests_idquests`)
    REFERENCES `test`.`quests` (`idquests`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_players_has_quests_places1`
    FOREIGN KEY (`last_place`)
    REFERENCES `test`.`places` (`idplaces`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`placesrisks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`placesrisks` (
  `idrisks` INT NOT NULL AUTO_INCREMENT,
  `places_idplaces` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2048) NULL,
  `risk_factor` DECIMAL(10,5) NULL,
  `frequency` DECIMAL(4,2) NOT NULL DEFAULT 1,
  `data` VARCHAR(10240) NULL,
  `cash_cost` DECIMAL(10,2) NOT NULL,
  `energy_cost` INT NOT NULL,
  PRIMARY KEY (`idrisks`),
  INDEX `fk_risks_copy1_places1_idx` (`places_idplaces` ASC),
  CONSTRAINT `fk_risks_copy1_places1`
    FOREIGN KEY (`places_idplaces`)
    REFERENCES `test`.`places` (`idplaces`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`insurances_has_placesrisks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`insurances_has_placesrisks` (
  `insurances_idinsurances` INT NOT NULL,
  `placesrisks_idrisks` INT NOT NULL,
  `cover` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`insurances_idinsurances`, `placesrisks_idrisks`),
  INDEX `fk_insurances_has_placesrisks_placesrisks1_idx` (`placesrisks_idrisks` ASC),
  INDEX `fk_insurances_has_placesrisks_insurances1_idx` (`insurances_idinsurances` ASC),
  CONSTRAINT `fk_insurances_has_placesrisks_insurances1`
    FOREIGN KEY (`insurances_idinsurances`)
    REFERENCES `test`.`insurances` (`idinsurances`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_insurances_has_placesrisks_placesrisks1`
    FOREIGN KEY (`placesrisks_idrisks`)
    REFERENCES `test`.`placesrisks` (`idrisks`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`turns_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`turns_history` (
  `players_has_quests_players_idplayers` INT NOT NULL,
  `players_has_quests_quests_idquests` INT NOT NULL,
  `places_has_transports_places_origin` INT NOT NULL,
  `places_has_transports_transportation` INT NOT NULL,
  `places_has_transports_places_destination` INT NOT NULL,
  PRIMARY KEY (`players_has_quests_players_idplayers`, `players_has_quests_quests_idquests`, `places_has_transports_places_origin`, `places_has_transports_transportation`, `places_has_transports_places_destination`),
  INDEX `fk_players_has_quests_has_places_has_transports_places_has__idx` (`places_has_transports_places_origin` ASC, `places_has_transports_transportation` ASC, `places_has_transports_places_destination` ASC),
  INDEX `fk_players_has_quests_has_places_has_transports_players_has_idx` (`players_has_quests_players_idplayers` ASC, `players_has_quests_quests_idquests` ASC),
  CONSTRAINT `fk_players_has_quests_has_places_has_transports_players_has_q1`
    FOREIGN KEY (`players_has_quests_players_idplayers` , `players_has_quests_quests_idquests`)
    REFERENCES `test`.`players_has_quests` (`players_idplayers` , `quests_idquests`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_players_has_quests_has_places_has_transports_places_has_tr1`
    FOREIGN KEY (`places_has_transports_places_origin` , `places_has_transports_transportation` , `places_has_transports_places_destination`)
    REFERENCES `test`.`places_has_transports` (`places_origin` , `transportation` , `places_destination`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`quest_insurances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`quest_insurances` (
  `players_has_quests_players_idplayers` INT NOT NULL,
  `players_has_quests_quests_idquests` INT NOT NULL,
  `insurances_idinsurances` INT NOT NULL,
  PRIMARY KEY (`players_has_quests_players_idplayers`, `players_has_quests_quests_idquests`, `insurances_idinsurances`),
  INDEX `fk_players_has_quests_has_insurances_insurances1_idx` (`insurances_idinsurances` ASC),
  INDEX `fk_players_has_quests_has_insurances_players_has_quests1_idx` (`players_has_quests_players_idplayers` ASC, `players_has_quests_quests_idquests` ASC),
  CONSTRAINT `fk_players_has_quests_has_insurances_players_has_quests1`
    FOREIGN KEY (`players_has_quests_players_idplayers` , `players_has_quests_quests_idquests`)
    REFERENCES `test`.`players_has_quests` (`players_idplayers` , `quests_idquests`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_players_has_quests_has_insurances_insurances1`
    FOREIGN KEY (`insurances_idinsurances`)
    REFERENCES `test`.`insurances` (`idinsurances`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`turns_history_has_placesrisks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`turns_history_has_placesrisks` (
  `turns_history_players_has_quests_players_idplayers` INT NOT NULL,
  `turns_history_players_has_quests_quests_idquests` INT NOT NULL,
  `turns_history_places_has_transports_places_origin` INT NOT NULL,
  `turns_history_places_has_transports_transportation` INT NOT NULL,
  `turns_history_places_has_transports_places_destination` INT NOT NULL,
  `placesrisks_idrisks` INT NOT NULL,
  PRIMARY KEY (`turns_history_players_has_quests_players_idplayers`, `turns_history_players_has_quests_quests_idquests`, `turns_history_places_has_transports_places_origin`, `turns_history_places_has_transports_transportation`, `turns_history_places_has_transports_places_destination`, `placesrisks_idrisks`),
  INDEX `fk_turns_history_has_placesrisks_placesrisks1_idx` (`placesrisks_idrisks` ASC),
  INDEX `fk_turns_history_has_placesrisks_turns_history1_idx` (`turns_history_players_has_quests_players_idplayers` ASC, `turns_history_players_has_quests_quests_idquests` ASC, `turns_history_places_has_transports_places_origin` ASC, `turns_history_places_has_transports_transportation` ASC, `turns_history_places_has_transports_places_destination` ASC),
  CONSTRAINT `fk_turns_history_has_placesrisks_turns_history1`
    FOREIGN KEY (`turns_history_players_has_quests_players_idplayers` , `turns_history_players_has_quests_quests_idquests` , `turns_history_places_has_transports_places_origin` , `turns_history_places_has_transports_transportation` , `turns_history_places_has_transports_places_destination`)
    REFERENCES `test`.`turns_history` (`players_has_quests_players_idplayers` , `players_has_quests_quests_idquests` , `places_has_transports_places_origin` , `places_has_transports_transportation` , `places_has_transports_places_destination`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turns_history_has_placesrisks_placesrisks1`
    FOREIGN KEY (`placesrisks_idrisks`)
    REFERENCES `test`.`placesrisks` (`idrisks`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`turns_history_has_transportationrisks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`turns_history_has_transportationrisks` (
  `turns_history_players_has_quests_players_idplayers` INT NOT NULL,
  `turns_history_players_has_quests_quests_idquests` INT NOT NULL,
  `turns_history_places_has_transports_places_origin` INT NOT NULL,
  `turns_history_places_has_transports_transportation` INT NOT NULL,
  `turns_history_places_has_transports_places_destination` INT NOT NULL,
  `transportationrisks_idrisks` INT NOT NULL,
  PRIMARY KEY (`turns_history_players_has_quests_players_idplayers`, `turns_history_players_has_quests_quests_idquests`, `turns_history_places_has_transports_places_origin`, `turns_history_places_has_transports_transportation`, `turns_history_places_has_transports_places_destination`, `transportationrisks_idrisks`),
  INDEX `fk_turns_history_has_transportationrisks_transportationrisk_idx` (`transportationrisks_idrisks` ASC),
  INDEX `fk_turns_history_has_transportationrisks_turns_history1_idx` (`turns_history_players_has_quests_players_idplayers` ASC, `turns_history_players_has_quests_quests_idquests` ASC, `turns_history_places_has_transports_places_origin` ASC, `turns_history_places_has_transports_transportation` ASC, `turns_history_places_has_transports_places_destination` ASC),
  CONSTRAINT `fk_turns_history_has_transportationrisks_turns_history1`
    FOREIGN KEY (`turns_history_players_has_quests_players_idplayers` , `turns_history_players_has_quests_quests_idquests` , `turns_history_places_has_transports_places_origin` , `turns_history_places_has_transports_transportation` , `turns_history_places_has_transports_places_destination`)
    REFERENCES `test`.`turns_history` (`players_has_quests_players_idplayers` , `players_has_quests_quests_idquests` , `places_has_transports_places_origin` , `places_has_transports_transportation` , `places_has_transports_places_destination`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turns_history_has_transportationrisks_transportationrisks1`
    FOREIGN KEY (`transportationrisks_idrisks`)
    REFERENCES `test`.`transportationrisks` (`idrisks`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
