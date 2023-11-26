package com.master.repository.entity;

import lombok.Data;

/**
 * 团队-角色 关联表
 *
 * @TableName rbac_team_role
 */
@Data
public class TeamRolePO {
    /**
     * id
     */
    private String id;

    /**
     * 团队id
     */
    private String teamId;

    /**
     * 角色id
     */
    private String roleId;
}