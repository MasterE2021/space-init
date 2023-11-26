package com.master.repository.mapper;

import com.master.repository.entity.UserTeamPO;

/**
 * @author masterE
 * @description 针对表【rbac_user_team(用户-团队 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.UserTeam
 */
public interface UserTeamMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserTeamPO record);

    int insertSelective(UserTeamPO record);

    UserTeamPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserTeamPO record);

    int updateByPrimaryKey(UserTeamPO record);

}
