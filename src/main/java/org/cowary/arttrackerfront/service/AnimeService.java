package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.config.ConfigApp;
import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.AnimeRs;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class AnimeService implements FindService<AnimeRs>, MediaService<Anime> {

    @Autowired
    private RestTemp restTemp;
    @Autowired
    private ConfigApp configApp;
    private final String PATH = "/title/anime";

    public List<Anime> getAllByUsrId(long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("userId", "3");
        var response = restTemp.getWithQuery(configApp.getBackUrl() + PATH, headers, Anime[].class);
        return List.of(response.getBody());
    }

    @Override
    public FindMediaRs find(String keyword) {
        var uri = UriComponentsBuilder.fromUriString(configApp.getBackUrl() + PATH + "/find")
                .queryParam("keyword", keyword)
                .build()
                .toString();
        var response = restTemp.getWithQuery(
                uri, FindMediaRs.class
        );
        return response.getBody();
    }

    @Override
    public AnimeRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                 configApp.getBackUrl() + PATH + "/getByServiceId", AnimeRs.class, Map.of("id", id)
        );
        return response.getBody();
    }

    @Override
    public Anime getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                 configApp.getBackUrl() + PATH + "/" + titleId, Anime.class
        );
        return response.getBody();
    }

    @Override
    public Anime postMedia(Anime media) {
        var response = restTemp.postWithToken(
                 configApp.getBackUrl() + PATH, media, Anime.class
        );
        return response.getBody();
    }

    @Override
    public Anime putMedia(Anime media) {
        var response = restTemp.put(
                 configApp.getBackUrl() + PATH, media, Anime.class
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
}
