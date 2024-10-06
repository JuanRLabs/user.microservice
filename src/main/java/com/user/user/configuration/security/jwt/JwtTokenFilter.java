package com.user.user.configuration.security.jwt;

import com.user.user.adapters.driven.jpa.mysql.adapter.UserDetailServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JwtTokenFilter extends OncePerRequestFilter {
    private final int SUBSTOKEN = 7;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailServiceImpl userDetailService;

    private List<String> excludedPrefixes = Arrays.asList("/auth/**", "/swagger-ui/**", "/actuator/**", "/user/");
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(req);
        if(token != null && jwtProvider.validateToken(token)){
            String nameUser = jwtProvider.getUserNameFromToken(token);
            UserDetails userDetails = userDetailService.loadUserByUsername(nameUser);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);

        }
        filterChain.doFilter(req,res);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")) {
            return header.substring(SUBSTOKEN);
        }
        return null;
    }
}
