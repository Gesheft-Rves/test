package com.rves.test.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovieList {

    private Integer page;

    @JsonProperty("total_results")
    private Integer totalResults;

    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("results")
    private ArrayList<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
    }

    public MovieList(Integer page, Integer totalResults, Integer totalPages, ArrayList<Movie> results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movies = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

}
