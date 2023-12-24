package com.master.repository.mapper.rbac;

import com.master.repository.entity.rbac.UserRolePO;

/**
 * @author masterE
 * @description 针对表【rbac_user_role(用户-角色 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.UserRole
 */
public interface UserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserRolePO record);

    int insertSelective(UserRolePO record);

    UserRolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRolePO record);

    int updateByPrimaryKey(UserRolePO record);

}
