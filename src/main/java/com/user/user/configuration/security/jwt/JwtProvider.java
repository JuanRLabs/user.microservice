package com.user.user.configuration.security.jwt;

import com.user.user.adapters.driven.jpa.mysql.entity.PrincipalUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    private static final String SECRET_KEY = "yourSuperSecureAndLongSecretKeyThatHasEnoughLengthForHS256";

    private int expiration = 1800000;

    public String generateToken(Authentication authentication){
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        List<String> roles = principalUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(principalUser.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 180))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token bad formatted");
        } catch (UnsupportedJwtException e) {
            logger.error("token not supported");
        } catch (ExpiredJwtException e) {
            logger.error("token expired");
        } catch (IllegalArgumentException e) {
            logger.error("token empty");
        } catch (SignatureException e) {
            logger.error("fail in signature");
        }
        return false;
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }
}
