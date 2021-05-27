package com.spring.basics.security.jwt.filter;

import com.spring.basics.security.jwt.authentication.JwtAuthentication;
import com.spring.basics.security.jwt.provider.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component( "jwtAuthenticationFilter")
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = request.getHeader("Auth");
        if (token != null) {
            JwtAuthentication tokenAuthentication = new JwtAuthentication(token);
            Authentication auth = jwtAuthenticationProvider.authenticate(tokenAuthentication);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

}

