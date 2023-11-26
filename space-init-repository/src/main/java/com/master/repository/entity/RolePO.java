package com.master.repository.entity;

import lombok.Data;

/**
 * 角色
 *
 * @TableName rbac_role
 */
@Data
public class RolePO {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 父级角色id
     */
    private String parentId;
}