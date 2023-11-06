package org.cowary.arttrackerfront.util;

import org.cowary.arttrackerfront.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SystemUtil {

    public static Long getUserid() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }
}
