package com.master.repository.entity;

import lombok.Data;

/**
 * 权限
 *
 * @TableName rbac_auth
 */
@Data
public class AuthPO {
    /**
     * 权限id
     */
    private String authId;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限类型
     */
    private String authType;

    /**
     * 父级权限id
     */
    private String parentId;
}