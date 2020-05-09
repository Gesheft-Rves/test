package com.rves.test.entity;

public class TemporaryResult {
    private Integer quantityMoviesRead;
    private double totalRating;
    private double averageRatingByGenre;

    public TemporaryResult() {
    }

    public TemporaryResult(Integer quantityMoviesRead, double totalRating) {
        this.quantityMoviesRead = quantityMoviesRead;
        this.totalRating = totalRating;
        this.averageRatingByGenre = totalRating/quantityMoviesRead;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getQuantityMoviesRead() {
        return quantityMoviesRead;
    }

    public void setQuantityMoviesRead(Integer quantityMoviesRead) {
        this.quantityMoviesRead = quantityMoviesRead;
    }

    public double getAverageRatingByGenre() {
        return averageRatingByGenre;
    }

    public void setAverageRatingByGenre(double averageRatingByGenre) {
        this.averageRatingByGenre = averageRatingByGenre;
    }

    @Override
    public String toString() {
        return "TemporaryResult{" +
                "quantityMoviesRead=" + quantityMoviesRead +
                ", averageRatingByGenre=" + averageRatingByGenre +
                '}';
    }
}
