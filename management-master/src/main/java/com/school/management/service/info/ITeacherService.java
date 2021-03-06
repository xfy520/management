package com.school.management.service.info;

import com.school.management.domain.Teacher;

import java.util.List;

public interface ITeacherService {

    /**
     * 新增教师信息
     *
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     * 分配班级
     */
    int updateTeacherClass(Teacher teacher);

    /**
     * 新增教师信息
     *
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 批量删除教师信息
     *
     * @return
     */
    int deleteTeacherByIds(String ids);

    /**
     * 条件分页查找教师信息
     *
     * @return
     */
    List<Teacher> selectTeacherList(Teacher teacher);

    /**
     * 条件查找教师信息
     *
     * @return
     */
    Teacher selectTeacherById(Teacher teacher);

}
