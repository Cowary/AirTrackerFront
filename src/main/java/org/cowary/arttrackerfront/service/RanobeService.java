package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.ranobe.Ranobe;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class RanobeService implements MediaService<Ranobe>, FindService<Ranobe> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/ranobe";

    @Override
    public Ranobe getMedia(long titleId) {
        var response = restTemp.get(
                PATH + "/" + titleId, Ranobe.class
        );
        return response.getBody();
    }

    @Override
    public Ranobe postMedia(Ranobe media) {
        var response = restTemp.post(
                PATH, media, Ranobe.class
        );
        return response.getBody();
    }

    @Override
    public Ranobe putMedia(Ranobe media) {
        var response = restTemp.put(
                PATH, media, Ranobe.class
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
    public Ranobe getByMediaId(long id) {
        var response = restTemp.get(
                PATH + "/getByServiceId", Ranobe.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
