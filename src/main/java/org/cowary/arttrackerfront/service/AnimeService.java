package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnimeService implements FindService<Anime>, MediaService<Anime> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/anime";

    public List<Anime> getAllByUsrId(long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("userId", "3");
        var response = restTemp.get(Config.getBackUrl() + PATH, headers, Anime[].class);
        return List.of(response.getBody());
    }

    @Override
    public FindMediaRs find(String keyword) {
        var response = restTemp.get(
                PATH + "/find", FindMediaRs.class, Map.of("keyword", keyword)
        );
        return response.getBody();
    }

    @Override
    public Anime getByMediaId(long id) {
        var response = restTemp.get(
                PATH + "/getByServiceId", Anime.class, Map.of("id", id)
        );
        return response.getBody();
    }

    @Override
    public Anime getMedia(long titleId) {
        var response = restTemp.get(
                PATH + "/" + titleId, Anime.class
        );
        return response.getBody();
    }

    @Override
    public Anime postMedia(Anime media) {
        var response = restTemp.post(
                PATH, media, Anime.class
        );
        return response.getBody();
    }

    @Override
    public Anime putMedia(Anime media) {
        var response = restTemp.put(
                PATH, media, Anime.class
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
}
