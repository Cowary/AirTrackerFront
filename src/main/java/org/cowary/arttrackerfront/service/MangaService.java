package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.MangaRs;
import org.cowary.arttrackerfront.entity.manga.Manga;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MangaService implements MediaService<Manga>, FindService<MangaRs> {

    @Autowired
    private RestTemp restTemp;
    private final String PATH =  Config.getBackUrl() + "/title/manga";

    @Override
    public Manga getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                PATH + "/" + titleId, Manga.class
        );
        return response.getBody();
    }

    @Override
    public Manga postMedia(Manga media) {
        var response = restTemp.postWithToken(
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
        var response = restTemp.getWithQuery(
                PATH + "/find", FindMediaRs.class, Map.of("keyword", keyword)
        );
        return response.getBody();
    }

    @Override
    public MangaRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                PATH + "/getByServiceId", MangaRs.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
