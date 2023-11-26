package com.master.repository.entity;

import lombok.Data;

/**
 * 职位-角色 关联表
 *
 * @TableName rbac_position_role
 */
@Data
public class PositionRolePO {
    /**
     * id
     */
    private String id;

    /**
     * 职位id
     */
    private String positionId;

    /**
     * 角色id
     */
    private String roleId;
}