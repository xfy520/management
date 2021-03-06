package com.school.management.service;

import com.school.management.domain.Login;

public interface ILoginService {

    /**
     * 登录认证
     * @return
     */
    Login loginAuth(String username, String password);
}
