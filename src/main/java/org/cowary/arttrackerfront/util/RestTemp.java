package org.cowary.arttrackerfront.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

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
//        headers.setBearerAuth(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
        headers.setBearerAuth("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydWRlcnUiLCJpYXQiOjE2OTUzMjI3MjIsImV4cCI6MTY5NTMzMjcyMn0.fcUdabRnUJZM7TEW_qag9xIrPmv4PGqNBkJQQll4phZU3e8nSAcb82sQsHSpnK9VZnEdMp9dAFs0x8l0HpcD6w");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url, HttpMethod.GET, httpEntity, responseType
        );
    }


}
