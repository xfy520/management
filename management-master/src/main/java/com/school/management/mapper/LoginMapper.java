package com.school.management.mapper;

import com.school.management.domain.Login;
import org.apache.ibatis.annotations.Param;

/**
 * 数据服务层
 */
public interface LoginMapper {

    /**
     * 登录认证
     * @param username
     * @param password
     * @return
     */
    Login loginAuth(@Param("username") String username, @Param("password") String password);
}
