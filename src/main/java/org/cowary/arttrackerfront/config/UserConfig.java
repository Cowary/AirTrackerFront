package org.cowary.arttrackerfront.config;

import org.cowary.arttrackerfront.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConfig {

    private static final HashMap<Long, User> userList = new HashMap<>();

    public static synchronized void addUser(Long id, User user) {
        userList.put(id, user);
    }

    public static synchronized User findUserById(long id) {
        return userList.get(id);
    }
}
