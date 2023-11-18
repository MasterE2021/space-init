package com.master.repository.entity;

import lombok.Data;

/**
 * 用户
 *
 * @author yiqunjie
 * @description
 * @date 2023-11-18 12:46
 */
@Data
public class UserPO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户账号(自定义)
     */
    private String userNo;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}
