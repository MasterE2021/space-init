package com.master.repository.mapper.rbac;

import com.master.repository.entity.rbac.RoleAuthPO;

/**
 * @author masterE
 * @description 针对表【rbac_role_auth(角色-权限 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.RoleAuth
 */
public interface RoleAuthMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoleAuthPO record);

    int insertSelective(RoleAuthPO record);

    RoleAuthPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleAuthPO record);

    int updateByPrimaryKey(RoleAuthPO record);

}
