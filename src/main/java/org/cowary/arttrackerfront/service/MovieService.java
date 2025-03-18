package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.config.ConfigApp;
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
    @Autowired
    private ConfigApp configApp;
    private final String PATH = "/title/movie";

    @Override
    public Movie getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/" + titleId, Movie.class
        );
        return response.getBody();
    }

    @Override
    public Movie postMedia(Movie media) {
        var response = restTemp.postWithToken(
                configApp.getBackUrl() + PATH, media, Movie.class
        );
        return response.getBody();
    }

    @Override
    public Movie putMedia(Movie media) {
        var response = restTemp.put(
                configApp.getBackUrl() + PATH, media, Movie.class
        );
        return response.getBody();
    }

    @Override
    public String deleteMedia(long id) {
        var response = restTemp.delete(
                configApp.getBackUrl() + PATH, Map.of("id", id), String.class
        );
        return response.getBody();
    }

    @Override
    public FindMediaRs find(String keyword) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/find", FindMediaRs.class, Map.of("keyword", keyword)
        );
        return response.getBody();
    }

    @Override
    public MovieRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/getByServiceId", MovieRs.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
