package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.tv.Tv;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TvService implements MediaService<Tv>, FindService<Tv> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/tv";

    @Override
    public Tv getMedia(long titleId) {
        var response = restTemp.get(
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
        var response = restTemp.get(
                PATH + "/find", FindMediaRs.class, Map.of("keyword", keyword)
        );
        return response.getBody();
    }

    @Override
    public Tv getByMediaId(long id) {
        var response = restTemp.get(
                PATH + "/getByServiceId", Tv.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
