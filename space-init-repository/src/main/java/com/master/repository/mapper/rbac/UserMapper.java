package com.master.repository.mapper.rbac;

import com.master.repository.entity.rbac.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 12:50
 */
@Repository
public interface UserMapper {

    List<UserPO> listUserPO();

    UserPO getUserPO(@Param("userId") String userId);

    void insertUserPO(@Param("po") UserPO po);

    void batchInsertUserPO(@Param("pos") List<UserPO> pos);

    void deleteUserPO(@Param("id") String id);

    void updateUserPO(@Param("po") UserPO po);
}
