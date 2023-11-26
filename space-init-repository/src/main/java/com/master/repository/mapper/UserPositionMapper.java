package com.master.repository.mapper;

import com.master.repository.entity.UserPositionPO;

/**
 * @author masterE
 * @description 针对表【rbac_user_position(用户-职位 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.UserPosition
 */
public interface UserPositionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserPositionPO record);

    int insertSelective(UserPositionPO record);

    UserPositionPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPositionPO record);

    int updateByPrimaryKey(UserPositionPO record);

}
