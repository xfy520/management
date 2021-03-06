package com.school.management.service.info;

public interface IUserService {

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
}
