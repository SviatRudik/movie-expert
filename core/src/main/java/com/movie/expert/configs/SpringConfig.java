package com.movie.expert.configs;


import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.movie.expert")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
    private final DatabaseConfig dbConfig;

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext, DatabaseConfig dbConfig) {
        this.applicationContext = applicationContext;
        this.dbConfig = dbConfig;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setUsername(dbConfig.getUser());
        dataSource.setPassword(dbConfig.getPassword());

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public Flyway flyway() {
        Flyway flyway = Flyway.configure().dataSource(dataSource()).locations("classpath:db.migrations").load();
        flyway.migrate();
        return flyway;
    }
}