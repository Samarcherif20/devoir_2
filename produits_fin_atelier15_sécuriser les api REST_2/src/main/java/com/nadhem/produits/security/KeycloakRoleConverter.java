package com.nadhem.produits.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

@Component
public class KeycloakRoleConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter =
            new JwtGrantedAuthoritiesConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        // Extract realm_access roles
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
        Collection<GrantedAuthority> authorities;
        
        if (realmAccess == null || realmAccess.isEmpty()) {
            authorities = jwtGrantedAuthoritiesConverter.convert(jwt);
        } else {
            // Combine realm roles with scope authorities
            Collection<GrantedAuthority> realmRoles = ((List<String>) realmAccess.get("roles")).stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
            
            authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                realmRoles.stream()
            ).collect(Collectors.toSet());
        }

        return new JwtAuthenticationToken(jwt, authorities, jwt.getClaim("preferred_username"));
    }
}