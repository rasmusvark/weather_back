-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-19 03:37:32.43

-- tables
-- Table: city
CREATE TABLE city
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: weather_data
CREATE TABLE weather_info
(
    id          serial        NOT NULL,
    city_id     int           NOT NULL,
    temperature decimal       NOT NULL,
    wind_speed  decimal(5, 2) NOT NULL,
    humidity    decimal(5, 2) NOT NULL,
    time        timestamp     NOT NULL,
    CONSTRAINT weather_info_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: weather_data_city (table: weather_data)
ALTER TABLE weather_info
    ADD CONSTRAINT weather_info_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.