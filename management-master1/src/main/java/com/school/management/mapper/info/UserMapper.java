package com.school.management.mapper.info;

import com.school.management.domain.Student;
import com.school.management.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * 数据服务层
 */

public interface UserMapper {

    /** 新增用户信息*/
    int insertUser(User user);

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteUserByIds(String[] ids);

    /**
     * 查询学生信息
     * @param Id
     * @return
     */
    Student selectStudent(@Param("Id") String Id);

    /**
     * 查询用户信息
     * @param Id
     * @return
     */
    User selectUser(@Param("Id") String Id);

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
    int resetPwd(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword, @Param("Id") String Id);
}
