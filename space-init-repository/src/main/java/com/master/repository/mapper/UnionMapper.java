package com.master.repository.mapper;

import com.master.repository.entity.UnionPO;

/**
 * @author masterE
 * @description 针对表【rbac_union(组织)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.Union
 */
public interface UnionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UnionPO record);

    int insertSelective(UnionPO record);

    UnionPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UnionPO record);

    int updateByPrimaryKey(UnionPO record);

}
