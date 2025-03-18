package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.config.ConfigApp;
import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.TvRs;
import org.cowary.arttrackerfront.entity.tv.TvSeason;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TvService implements MediaService<TvSeason>, FindService<TvRs> {

    @Autowired
    private RestTemp restTemp;
    @Autowired
    private ConfigApp configApp;
    private final String PATH = "/title/tv";

    @Override
    public TvSeason getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/" + titleId, TvSeason.class
        );
        return response.getBody();
    }

    @Override
    public TvSeason postMedia(TvSeason media) {
        var response = restTemp.postWithToken(
                configApp.getBackUrl() + PATH, media, TvSeason.class
        );
        return response.getBody();
    }

    @Override
    public TvSeason putMedia(TvSeason media) {
        var response = restTemp.put(
                configApp.getBackUrl() + PATH, media, TvSeason.class
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
    public TvRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/getByServiceId", TvRs.class, Map.of("id", id)
        );
        return response.getBody();
    }
}
