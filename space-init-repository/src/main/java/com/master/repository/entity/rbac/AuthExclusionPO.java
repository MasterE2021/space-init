package com.master.repository.entity.rbac;

import lombok.Data;

/**
 * 权限互斥
 *
 * @TableName rbac_auth_exclusion
 */
@Data
public class AuthExclusionPO {
    /**
     * 权限id
     */
    private String authId;

    /**
     * 互斥权限id
     */
    private String authIdObj;

    /**
     * 权限互斥说明
     */
    private String exclusionDesc;
}