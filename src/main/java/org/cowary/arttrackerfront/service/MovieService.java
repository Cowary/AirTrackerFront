package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.movie.Movie;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MovieService implements MediaService<Movie>, FindService<Movie> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/movie";

    @Override
    public Movie getMedia(long titleId) {
        var response = restTemp.get(
                PATH + "/" + titleId, Movie.class
        );
        return response.getBody();
    }

    @Override
    public Movie postMedia(Movie media) {
        var response = restTemp.post(
                PATH, media, Movie.class
        );
        return response.getBody();
    }

    @Override
    public Movie putMedia(Movie media) {
        var response = restTemp.put(
                PATH, media, Movie.class
        );
        return response.getBody();
    }

    @Override
    public String deleteMedia(long id) {
        var response = restTemp.delete(
                PATH, Map.of("id", id), String.class
        );
        return response.getBody();
    }

    @Override
    public FindMediaRs find(String keyword) {
        var response = restTemp.get(
                PATH + "/find", FindMediaRs.class, Map.of("keyword", keyword)
        );
        return response.getBody();
    }

    @Override
    public Movie getByMediaId(long id) {
        var response = restTemp.get(
                PATH + "/getByServiceId", Movie.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
