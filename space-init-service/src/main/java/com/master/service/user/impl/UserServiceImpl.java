package com.master.service.user.impl;

import com.master.api.vo.UserVO;
import com.master.common.exception.BusinessException;
import com.master.common.utils.Tools;
import com.master.repository.entity.rbac.UserPO;
import com.master.repository.mapper.rbac.UserMapper;
import com.master.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 13:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public List<UserVO> listUser() {
        List<UserPO> userPOs = userMapper.listUserPO();

        List<UserVO> userVOs = new ArrayList<>();
        userPOs.forEach(po -> {
            UserVO userVO = new UserVO();
            userVO.setUserId(po.getUserId());
            userVO.setUserNo(po.getUserNo());
            userVO.setUserName(po.getUserName());
            userVO.setPhone(po.getPhone());
            userVO.setEmail(po.getEmail());
            userVOs.add(userVO);
        });
        return userVOs;
    }

    @Override
    public UserVO getUser(String userId) {
        UserPO userPO = userMapper.getUserPO(userId);

        UserVO vo = new UserVO();
        vo.setUserId(userPO.getUserId());
        vo.setUserNo(userPO.getUserNo());
        vo.setUserName(userPO.getUserName());
        vo.setPhone(userPO.getPhone());
        vo.setEmail(userPO.getEmail());
        return vo;
    }

    @Override
    public void insertUser(UserVO vo) {
        UserPO po = new UserPO();
        po.setUserId(String.valueOf(UUID.randomUUID()));
        po.setUserNo(vo.getUserNo());
        po.setUserName(vo.getUserName());
        po.setPhone(vo.getPhone());
        po.setEmail(vo.getEmail());
        userMapper.insertUserPO(po);
    }

    @Override
    public void deleteUser(String userId) {
        UserPO userPO = userMapper.getUserPO(userId);
        if (Tools.isEmpty(userPO)){
            throw new BusinessException(200, "该用户不存在或已经删除");
        }
        userMapper.deleteUserPO(userId);
    }

    @Override
    public void updateUser(UserVO vo) {
        UserPO oldUserPO = userMapper.getUserPO(vo.getUserId());
        if (Tools.isEmpty(oldUserPO)){
            throw new BusinessException(200, "该用户不存在或已经删除");
        }
        
        UserPO userPO = new UserPO();
        userPO.setUserId(vo.getUserId());
        userPO.setUserName(vo.getUserName());
        userPO.setPhone(vo.getPhone());
        userPO.setEmail(vo.getEmail());
        userMapper.updateUserPO(userPO);
    }
}
