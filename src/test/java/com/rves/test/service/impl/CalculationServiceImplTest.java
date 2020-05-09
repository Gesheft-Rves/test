package com.rves.test.service.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rves.test.entity.Movie;
import com.rves.test.entity.TemporaryResult;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

class CalculationServiceImplTest {

    CalculationServiceImpl service = new CalculationServiceImpl();

    static class MovieDto{
        @JsonProperty("results")
        List<Movie> movies;

        public List<Movie> getMovies() {
            return movies;
        }
    }

    @Test
    void calculation() {
        double expected = 7.8;
        double actual;

        ClassLoader classLoader = getClass().getClassLoader();
        ObjectMapper objectMapper = new ObjectMapper();
        MovieDto movieDto = new MovieDto();

        TemporaryResult result;

        try {
            File file = new File(classLoader.getResource("json").getFile());
            movieDto = objectMapper.readValue(file, MovieDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!movieDto.getMovies().isEmpty()){
            result = service.calculation(movieDto.getMovies(),18);

            actual = result.getAverageRatingByGenre();
            DecimalFormat f = new DecimalFormat("###.0");

            Assert.assertEquals(f.format(expected), f.format(actual));
        }
    }



}