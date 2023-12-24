package com.master.repository.entity.rbac;

import lombok.Data;

/**
 * 用户-团队 关联表
 *
 * @TableName rbac_user_team
 */
@Data
public class UserTeamPO {
    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 团队id
     */
    private String teamId;
}