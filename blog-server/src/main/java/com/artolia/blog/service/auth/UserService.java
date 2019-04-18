package com.artolia.blog.service.auth;

import com.artolia.blog.common.Result;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    /**
     * 获取用户信息
     * @return
     */
    Result getUserInfo();
}
