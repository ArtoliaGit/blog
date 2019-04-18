package com.artolia.blog.service.impl.auth;

import com.artolia.blog.common.Result;
import com.artolia.blog.domain.auth.User;
import com.artolia.blog.mapper.user.UserMapper;
import com.artolia.blog.service.auth.AuthService;
import com.artolia.blog.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Qualifier("userService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserMapper userMapper;

    @Override
    public Result register(User user) {
        Result<User> result = new Result<>();
        final String username = user.getUsername();
        if (userMapper.findByUsername(username) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        userMapper.save(user);

        result.setCode(200);
        result.setMessage("注册成功");
        result.setData(user);
        return result;
    }

    @Override
    public Result login(String username, String password) {
        Result<String> result = new Result<>();
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);

        result.setCode(200);
        result.setMessage("登录成功");
        result.setData(token);
        return result;
    }
}
