package com.master.repository.entity;

import lombok.Data;

/**
 * 用户-组织 关联表
 *
 * @TableName rbac_user_union
 */
@Data
public class UserUnionPO {
    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 组织id
     */
    private String unionId;
}