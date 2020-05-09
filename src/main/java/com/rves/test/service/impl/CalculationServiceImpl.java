package com.rves.test.service.impl;

import com.rves.test.entity.Movie;
import com.rves.test.entity.TemporaryResult;
import com.rves.test.service.CalculationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public TemporaryResult calculation(List<Movie> movies, Integer genreId) {
        double sumRating = 0.0 ;
        int quantityMoviesRead = 0;

        for (Movie m : movies) {
            for (int id : m.getGenreIds()) {
                if (id == genreId) {
                    sumRating += m.getVoteAverage();
                    quantityMoviesRead++;
                    break;
                }
            }
        }
        return  new TemporaryResult(quantityMoviesRead, sumRating);
    }
}
