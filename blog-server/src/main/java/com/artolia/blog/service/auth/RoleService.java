package com.artolia.blog.service.auth;

import com.artolia.blog.common.Result;
import com.artolia.blog.domain.auth.Role;

import java.util.Map;

/**
 * @author Artolia Pendragon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年04月21日 13:20:00
 */
public interface RoleService {

    /**
     * 获取角色列表
     * @return
     */
    Result getRoleList(Map<String, Object> params);

    /**
     * 保存角色
     * @return
     */
    Result save(Role role, String op);

    /**
     * 根据用户获取角色
     * @return
     */
    Result getRolesByUser(int userId);

    /**
     * 删除角色
     * @return
     */
    Result delete(int roleId);

    /**
     * 保存菜单权限
     * @param role
     * @return
     */
    Result saveResource(Role role);
}
