
CREATE TABLE posts (
                       post_id SERIAL PRIMARY KEY,
                       user_id INT,
                       title VARCHAR(255) NOT NULL,
                       content TEXT,
                       FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE movies (
                        movie_id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        year INT,
                        director VARCHAR(255),
                        genre VARCHAR(255)
);


CREATE TABLE subscriptions (
                               subscription_id SERIAL PRIMARY KEY,
                               user_id INT,
                               subscribed_user_id INT,
                               FOREIGN KEY (user_id) REFERENCES users(user_id),
                               FOREIGN KEY (subscribed_user_id) REFERENCES users(user_id),
                               UNIQUE (user_id, subscribed_user_id)
);