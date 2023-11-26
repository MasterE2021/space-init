package com.master.repository.mapper;

import com.master.repository.entity.RolePO;

/**
 * @author masterE
 * @description 针对表【rbac_role(角色)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.Role
 */
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RolePO record);

    int insertSelective(RolePO record);

    RolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePO record);

    int updateByPrimaryKey(RolePO record);

}
