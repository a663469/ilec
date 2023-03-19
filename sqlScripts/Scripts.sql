-- CREATE DATABASE ilec;

DROP TABLE ilec.specific_components;
DROP TABLE ilec.components;
DROP TABLE ilec.sch_symbol_ref;
DROP TABLE ilec.footprint_ref;
DROP TABLE ilec.manufacturer_ref;
DROP TABLE ilec.part_status_ref;
DROP TABLE ilec.temp_range_ref;
DROP TABLE ilec.category_ref_list;
DROP TABLE ilec.group_ref_list;
DROP TABLE ilec.component_ref_list;

CREATE TABLE ilec.sch_symbol_ref (
    id int NOT NULL AUTO_INCREMENT,
    sch_symbol_name varchar(100),
    PRIMARY KEY (id),
    UNIQUE(sch_symbol_name)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.footprint_ref (
    id int NOT NULL AUTO_INCREMENT,
    footprint_name varchar(100),
    PRIMARY KEY (id),
    UNIQUE(footprint_name)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.manufacturer_ref (
    id int NOT NULL AUTO_INCREMENT,
    manufacturer varchar(100),
    country varchar(100),
    PRIMARY KEY (id),
    UNIQUE(manufacturer, country)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.part_status_ref (
    id int NOT NULL AUTO_INCREMENT,
    part_status varchar(100),
    PRIMARY KEY (id),
    UNIQUE(part_status)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.temp_range_ref (
    id int NOT NULL AUTO_INCREMENT,
    min_temp int,
    max_temp int,
    PRIMARY KEY (id),
    UNIQUE(min_temp, max_temp)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.component_ref_list (
    id int NOT NULL AUTO_INCREMENT,
    component_ref varchar(100),
    PRIMARY KEY (id),
    UNIQUE(component_ref)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.group_ref_list (
    id int NOT NULL AUTO_INCREMENT,
    group_ref varchar(100),
    component_ref_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (component_ref_id) REFERENCES ilec.component_ref_list(id),
    UNIQUE(group_ref, component_ref_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.category_ref_list (
    id int NOT NULL AUTO_INCREMENT,
    category_ref varchar(100),
    group_ref_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (group_ref_id) REFERENCES ilec.group_ref_list(id),
    UNIQUE(category_ref, group_ref_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE ilec.components (
    id int NOT NULL AUTO_INCREMENT,
    component_name varchar(100),
    sch_symbol_id int NOT NULL,
    footprint_id int NOT NULL,
    component_ref_id int NOT NULL,
    group_ref_id int,
    category_ref_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (sch_symbol_id) REFERENCES ilec.sch_symbol_ref(id),
    FOREIGN KEY (footprint_id) REFERENCES ilec.footprint_ref(id),
    FOREIGN KEY (component_ref_id) REFERENCES ilec.component_ref_list(id),
    FOREIGN KEY (group_ref_id) REFERENCES ilec.group_ref_list(id),
    FOREIGN KEY (category_ref_id) REFERENCES ilec.category_ref_list(id),
    UNIQUE(component_name)
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
    FOREIGN KEY (temp_range_id) REFERENCES ilec.temp_range_ref(id),
    UNIQUE(part_number)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;