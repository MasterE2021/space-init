package com.master.repository.mapper;

import com.master.repository.entity.UserUnionPO;

/**
 * @author masterE
 * @description 针对表【rbac_user_union(用户-组织 关联表)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.UserUnion
 */
public interface UserUnionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserUnionPO record);

    int insertSelective(UserUnionPO record);

    UserUnionPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserUnionPO record);

    int updateByPrimaryKey(UserUnionPO record);

}
