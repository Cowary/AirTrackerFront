package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.util.Config;
import org.springframework.http.HttpHeaders;

public class BackApi {

    private String baseUrl = Config.getBackUrl();
    private HttpHeaders headers = new HttpHeaders();


}
