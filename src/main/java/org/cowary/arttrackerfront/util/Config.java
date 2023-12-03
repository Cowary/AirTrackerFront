package org.cowary.arttrackerfront.util;

import lombok.Getter;

public class Config {


    static {
        var properUtil = new ProperUtil("config.properties");
        backUrl = properUtil.getProp("BACK_URL");
        shikiUrl = "https://dere.shikimori.me";
    }

    @Getter
    private static final String backUrl;
    @Getter
    private static final String shikiUrl;

}
