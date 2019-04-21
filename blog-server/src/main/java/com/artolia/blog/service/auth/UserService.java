package com.artolia.blog.service.auth;

import com.artolia.blog.common.Result;
import com.artolia.blog.domain.auth.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {

    /**
     * 获取用户信息
     * @return
     */
    Result getUserInfo();

    /**
     * 获取用户列表
     * @return
     */
    Result getUserList(Map<String, Object> params);

    /**
     * 保存用户
     */
    Result save(User user, String op);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Result delete(int userId);
}
