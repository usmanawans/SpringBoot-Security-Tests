package no.norbay.springbootsecuritytests.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if("123".equals(username)){
            return new UsernamePasswordAuthenticationToken(username, password, commaSeparatedStringToAuthorityList("USER"));
        } else if("999".equals(username)) {
            return new UsernamePasswordAuthenticationToken(username, password, commaSeparatedStringToAuthorityList("ADMIN"));
        }
        throw new AuthenticationCredentialsNotFoundException("User is not Authorized");
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
}
