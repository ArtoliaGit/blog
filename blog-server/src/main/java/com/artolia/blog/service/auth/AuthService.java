package com.artolia.blog.service.auth;

import com.artolia.blog.common.Result;

public interface AuthService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Result login(String username, String password);
}
