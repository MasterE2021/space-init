package com.master.repository.mapper.rbac;

import com.master.repository.entity.rbac.UnionRolePO;

/**
 * @author masterE
 * @description 针对表【rbac_union_role(组织-角色 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.UnionRole
 */
public interface UnionRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UnionRolePO record);

    int insertSelective(UnionRolePO record);

    UnionRolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UnionRolePO record);

    int updateByPrimaryKey(UnionRolePO record);

}
