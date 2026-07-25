package com.learningdeveloper.spendwise.base.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernamePasswordAuthToken extends AbstractAuthenticationToken {

    private final Object principal;   // String username before auth, AppUser after
    private final Object credentials; // raw password before auth, null after

    // Unauthenticated constructor (before authentication)
    public UsernamePasswordAuthToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    // Authenticated constructor (after successful authentication)
    public UsernamePasswordAuthToken(Object principal, Object credentials,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true); // must use super, see setAuthenticated below
    }

    @Override
    public Object getCredentials() { return credentials; }

    @Override
    public Object getPrincipal() { return principal; }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException(
                    "Use the constructor with authorities to mark this token authenticated");
        }
        super.setAuthenticated(false);
    }
}