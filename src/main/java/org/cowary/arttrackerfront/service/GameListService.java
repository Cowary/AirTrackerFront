package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.game.Game;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService implements MediaListService<Game> {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/anime";

    @Override
    public List<Game> getAll(long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("userId", "3");
        var response = restTemp.get(Config.getBackUrl() + PATH, headers, Game[].class);
        return List.of(response.getBody());
    }

    @Override
    public List<Game> getAll(long userId, String status) {
        return null;
    }
}
