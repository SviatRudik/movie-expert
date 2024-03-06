CREATE TABLE users
(
    id                      SERIAL PRIMARY KEY,
    username                VARCHAR(255) UNIQUE NOT NULL,
    password                VARCHAR(100)        NOT NULL CHECK (LENGTH(password) >= 6),
    email                   VARCHAR(100) UNIQUE NOT NULL CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$'),
    account_non_expired     BOOLEAN,
    account_non_locked      BOOLEAN,
    credentials_non_expired BOOLEAN,
    enabled                 BOOLEAN
);
