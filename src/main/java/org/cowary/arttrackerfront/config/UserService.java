package org.cowary.arttrackerfront.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    public String getNameCurrentUser() {
        return "stub";
    }

    public String getCurrentUserToken() {
        return "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydWRlcnUiLCJpYXQiOjE2OTQ3OTg0MjksImV4cCI6MTY5NDgwODQyOX0.6gKJqXfkLN0DWu4G0Vc-PHemSDVV3_VVhjR3itX8mvQCgYwIvkkEuKyymgyu8etlfhgpzzYgRSjcnTwa4QNhVQ";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
