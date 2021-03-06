package com.school.management.service.impl.info;

import com.school.management.mapper.info.UserMapper;
import com.school.management.service.info.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 验证用户名是否存在
     * @param loginName
     * @return
     */
    @Override
    public String checkLoginNameUnique(String loginName) {
        return userMapper.checkLoginNameUnique(loginName);
    }

    /**
     * 验证身份证号否存在
     * @param idNumber
     * @return
     */
    @Override
    public String checkIdNumberUnique(String idNumber) {
        return userMapper.checkIdNumberUnique(idNumber);
    }
}
