package com.master.repository.mapper;

import com.master.repository.entity.AuthExclusionPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author masterE
 * @description 针对表【rbac_auth_exclusion(权限互斥)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.AuthExclusion
 */
public interface AuthExclusionMapper {

    AuthExclusionPO getAuthExclusionPO(@Param("id") String id);

    int insert(@Param("po") AuthExclusionPO po);

    int deleteByKey(@Param("id") String id);

    int updateByKey(@Param("id") String id);

}
