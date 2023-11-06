package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.config.AuthenticationReq;
import org.cowary.arttrackerfront.entity.config.AuthenticationResp;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    RestTemp restTemp;
    private final String PATH = "/api/auth/signin";

    public AuthenticationResp getJwtToken(String login, String password) {
        var response = restTemp.post(Config.getBackUrl() + PATH, new AuthenticationReq(login, password), AuthenticationResp.class);
        System.out.println(response);
        return response.getBody();
    }



}
