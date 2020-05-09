package com.rves.test.service.impl;

import com.rves.test.entity.*;
import com.rves.test.service.TaskService;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class TaskServiceImpl implements TaskService {
    private static final String URL_MOVIES = "https://easy.test-assignment-a.loyaltyplant.net/3/discover/movie?api_key=72b56103e43843412a992a8d64bf96e9&page=";
    private volatile boolean stop = false;

    private TemporaryResult temporaryResult = new TemporaryResult();
    private final RestTemplate restTemplate = new RestTemplate();

    private final CalculationServiceImpl calculationServiceImpl = new CalculationServiceImpl() ;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public TemporaryResult calculation (int genreId){
        double sumVoteAverage = 0.0 ;
        Integer countMovie = 0;

        MovieList resp = restTemplate.getForObject(URL_MOVIES + 1, MovieList.class);
        Integer totalPages = Objects.requireNonNull(resp).getTotalPages();
        String newUrl;

        for (int i = 1; i < totalPages; i++) {

            if (stop) {
                break;
            }

            newUrl = URL_MOVIES + i;
            MovieList response = restTemplate.getForObject(newUrl, MovieList.class);
            Objects.requireNonNull(response);

            if (response.getMovies() == null || response.getMovies().isEmpty()){
                continue;
            }

            temporaryResult = calculationServiceImpl.calculation(response.getMovies(),genreId);
            sumVoteAverage += temporaryResult.getTotalRating() ;
            countMovie += temporaryResult.getQuantityMoviesRead();

            this.temporaryResult.setAverageRatingByGenre(sumVoteAverage/countMovie);
            this.temporaryResult.setQuantityMoviesRead(countMovie);

        }
        return temporaryResult;
    }

    public TemporaryResult getTemporaryResult() {
        return temporaryResult;
    }

}
