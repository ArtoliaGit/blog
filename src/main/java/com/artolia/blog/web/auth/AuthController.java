package com.artolia.blog.web.auth;

import com.artolia.blog.domain.auth.User;
import com.artolia.blog.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String login(String username, String password) throws AuthenticationException {
        return authService.login(username, password);
    }

    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register(@RequestBody User user) throws AuthenticationException {
        return authService.register(user);
    }
}
