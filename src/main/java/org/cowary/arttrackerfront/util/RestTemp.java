package org.cowary.arttrackerfront.util;

import org.cowary.arttrackerfront.entity.User;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Map;

@Component
public class RestTemp {

    private final static RestTemplate restTemplate = new RestTemplate();

    public <T> ResponseEntity<T> getRest(URL url, HttpEntity<String> request, Class<T> responseType) {
        return restTemplate.exchange(
                url.toString(),
                HttpMethod.GET,
                request,
                responseType);
    }

    public <T> T  getBody(URL url, Class<T> responseType) {
        return getBody(url, null, responseType);
    }

    public <T> T getBody(URL url, HttpEntity<String> request, Class<T> responseType) {
        T response = getRest(url, request, responseType).getBody();
        if (response == null) {
            throw new IllegalStateException("Ничего не найдено");
        }
        return response;
    }

    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, Class<T> responseType) {
        var user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        headers.setBearerAuth(user.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url, HttpMethod.GET, httpEntity, responseType
        );
    }

    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, Map<String, ?> params, Class<T> responseType) {
        var user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        headers.setBearerAuth(user.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url, HttpMethod.GET, httpEntity, responseType, params
        );
    }

    public <T, K> ResponseEntity<T> post(String url, K body, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<K> request = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, request, responseType);
    }


}
