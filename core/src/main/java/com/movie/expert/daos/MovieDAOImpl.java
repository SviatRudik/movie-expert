package com.movie.expert.daos;

import com.movie.expert.models.Genre;
import com.movie.expert.models.ExternalMovie;
import com.movie.expert.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository

public class MovieDAOImpl implements MovieDAO {
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert movieInsert;
    private SimpleJdbcInsert genreInsert;
    private Integer DEFAULT_PAGE_SIZE = 10;

    @Autowired
    public MovieDAOImpl(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
        movieInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("movies").usingGeneratedKeyColumns("id");
        genreInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("genres").usingGeneratedKeyColumns("id");
    }

    @Override
    public long addMovie(ExternalMovie movie) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", movie.getTitle());
        parameters.put("release_date", movie.getReleaseDate());
        parameters.put("poster_path", movie.getPosterPath());
        parameters.put("overview", movie.getOverview());
        parameters.put("tmdb_rating", movie.getVoteAverage());
        parameters.put("external_id", movie.getId());

        Number generatedId = movieInsert.executeAndReturnKey(parameters);

        return generatedId.longValue();
    }

    @Override
    public Integer addGenre(Genre genre) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", genre.getName());

        Number generatedId = genreInsert.executeAndReturnKey(parameters);

        return generatedId.intValue();
    }

    @Override
    public void addGenreMovie(long movieId, Integer genreId) {
        String sql =
                "INSERT INTO movie_genres (movie_id, genre_id) " +
                        "VALUES (?, ?)";
        jdbcTemplate.update(sql, movieId, genreId);
    }

    @Override
    public Optional<Genre> findGenre(String genreName) {
        String sql = "SELECT id, name " +
                "FROM genres " +
                "WHERE name = ?;";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Genre.class), genreName).stream().findAny();
    }

    @Override
    public Optional<Movie> findMovieByExternalId(long externalId) {
        String sql = "SELECT m.*, AVG(r.rating) AS rating, STRING_AGG(DISTINCT (g.name),',') AS genres  " +
                "FROM movies m " +
                "LEFT JOIN reviews r ON m.id = r.movie_id " +
                "LEFT JOIN movie_genres mg ON m.id = mg.movie_id " +
                "LEFT JOIN genres g ON mg.genre_id = g.id " +
                "WHERE m.external_id = ? " +
                "GROUP BY m.id";
        return jdbcTemplate.query(sql, new MovieRowMapper(), externalId).stream().findAny();
    }

    @Override
    public List<Movie> getMovies(Integer page) {
        Integer offset = (page - 1) * DEFAULT_PAGE_SIZE;
        String sql = "SELECT m.*, AVG(r.rating) AS rating, STRING_AGG(DISTINCT (g.name),',') AS genres  " +
                "FROM movies m " +
                "LEFT JOIN reviews r ON m.id = r.movie_id " +
                "LEFT JOIN movie_genres mg ON m.id = mg.movie_id " +
                "LEFT JOIN genres g ON mg.genre_id = g.id " +
                "GROUP BY m.id LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new MovieRowMapper(), DEFAULT_PAGE_SIZE, offset);
    }

    @Override
    public Integer getTotalMoviePageCount() {
        String sql = "SELECT COUNT(*) FROM movies";
        Integer amountOfReviews = jdbcTemplate.queryForObject(sql, Integer.class);
        Integer result = amountOfReviews / DEFAULT_PAGE_SIZE;
        return result;
    }

    private static class MovieRowMapper implements RowMapper<Movie> {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setId(rs.getLong("id"));
            movie.setExternalId(rs.getLong("external_id"));
            movie.setTitle(rs.getString("title"));
            movie.setTmdbRating(rs.getDouble("tmdb_rating"));
            movie.setPosterPath(rs.getString("poster_path"));
            movie.setOverview(rs.getString("overview"));
            movie.setReleaseDate(rs.getString("release_date"));
            movie.setRating(rs.getDouble("rating"));

            String genresString = rs.getString("genres");
            if (genresString != null) {
                String[] genresArray = genresString.split(",");
                List<Genre> genres = new ArrayList<>();
                for (String genreName : genresArray) {
                    Genre genre = new Genre();
                    genre.setName(genreName);
                    genres.add(genre);
                }
                movie.setGenres(genres);
            }
            return movie;
        }

    }
}
