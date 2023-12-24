package com.master.repository.entity.rbac;

import lombok.Data;

/**
 * 职位
 *
 * @TableName rbac_position
 */
@Data
public class PositionPO {
    /**
     * 职位id
     */
    private String positionId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 父级职位id
     */
    private String parentId;
}