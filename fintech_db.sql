CREATE DATABASE IF NOT EXISTS fintech_db;
USE fintech_db;

CREATE TABLE IF NOT EXISTS users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100),
        phone VARCHAR(20) UNIQUE,
        balance DOUBLE
);