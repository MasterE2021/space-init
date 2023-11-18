package com.master.service.user.impl;

import com.master.api.dto.user.UserDTO;
import com.master.repository.entity.UserPO;
import com.master.repository.mapper.UserMapper;
import com.master.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 13:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO getUser(){
        UserPO userPO = userMapper.getUserPO("1");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userPO.getUserId());
        userDTO.setUserNo(userPO.getUserNo());
        userDTO.setUserName(userPO.getUserName());
        userDTO.setPhone(userPO.getPhone());
        userDTO.setEmail(userPO.getEmail());
        return userDTO;
    }
}
