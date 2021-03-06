package com.school.management.domain;

import com.school.management.common.annotation.Excel;
import lombok.Data;


/**
 * 用户对象 user
 *
 */
@Data
public class User
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private String Id;

    /** 登录账号 */
    private Long userId;

    /** 用户姓名 */
    private String userName;

    /** 密码 */
    private String password;

    /** 身份标识 */
    private int perms;

    /** 用户头像 */
    private String avatar;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
}
