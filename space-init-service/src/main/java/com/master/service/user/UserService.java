package com.master.service.user;

import com.master.api.vo.UserVO;

import java.util.List;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 13:24
 */
public interface UserService {

    List<UserVO> listUser();

    UserVO getUser(String userId);

    void insertUser(UserVO userVO);

    void deleteUser(String userId);

    void updateUser(UserVO vo);
}
