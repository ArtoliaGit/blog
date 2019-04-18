package com.artolia.blog.mapper.user;

import com.artolia.blog.domain.auth.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findByUsername(String username);

    Integer save(User user);
}
