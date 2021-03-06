package com.school.management.domain;

import lombok.Data;

@Data
public class Login {

    /** 用户id */
    private String Id;

    /** 登录账号 */
    private Long userId;

    /** 用户姓名 */
    private String userName;

    /** 身份标识 */
    private int perms;

    /** 用户头像地址 */
    private String avatar;
}
