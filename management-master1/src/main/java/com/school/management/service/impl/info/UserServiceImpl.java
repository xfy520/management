package com.school.management.service.impl.info;

import com.school.management.common.security.Md5Utils;
import com.school.management.domain.Student;
import com.school.management.domain.User;
import com.school.management.mapper.info.UserMapper;
import com.school.management.service.info.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询学生信息
     * @param Id
     * @return
     */
    @Override
   public Student selectStudent(String Id){
        return userMapper.selectStudent(Id);
    }

    /**
     * 查询用户信息
     * @param Id
     * @return
     */
    public User selectUser(String Id){
        return userMapper.selectUser(Id);
    }

    /**
     * 验证老密码
     * @param Id
     * @param password
     * @return
     */
    public String checkPassword(String Id, String password){
        return userMapper.checkPassword(Id, Md5Utils.hash(password));
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param Id
     * @return
     */
    public int resetPwd(String oldPassword, String newPassword, String Id){
        return userMapper.resetPwd(Md5Utils.hash(oldPassword), Md5Utils.hash(newPassword), Id);
    }
}
