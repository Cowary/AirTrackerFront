package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.TvRs;
import org.cowary.arttrackerfront.entity.tv.Tv;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TvService implements MediaService<Tv>, FindService<TvRs> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/tv";

    @Override
    public Tv getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                PATH + "/" + titleId, Tv.class
        );
        return response.getBody();
    }

    @Override
    public Tv postMedia(Tv media) {
        var response = restTemp.post(
                PATH, media, Tv.class
        );
        return response.getBody();
    }

    @Override
    public Tv putMedia(Tv media) {
        var response = restTemp.put(
                PATH, media, Tv.class
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
    public TvRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                PATH + "/getByServiceId", TvRs.class, Map.of("id", id)
        );
        return response.getBody();
    }

    @Override
    public String getPosterUrl(int id) {
        var response = restTemp.getWithQuery(
                PATH + "/getPoster", String.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
