package com.master.repository.entity;

import lombok.Data;

/**
 * 用户-角色 关联表
 *
 * @TableName rbac_user_role
 */
@Data
public class UserRolePO {
    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;
}