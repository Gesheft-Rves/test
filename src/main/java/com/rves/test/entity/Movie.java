package com.rves.test.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


public class Movie {

    private Integer id;

    @JsonProperty("vote_count")
    private Integer voteCount;

    private boolean video;

    @JsonProperty("vote_average")
    private double voteAverage;

    private String title;

    private double popularity;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("genre_ids")
    private int [] genreIds;

    private boolean adult;

    private String overview;

    @JsonProperty("release_date")
    private int [] releaseDate;

    public Movie() {
    }

    public Movie(Integer id, Integer voteCount, boolean video, double voteAverage, String title, double popularity, String originalLanguage, String originalTitle, int[] genreIds, boolean adult, String overview, int[] releaseDate) {
        this.id = id;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(int[] genreIds) {
        this.genreIds = genreIds;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int[] getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int[] releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", voteCount=" + voteCount +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", title='" + title + '\'' +
                ", popularity=" + popularity +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", genreIds=" + Arrays.toString(genreIds) +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", releaseDate=" + Arrays.toString(releaseDate) +
                '}';
    }

}
