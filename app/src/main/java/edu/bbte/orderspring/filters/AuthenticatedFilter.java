package edu.bbte.orderspring.filters;

import edu.bbte.orderspring.utils.TokenGenerator;
import edu.bbte.orderspring.utils.PasswordEncoder;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
@Component
@WebFilter(urlPatterns = "/api/*")
public class AuthenticatedFilter implements HandlerInterceptor {

    @Autowired
    private TokenGenerator tokenGenerator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if (url.equals("/api/login") || url.equals("/api/register")) {
           return true;
        }
        if (request.getQueryString() == null) {
            response.sendError(401, "Unauthorized");
            return false;
        }

        if (!request.getQueryString().contains("token=")) {
            response.sendError(401, "Unauthorized");
            return false;
        }

        String token = request.getQueryString().split("token=")[1];

        if (token == null) {
            response.sendError(401, "Unauthorized");
            return false;
        }

        try {
            if (tokenGenerator.checkToken(token)) {
                return true;
            }

            response.sendError(401, "Unauthorized");
            return false;
        } catch (Exception ignored) {
            response.sendError(401, "Unauthorized");
            return false;
        }
    }
}
