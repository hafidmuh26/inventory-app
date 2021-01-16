package com.enigma.restservice.controllers.classcontroller;

import com.enigma.restservice.model.ResponseMessage;
import com.enigma.restservice.model.classmodel.AuthenticationRequest;
import com.enigma.restservice.security.JwtTokenProvider;
import com.enigma.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseMessage signIn( @Valid @RequestBody AuthenticationRequest data) {

        try {
            String username = data.getUsername();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, data.getPassword()));

            System.out.println("username" + username );
            String token = jwtTokenProvider.generateToken(authentication);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseMessage.success(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
