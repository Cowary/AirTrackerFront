package org.cowary.arttrackerfront.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class Config {


    static {
        var properUtil = new ProperUtil("config.properties");
        backUrl = properUtil.getProp("BACK_URL");
    }

    @Getter
    private static final String backUrl;

}
