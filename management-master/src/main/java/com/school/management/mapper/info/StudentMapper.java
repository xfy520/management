package com.school.management.mapper.info;

import com.school.management.domain.SchoolRoll;
import com.school.management.domain.Student;

import java.util.List;

/**
 * 学生信息层 数据层
 *
 */
public interface StudentMapper {

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

    /** 插入学习年级班级关联 */
    int insertStudent(Student student);

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteStudentByIds(Long[] ids);

    /** 插入学籍信息 */
    int insertSchoolRoll(SchoolRoll schoolRoll);

}
