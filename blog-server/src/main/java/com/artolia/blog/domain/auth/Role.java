package com.artolia.blog.domain.auth;

import lombok.Data;

@Data
public class Role {

    private Integer roleId;
    private String roleName;
    private String roleDescription;
    private String createTime;
}
