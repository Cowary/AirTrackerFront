package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.config.ConfigApp;
import org.cowary.arttrackerfront.entity.game.Game;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GameService implements MediaService<Game> {

    @Autowired
    private RestTemp restTemp;
    @Autowired
    private ConfigApp configApp;
    private final String PATH = "/title/game";

    @Override
    public Game getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/" + titleId, Game.class
        );
        return response.getBody();
    }

    @Override
    public Game postMedia(Game media) {
        var response = restTemp.postWithToken(
                configApp.getBackUrl() + PATH, media, Game.class
        );
        return response.getBody();
    }

    @Override
    public Game putMedia(Game media) {
        var response = restTemp.put(
                configApp.getBackUrl() + PATH, media, Game.class
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
