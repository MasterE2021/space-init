package com.master.repository.mapper.rbac;

import com.master.repository.entity.rbac.PositionRolePO;

/**
 * @author masterE
 * @description 针对表【rbac_position_role(职位-角色 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.PositionRole
 */
public interface PositionRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PositionRolePO record);

    int insertSelective(PositionRolePO record);

    PositionRolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PositionRolePO record);

    int updateByPrimaryKey(PositionRolePO record);

}
