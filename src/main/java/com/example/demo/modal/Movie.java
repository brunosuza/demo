package com.example.demo.modal;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Movie {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String title;
    @Column(name = "release_year")
    private Integer year;
    private String studios;
    private String producers;
    private String winner;

    public Movie() {}

    public Movie(final String id, final String title, final Integer year, final String studios, final String producers, final String winner) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.studios = studios;
        this.producers = producers;
        this.winner = winner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}