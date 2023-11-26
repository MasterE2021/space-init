package com.master.repository.mapper;

import com.master.repository.entity.TeamRolePO;

/**
 * @author masterE
 * @description 针对表【rbac_team_role(团队-角色 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.TeamRole
 */
public interface TeamRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TeamRolePO record);

    int insertSelective(TeamRolePO record);

    TeamRolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeamRolePO record);

    int updateByPrimaryKey(TeamRolePO record);

}
