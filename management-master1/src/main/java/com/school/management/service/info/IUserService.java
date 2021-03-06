package com.school.management.service.info;

import com.school.management.domain.Student;
import com.school.management.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    /**
     * 查询学生信息
     * @param Id
     * @return
     */
    Student selectStudent(String Id);

    /**
     * 查询用户信息
     * @param Id
     * @return
     */
    User selectUser(String Id);

    /**
     * 验证老密码
     * @param Id
     * @param password
     * @return
     */
    String checkPassword(String Id, String password);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param Id
     * @return
     */
    int resetPwd(String oldPassword, String newPassword, String Id);
}
