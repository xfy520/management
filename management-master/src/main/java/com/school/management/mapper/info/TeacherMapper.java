package com.school.management.mapper.info;

import com.school.management.domain.Teacher;

import java.util.List;

public interface TeacherMapper {

    /**
     * 新增教师信息
     * @param teacher
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     * 分配班级
     */
    int updateTeacherClass(Teacher teacher);

    /**
     * 更新教师信息
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 批量删除教师
     * @param ids
     * @return
     */
    int deleteTeacherByIds(Long[] ids);

    /**
     * 条件分页查询教师信息
     * @param teacher
     * @return
     */
    List<Teacher> selectTeacherList(Teacher teacher);

    /**
     * 条件分页查询教师信息
     * @param teacher
     * @return
     */
    Teacher selectTeacherById(Teacher teacher);
}
