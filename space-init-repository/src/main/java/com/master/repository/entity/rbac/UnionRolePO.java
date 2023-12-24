package com.master.repository.entity.rbac;

import lombok.Data;

/**
 * 组织-角色 关联表
 *
 * @TableName rbac_union_role
 */
@Data
public class UnionRolePO {
    /**
     * id
     */
    private String id;

    /**
     * 组织id
     */
    private String unionId;

    /**
     * 角色id
     */
    private String roleId;
}