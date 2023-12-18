CREATE SCHEMA IF NOT EXISTS test;
USE test;
    DROP TABLE IF EXISTS employee;
CREATE TABLE employee (id BIGINT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(80), last_name VARCHAR(100), role VARCHAR(100));
INSERT INTO employee(first_name, last_name, role) VALUES ('Sergey', 'Malkov','Go developer');