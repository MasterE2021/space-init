package com.master.repository.mapper;

import com.master.repository.entity.PositionPO;

/**
 * @author masterE
 * @description 针对表【rbac_position(职位)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.Position
 */
public interface PositionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PositionPO record);

    int insertSelective(PositionPO record);

    PositionPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PositionPO record);

    int updateByPrimaryKey(PositionPO record);

}
