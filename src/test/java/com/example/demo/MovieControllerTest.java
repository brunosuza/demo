package com.example.demo;

import com.example.demo.modal.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;

    @Test
    void createMovie() {

        Movie movie = new Movie();
        movie.setId(UUID.randomUUID().toString());
        movie.setTitle("Bolero");
        movie.setYear(1984);
        movie.setStudios("Cannon Films");
        movie.setProducers("Bo Derek");
        movie.setWinner("yes");

        var result = movieController.createMovie(movie);

        assertNotNull(result);
        assertNotNull(result.getId());

    }

    @Test
    void getAllMovies() {
    }

    @Test
    void getMovieById() {
    }

    @Test
    void updateMovie() {
    }

    @Test
    void deleteMovie() {
    }

    @Test
    void getWinningMovies() {
    }
}