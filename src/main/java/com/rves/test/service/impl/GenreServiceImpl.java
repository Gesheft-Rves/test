package com.rves.test.service.impl;

import com.rves.test.entity.Genre;
import com.rves.test.entity.GenreList;
import com.rves.test.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class GenreServiceImpl implements GenreService {

    private static final String URL_GENRES = "https://easy.test-assignment-a.loyaltyplant.net/3/genre/movie/list?api_key=72b56103e43843412a992a8d64bf96e9";

    @Override
    public List<Genre> getAllGenres(){
        GenreList response = new RestTemplate().getForObject(URL_GENRES, GenreList.class);
        return  Objects.requireNonNull(response).getGenres();
    }
}
