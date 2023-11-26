package com.master.web.controller.user;

import com.master.api.vo.UserVO;
import com.master.common.result.BaseResult;
import com.master.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
