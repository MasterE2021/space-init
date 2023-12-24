package com.master.repository.entity.rbac;

import lombok.Data;

/**
 * 角色-权限 关联表
 *
 * @TableName rbac_role_auth
 */
@Data
public class RoleAuthPO {
    /**
     * id
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String authId;
}