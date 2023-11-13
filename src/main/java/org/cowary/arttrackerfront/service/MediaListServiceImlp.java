package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.Media;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class MediaListServiceImlp {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/view";

    public List<Media> getAllByUsrId(long userId, String status) {
        return coreGet("/media", userId, status);
    }

    public List<Media> getWatchListByUserId(long userId, String status) {
        return coreGet("/watch", userId, status);
    }

    public List<Media> getReadListByUserId(long userId, String status) {
        return coreGet("/read", userId, status);
    }

    public List<Media> getPlayListByUserId(long userId, String status) {
        return coreGet("/play", userId, status);
    }

    private List<Media> coreGet(String endpoint, long userId, String status) {
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> params = new HashMap<>();
        headers.add("userId", String.valueOf(userId));
        if (!status.isBlank()) params.put("Status", status);
        var response = restTemp.get(Config.getBackUrl() + PATH + endpoint, headers, params, Media[].class);
        Media[] arr = response.getBody();
        return Stream.of(arr).toList();
    }
}
