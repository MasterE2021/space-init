package com.master.web.controller.user;

import com.master.api.dto.user.UserDTO;
import com.master.api.vo.UserVO;
import com.master.common.result.BaseResult;
import com.master.service.user.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-02 11:25
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;


    @GetMapping("/listUser")
    public BaseResult<List<UserVO>> listUser() {
        List<UserVO> userVOs = userService.listUser();
        return BaseResult.success(userVOs);
    }

    @GetMapping(value = "/getUser")
    public BaseResult<UserVO> getUser(@RequestBody String userId) {
        UserVO vo = userService.getUser(userId);
        return BaseResult.success(vo);
    }

    @PostMapping(value = "/insertUser")
    public BaseResult<UserDTO> insertUser(@RequestBody UserVO vo) {
        userService.insertUser(vo);
        return BaseResult.success();
    }

    @DeleteMapping(value = "/deleteUser")
    public BaseResult<String> deleteUser(@RequestBody String userId) {
        userService.deleteUser(userId);
        return BaseResult.success(userId);
    }

    @PutMapping(value = "/updateUser")
    public BaseResult<String> updateUser(@RequestBody UserVO vo) {
        userService.updateUser(vo);
        return BaseResult.success();
    }
}
