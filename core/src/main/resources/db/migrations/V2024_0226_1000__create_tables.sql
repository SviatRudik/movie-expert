CREATE TABLE posts
(
    post_id SERIAL PRIMARY KEY,
    user_id BIGINT,
    title   VARCHAR(255) NOT NULL,
    content TEXT,
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