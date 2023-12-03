package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.MovieRs;
import org.cowary.arttrackerfront.entity.movie.Movie;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MovieService implements MediaService<Movie>, FindService<MovieRs> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = Config.getBackUrl() + "/title/movie";

    @Override
    public Movie getMedia(long titleId) {
        var response = restTemp.getWithQuery(
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
        var response = restTemp.getWithQuery(
                PATH + "/find", FindMediaRs.class, Map.of("keyword", keyword)
        );
        return response.getBody();
    }

    @Override
    public MovieRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                PATH + "/getByServiceId", MovieRs.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
