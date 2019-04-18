package com.artolia.blog.service.impl.auth;

import com.artolia.blog.common.Result;
import com.artolia.blog.common.auth.UserInfo;
import com.artolia.blog.domain.auth.User;
import com.artolia.blog.mapper.user.UserMapper;
import com.artolia.blog.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserInfo userInfo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

    @Override
    public Result getUserInfo() {
        Result<User> result = new Result<>();
        try {
            User user = userInfo.getUser();
            result.setCode(200);
            result.setMessage("获取用户信息成功");
            result.setData(user);
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("获取用户信息失败");
        }

        return result;
    }
}
