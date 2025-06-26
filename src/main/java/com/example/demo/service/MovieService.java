package com.example.demo.service;

import com.example.demo.modal.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(final Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(final String id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(final String id, final Movie updatedMovie) {
        if (movieRepository.existsById(id)) {
            updatedMovie.setId(id);
            return movieRepository.save(updatedMovie);
        }
        return null;
    }

    public void deleteMovie(final String id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> findByWinnerIgnoreCase() {
        List<Movie> winningMovies = movieRepository.findByWinnerIgnoreCase("yes");

        List<Movie> sortedWinningMovies = winningMovies.stream()
                .sorted((movie1, movie2) -> {
                    int producerComparison = movie1.getProducers().compareTo(movie2.getProducers());
                    if (producerComparison != 0) {
                        return producerComparison;
                    }
                    return movie1.getYear().compareTo(movie2.getYear());
                })
                .toList();


        return  sortedWinningMovies.stream()
                .collect(Collectors.groupingBy(Movie::getProducers))
                .values().stream()
                .filter(group -> group.stream().map(Movie::getYear).distinct().count() > 1)
                .flatMap(List::stream)
                .toList();
    }
}
