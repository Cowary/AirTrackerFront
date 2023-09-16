package org.cowary.arttrackerfront.util;

import lombok.Getter;

public class Config {


    static {
        var properUtil = new ProperUtil("config.properties");
        backUrl = properUtil.getProp("BACK_URL");
    }

    @Getter
    private static final String backUrl;

}
