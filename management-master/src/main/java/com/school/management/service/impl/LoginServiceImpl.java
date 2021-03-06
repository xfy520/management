package com.school.management.service.impl;

import com.school.management.common.security.Md5Utils;
import com.school.management.domain.Login;
import com.school.management.mapper.LoginMapper;
import com.school.management.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private LoginMapper loginMapper;

    /**
     * 登录认证
     * @param username
     * @param password
     * @return
     */
    @Override
    public Login loginAuth(String username, String password){
        return loginMapper.loginAuth(username, Md5Utils.hash(password));
    }

    public static void main(String[] args) {
        System.out.println(Md5Utils.hash("123456"));
    }
}
