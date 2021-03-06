package com.school.management.service.info;

import com.school.management.domain.Student;

import java.util.List;

public interface IStudentService {

    /**
     * 根据条件分页查询用户列表
     *
     * @return 用户信息集合信息
     */
    List<Student> selectStudentList(Student student);

    /**
     * 根据userId查询单个用户信息
     *
     * @return 单个用户信息
     */
    Student selectStudentById(Student student);

    /**
     * 新增学生信息
     *
     * @return
     */
    int insertStudent(Student student);

    /**
     * 删除学生信息
     *
     * @return
     */
    int deleteStudentByIds(String ids);

    /**
     * 修改学生信息
     *
     * @return
     */
    int updateStudent(Student student);

    /**
     * 验证身份证号否存在
     * @param idNumber
     * @return
     */
    String checkIdNumberUnique(String idNumber);


}
