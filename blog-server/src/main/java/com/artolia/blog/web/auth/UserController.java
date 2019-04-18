package com.artolia.blog.web.auth;

import com.artolia.blog.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artolia Pendragon
 * @version 1.0.0
 * @Description 用户操作
 * @createTime 2019年03月24日 17:12:00
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return userService.getUserInfo().toJson();
    }
}
