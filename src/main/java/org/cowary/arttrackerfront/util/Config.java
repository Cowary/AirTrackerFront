package org.cowary.arttrackerfront.util;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    static {
//        var properUtil = new ProperUtil("config.properties");
//        backUrl = properUtil.getProp("BACK_URL");
        shikiUrl = "https://dere.shikimori.one";
    }

//    @Getter
//    private static final String backUrl;
    @Getter
    private static final String shikiUrl;

}
