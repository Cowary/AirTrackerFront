package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.Media;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class MediaService {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/title/view/media";

    public List<Media> getAllByUsrId(long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("userId", "3");
        var response = restTemp.get(Config.getBackUrl() + PATH, headers, Media[].class);
        System.out.println(response.getBody());
        Media[] arr = response.getBody();
        return Stream.of(arr).toList();
    }
}
