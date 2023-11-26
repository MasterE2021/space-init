package com.master.service.user;

import com.master.api.dto.user.UserDTO;
import com.master.api.vo.UserVO;

import java.util.List;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 13:24
 */
public interface UserService {

    List<UserVO> listUser();

    UserDTO getUser();
}
