package com.enigma.restservice.controllers;

import com.enigma.restservice.exception.PathNotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public void handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 401) {
            throw new InsufficientAuthenticationException("Unauthorized.");
        } else {
            throw new PathNotFoundException();
        }

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
