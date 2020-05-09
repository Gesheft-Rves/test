package com.rves.test.entity.response;

public class StopResponse {
    private Integer quantityMoviesRead;
    private double averageRatingByGenre;
    private String msg;

    public StopResponse(Integer quantityMoviesRead, double averageRatingByGenre) {
        this.quantityMoviesRead = quantityMoviesRead;
        this.averageRatingByGenre = averageRatingByGenre;
        this.msg = "interrupted by the user";
    }

    public StopResponse(String msg) {
        this.msg = msg;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
