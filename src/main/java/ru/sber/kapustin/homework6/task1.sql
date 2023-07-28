CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birthdate DATE,
    phone VARCHAR(20) UNIQUE,
    email VARCHAR(50) UNIQUE,
    books TEXT[]
);
