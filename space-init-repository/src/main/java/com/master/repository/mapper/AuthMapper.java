package com.master.repository.mapper;

import com.master.repository.entity.AuthPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author masterE
 * @description 针对表【rbac_auth(权限)】的数据库操作Mapper
 * @createDate 2023-11-26 12:16:07
 * @Entity generator.domain.Auth
 */
public interface AuthMapper {

    AuthPO getAuthPO(@Param("id") String id);

    int insert(@Param("po") AuthPO po);

    int deleteByKey(@Param("id") String id);

    int updateByKey(@Param("id") String id);

}
