package com.example.demo.repository;

import com.example.demo.modal.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByWinnerIgnoreCase(String winner);
}