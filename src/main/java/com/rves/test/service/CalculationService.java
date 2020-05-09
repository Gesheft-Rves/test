package com.rves.test.service;

import com.rves.test.entity.Movie;
import com.rves.test.entity.TemporaryResult;

import java.util.List;

public interface CalculationService {
    TemporaryResult calculation(List<Movie> movies, Integer genreId);
}
