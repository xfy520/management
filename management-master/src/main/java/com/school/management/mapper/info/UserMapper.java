package com.school.management.mapper.info;

import com.school.management.domain.Student;
import com.school.management.domain.User;

/**
 * 数据服务层
 */

public interface UserMapper {

    /**
     * 验证用户名是否存在
     * @param loginName
     * @return
     */
    String checkLoginNameUnique(String loginName);

    /**
     * 验证身份证号否存在
     * @param idNumber
     * @return
     */
    String checkIdNumberUnique(String idNumber);

    /** 新增用户信息*/
    int insertUser(User user);

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteUserByIds(Long[] ids);

    /** 修改用户信息 */
    int updateUser(User user);
}
