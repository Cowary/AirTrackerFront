package org.cowary.arttrackerfront.service;

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
    private final String PATH =  Config.getBackUrl() + "/title/game";

    @Override
    public Game getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                PATH + "/" + titleId, Game.class
        );
        return response.getBody();
    }

    @Override
    public Game postMedia(Game media) {
        var response = restTemp.postWithToken(
                PATH, media, Game.class
        );
        return response.getBody();
    }

    @Override
    public Game putMedia(Game media) {
        var response = restTemp.put(
                PATH, media, Game.class
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
