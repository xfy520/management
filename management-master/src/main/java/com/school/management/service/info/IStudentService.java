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
    int insertStudent(Student student, boolean isSchoolRoll);

    /**
     * 导入学生数据
     *
     * @param studentList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    String importStudent(List<Student> studentList, Boolean isUpdateSupport, String operName);

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
}
