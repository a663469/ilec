-- CREATE DATABASE ilec;

DROP TABLE ilec.specific_components;
DROP TABLE ilec.components;
DROP TABLE ilec.sch_symbol_ref;
DROP TABLE ilec.footprint_ref;
DROP TABLE ilec.manufacturer_ref;
DROP TABLE ilec.part_status_ref;
DROP TABLE ilec.temp_range_ref;


CREATE TABLE ilec.sch_symbol_ref (
    id int NOT NULL AUTO_INCREMENT,
    sch_symbol_name varchar(100),
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.footprint_ref (
    id int NOT NULL AUTO_INCREMENT,
    footprint_name varchar(100),
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.manufacturer_ref (
    id int NOT NULL AUTO_INCREMENT,
    manufacturer varchar(100),
    country varchar(100),
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.part_status_ref (
    id int NOT NULL AUTO_INCREMENT,
    part_status varchar(100),
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.temp_range_ref (
    id int NOT NULL AUTO_INCREMENT,
    min_temp int,
    max_temp int,
    PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.components (
    id int NOT NULL AUTO_INCREMENT,
    component_name varchar(100),
    sch_symbol_id int NOT NULL,
    footprint_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sch_symbol_id) REFERENCES ilec.sch_symbol_ref(id),
    FOREIGN KEY (footprint_id) REFERENCES ilec.footprint_ref(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.specific_components (
    id int NOT NULL AUTO_INCREMENT,
    part_number varchar(100),
    help_url varchar(100),
    component_id int NOT NULL,
    manufacturer_id int NOT NULL,
    part_status_id int NOT NULL,
    temp_range_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (component_id) REFERENCES ilec.components(id),
    FOREIGN KEY (manufacturer_id) REFERENCES ilec.manufacturer_ref(id),
    FOREIGN KEY (part_status_id) REFERENCES ilec.part_status_ref(id),
    FOREIGN KEY (temp_range_id) REFERENCES ilec.temp_range_ref(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


--CREATE TABLE ilec.component_ref_list (
--    id int NOT NULL AUTO_INCREMENT,
--    component_ref VARCHAR(255)
--    PRIMARY KEY (id)
--);
--
--CREATE TABLE ilec.group_ref_list (
--    id INT NOT NULL AUTO_INCREMENT,
--    component_id INT,
--    group_ref VARCHAR(255),
--    PRIMARY KEY (id),
--    FOREIGN KEY (component_id) REFERENCES ilec.component_ref_list(id)
--);
--
--CREATE TABLE my_db.details (
--  id int NOT NULL AUTO_INCREMENT,
--  city varchar(15),
--  phone_number varchar(25),
--  email varchar(30),
--  PRIMARY KEY (id)
--);
--
--CREATE TABLE my_db.employees (
--  id int NOT NULL AUTO_INCREMENT,
--  name varchar(15),
--  surname varchar(25),
--  department varchar(20), salary int, details_id int
--,  PRIMARY KEY (id)
--, FOREIGN KEY (details_id) REFERENCES my_db.details(id));
--
--DROP TABLE my_db.details;
--DROP TABLE my_db.employees;
--
--CREATE TABLE my_db.departments (
--  id int NOT NULL AUTO_INCREMENT,
--  name varchar(15),
--  max_salary int,
--  min_salary int,
--  PRIMARY KEY (id)
--);
--
--CREATE TABLE my_db.employees (
--  id int NOT NULL AUTO_INCREMENT,
--  name varchar(15),
--  surname varchar(25),
--  salary int,
--  department_id int,
--  PRIMARY KEY (id),
--  FOREIGN KEY (department_id) REFERENCES my_db.departments(id));
--
--
--CREATE TABLE ilec.CurrentElement (
--	id INT auto_increment NOT NULL,
--	partNumber varchar(100) NOT NULL,
--	PRIMARY KEY (id)
--)
--ENGINE=InnoDB
--DEFAULT CHARSET=utf8mb4
--COLLATE=utf8mb4_0900_ai_ci;