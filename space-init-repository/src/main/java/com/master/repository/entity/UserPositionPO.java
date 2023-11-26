package com.master.repository.entity;

import lombok.Data;

/**
 * 用户-职位 关联表
 *
 * @TableName rbac_user_position
 */
@Data
public class UserPositionPO {
    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 职位id
     */
    private String positionId;
}