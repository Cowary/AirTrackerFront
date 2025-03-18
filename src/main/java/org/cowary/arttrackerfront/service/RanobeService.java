package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.config.ConfigApp;
import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.RanobeRs;
import org.cowary.arttrackerfront.entity.ranobe.RanobeVolume;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RanobeService implements MediaService<RanobeVolume>, FindService<RanobeRs> {

    @Autowired
    private RestTemp restTemp;
    @Autowired
    private ConfigApp configApp;
    private final String PATH = "/title/ranobe";

    @Override
    public RanobeVolume getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/" + titleId, RanobeVolume.class
        );
        return response.getBody();
    }

    @Override
    public RanobeVolume postMedia(RanobeVolume media) {
        var response = restTemp.postWithToken(
                configApp.getBackUrl() + PATH, media, RanobeVolume.class
        );
        return response.getBody();
    }

    @Override
    public RanobeVolume putMedia(RanobeVolume media) {
        var response = restTemp.put(
                configApp.getBackUrl() + PATH, media, RanobeVolume.class
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
    public RanobeRs findByIntegrationId(long id) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/getByServiceId", RanobeRs.class, Map.of("id", id)
        );
        return response.getBody();
    }

}
