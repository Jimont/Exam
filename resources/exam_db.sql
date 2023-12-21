-- MySQL Workbench Synchronization
-- Generated: 2023-12-21 16:46
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: jimon

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `db_exam` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `db_exam`.`tbl_exams` (
  `exam_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `exam_name` VARCHAR(45) NULL DEFAULT NULL,
  `exam_date` TIMESTAMP NULL DEFAULT NULL,
  `time_zone` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`exam_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_exam`.`tbl_students` (
  `student_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `document_id` BIGINT(20) NULL DEFAULT NULL,
  `full_name` VARCHAR(150) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `city` VARCHAR(100) NULL DEFAULT NULL,
  `time_zone` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_exam`.`tbl_questions` (
  `question_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `exam_id` BIGINT(20) NULL DEFAULT NULL,
  `question_description` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  INDEX `fk_ExamQuestion_idx` (`exam_id` ASC) VISIBLE,
  CONSTRAINT `fk_ExamQuestion`
    FOREIGN KEY (`exam_id`)
    REFERENCES `db_exam`.`tbl_exams` (`exam_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_exam`.`tbl_studen_exam` (
  `student_exam_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `exam_date` TIMESTAMP NULL DEFAULT NULL,
  `exam_id` BIGINT(20) NULL DEFAULT NULL,
  `student_id` BIGINT(20) NULL DEFAULT NULL,
  `calification` DECIMAL(8,2) NULL DEFAULT NULL,
  PRIMARY KEY (`student_exam_id`),
  INDEX `fk_stuexam_idx` (`exam_id` ASC) VISIBLE,
  INDEX `fk_examstu_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_stuexam`
    FOREIGN KEY (`exam_id`)
    REFERENCES `db_exam`.`tbl_exams` (`exam_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examstu`
    FOREIGN KEY (`student_id`)
    REFERENCES `db_exam`.`tbl_students` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_exam`.`tbl_students_responses` (
  `students_responses_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `student_exam_id` BIGINT(20) NULL DEFAULT NULL,
  `question_id` BIGINT(20) NULL DEFAULT NULL,
  `response` VARCHAR(45) NULL DEFAULT NULL,
  `score_response` DECIMAL(8,2) NULL DEFAULT NULL,
  PRIMARY KEY (`students_responses_id`),
  INDEX `fk_responseexam_idx` (`student_exam_id` ASC) VISIBLE,
  CONSTRAINT `fk_responseexam`
    FOREIGN KEY (`student_exam_id`)
    REFERENCES `db_exam`.`tbl_studen_exam` (`student_exam_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_exam`.`tbl_answers` (
  `answer_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `identification_letter` VARCHAR(45) NULL DEFAULT NULL,
  `answer_description` VARCHAR(200) NULL DEFAULT NULL,
  `question_id` BIGINT(20) NULL DEFAULT NULL,
  `score_answer` DECIMAL(8,2) NULL DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  INDEX `fkquestionanswer_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `fkquestionanswer`
    FOREIGN KEY (`question_id`)
    REFERENCES `db_exam`.`tbl_questions` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
