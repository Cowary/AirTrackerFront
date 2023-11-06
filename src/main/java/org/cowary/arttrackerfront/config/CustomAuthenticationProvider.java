package org.cowary.arttrackerfront.config;

import org.cowary.arttrackerfront.entity.User;
import org.cowary.arttrackerfront.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    ConfigService configService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        var userRs = configService.getJwtToken(userName, password);
        user.setToken(userRs.getToken());
        user.setId(userRs.getId());
        if (user == null) {
            throw new BadCredentialsException("Unknown user " + userName);
        }
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Bad password");
        }
        System.out.println("SUCCESS");
        return new UsernamePasswordAuthenticationToken(
                user, userRs, user.getAuthorities()
        );

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
