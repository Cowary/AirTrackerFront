package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.manga.Manga;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MangaService implements MediaService<Manga>, FindService<Manga> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/manga";

    @Override
    public Manga getMedia(long titleId) {
        var response = restTemp.get(
                PATH + "/" + titleId, Manga.class
        );
        return response.getBody();
    }

    @Override
    public Manga postMedia(Manga media) {
        var response = restTemp.post(
                PATH, media, Manga.class
        );
        return response.getBody();
    }

    @Override
    public Manga putMedia(Manga media) {
        var response = restTemp.put(
                PATH, media, Manga.class
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
    public Manga getByMediaId(long id) {
        var response = restTemp.get(
                PATH + "/getByServiceId", Manga.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
