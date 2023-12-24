package com.master.repository.entity.rbac;

import lombok.Data;

/**
 * 组织
 *
 * @TableName rbac_union
 */
@Data
public class UnionPO {
    /**
     * 组织id
     */
    private String unionId;

    /**
     * 组织名称
     */
    private String unionName;

    /**
     * 父级组织id
     */
    private String parentId;
}