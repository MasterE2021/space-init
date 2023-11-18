package com.master.repository.mapper;

import com.master.repository.entity.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 12:50
 */
@Repository
public interface UserMapper {

    UserPO getUserPO(@Param("userId") String userId);
}
