package com.rves.test.entity.response;


public class InfoResponse {
    private Integer quantityMoviesRead;
    private double averageRatingByGenre;
    private String msg;

    public InfoResponse(Integer quantityMoviesRead, double averageRatingByGenre) {
            this.quantityMoviesRead = quantityMoviesRead;
            this.averageRatingByGenre = averageRatingByGenre;
            this.msg = "in progress...";
    }

    public InfoResponse(String msg) {
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

    @Override
    public String toString() {
        return "Response{" +
                "quantityMoviesRead=" + quantityMoviesRead +
                ", averageRatingByGenre=" + averageRatingByGenre +
                ", msg='" + msg + '\'' +
                '}';
    }
}

