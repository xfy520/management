package com.school.management.domain;

import lombok.Data;

@Data
public class Login {

    /** 用户id */
    private Long userId;

    /** 登录名 */
    private String loginName;

    /** 用户姓名 */
    private String userName;

    /** 身份标识 */
    private int perms;

    /** 班级id */
    private Long gradeId;

    /** 用户头像地址 */
    private String avatar;
}
