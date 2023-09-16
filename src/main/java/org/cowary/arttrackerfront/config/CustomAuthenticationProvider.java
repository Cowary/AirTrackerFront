package org.cowary.arttrackerfront.config;

import org.cowary.arttrackerfront.entity.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = new User();
        user.setUsername("ruderu");
        user.setPassword("123");
        user.setToken("token+test");
        if (user == null) {
            throw new BadCredentialsException("Unknown user " + userName);
        }
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Bad password");
        }
        System.out.println("SUCCESS");
        return new UsernamePasswordAuthenticationToken(
                user, password, user.getAuthorities()
        );

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
