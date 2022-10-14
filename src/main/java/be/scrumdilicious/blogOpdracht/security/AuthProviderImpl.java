package be.scrumdilicious.blogOpdracht.security;

import be.scrumdilicious.blogOpdracht.services.UserDetailsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private UserDetailsServ userDetailsServ;

    @Autowired
    public AuthProviderImpl(UserDetailsServ userDetailsServ) {
        this.userDetailsServ = userDetailsServ;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails userDetails = userDetailsServ.loadUserByUsername(username);
        String passwod = authentication.getCredentials().toString();
        if(!passwod.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Incorrect password");

        return new UsernamePasswordAuthenticationToken(userDetails, passwod,
                Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
