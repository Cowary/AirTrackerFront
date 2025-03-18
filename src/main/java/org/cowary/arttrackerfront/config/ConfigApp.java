package org.cowary.arttrackerfront.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ConfigApp {

    @Value("${app.back-url}")
    private String backUrl;
}
