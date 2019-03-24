package com.artolia.blog.service.auth;

import com.artolia.blog.common.Result;
import com.artolia.blog.domain.auth.User;

public interface AuthService {
    /**
     * 注册用户
     * @param user 新增用户
     * @return
     */
    Result register(User user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Result login(String username, String password);
}
