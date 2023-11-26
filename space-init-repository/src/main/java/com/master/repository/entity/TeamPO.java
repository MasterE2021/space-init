package com.master.repository.entity;

import lombok.Data;

/**
 * 团队
 *
 * @TableName rbac_team
 */
@Data
public class TeamPO {
    /**
     * 团队id
     */
    private String teamId;

    /**
     * 团队名称
     */
    private String teamName;
}