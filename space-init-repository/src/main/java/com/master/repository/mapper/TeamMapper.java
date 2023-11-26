package com.master.repository.mapper;

import com.master.repository.entity.TeamPO;

/**
 * @author masterE
 * @description 针对表【rbac_team(团队)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.Team
 */
public interface TeamMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TeamPO record);

    int insertSelective(TeamPO record);

    TeamPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeamPO record);

    int updateByPrimaryKey(TeamPO record);

}
