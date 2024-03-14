CREATE TABLE movies
(
    id           SERIAL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    release_date DATE,
    poster_path  VARCHAR(255),
    overview     TEXT,
    tmdb_rating  NUMERIC,
    external_id  BIGINT       NOT NULL
);

CREATE TABLE reviews
(
    id         SERIAL PRIMARY KEY,
    user_id    BIGINT       NOT NULL,
    movie_id   BIGINT       NOT NULL,
    title      VARCHAR(100) NOT NULL,
    content    TEXT,
    rating     INT          NOT NULL CHECK (rating > 0 AND rating < 6),
    created_at TIMESTAMP    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE subscriptions
(
    user_id            BIGINT,
    subscribed_user_id BIGINT,
    PRIMARY KEY (user_id, subscribed_user_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (subscribed_user_id) REFERENCES users (id),
    UNIQUE (user_id, subscribed_user_id)
);

CREATE TABLE genres
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE movie_genres
(
    movie_id BIGINT,
    genre_id INT,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);