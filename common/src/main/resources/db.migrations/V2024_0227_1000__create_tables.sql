CREATE TABLE posts
(
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title   VARCHAR(100) NOT NULL,
    content TEXT,
    mark INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TABLE movies
(
    id       SERIAL PRIMARY KEY,
    title    VARCHAR(255) NOT NULL,
    year     INT,
    director VARCHAR(255),
    genre    VARCHAR(255)
);


CREATE TABLE subscriptions
(
    subscription_id    SERIAL PRIMARY KEY,
    user_id            BIGINT,
    subscribed_user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (subscribed_user_id) REFERENCES users (id),
    UNIQUE (user_id, subscribed_user_id)
);