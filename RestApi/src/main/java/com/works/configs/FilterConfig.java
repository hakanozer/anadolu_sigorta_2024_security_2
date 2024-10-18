package com.works.configs;

import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final InfoRepository infoRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        String roles = auth.getAuthorities().toString();
        String detail = auth.getDetails().toString();
        long time = System.currentTimeMillis();
        String sessionID = request.getSession().getId();

        Info info = new Info(url, name, roles, detail, time, sessionID);
        infoRepository.save(info);

        filterChain.doFilter(request, response);
    }

}
