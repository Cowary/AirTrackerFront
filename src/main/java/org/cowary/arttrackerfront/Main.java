package org.cowary.arttrackerfront;

import org.cowary.arttrackerfront.controller.list.MediaListController;
import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String nickname = "ruderu";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydWRlcnUiLCJpYXQiOjE2OTQ3OTg0MjksImV4cCI6MTY5NDgwODQyOX0.6gKJqXfkLN0DWu4G0Vc-PHemSDVV3_VVhjR3itX8mvQCgYwIvkkEuKyymgyu8etlfhgpzzYgRSjcnTwa4QNhVQ");
        headers.add("userId", "3");
//        headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydWRlcnUiLCJpYXQiOjE2OTQ3OTg2OTIsImV4cCI6MTY5NDgwODY5Mn0.dUiS_85uyC8D_jnx-be5A7c0dKFqgsfzEsYEnYmizGbvWRgpvjrOcx09YaOUh9ASBTDJabkIARPhRbcOC80tFQ");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        RestTemp restTemp = new RestTemp();
        Anime[] mediaList;
        try {
            mediaList = restTemp.getRest(new URL(Config.getBackUrl() + "/title/anime"), httpEntity, Anime[].class).getBody();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(mediaList));
    }
}
