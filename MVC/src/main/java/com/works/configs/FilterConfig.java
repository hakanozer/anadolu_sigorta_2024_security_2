package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String email = "";
        String url = request.getRequestURI();
        String[] freeUrls = {"/", "/login"};
        boolean loginStatus = true;
        for (String freeUrl : freeUrls) {
            if (url.equals(freeUrl)) {
                loginStatus = false;
                break;
            }
        }

        if(loginStatus) {
            // session control
            boolean status = request.getSession().getAttribute("user") == null;
            if(status) {
                response.sendRedirect("/");
            }else {
                Object obj = request.getSession().getAttribute("user");
                email = (String) obj;
                request.setAttribute("email", email);
                filterChain.doFilter(request, response);
            }
        }else {
            filterChain.doFilter(request, response);
        }

        long time = System.currentTimeMillis();
        String userAgent = request.getHeader("User-Agent");
        String ip = request.getRemoteAddr();
        String sessionId = request.getSession().getId();
        System.out.println(url+ " " + userAgent+ " " + ip + " " + sessionId + " " + email + " " + time);

    }

}
