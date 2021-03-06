package com.school.management.mapper.info;

import com.school.management.domain.Class;
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
     * 查询教师所上班级
     */
    List<Class> classSearch(Teacher teacher);

    /**
     * 条件分页查询教师信息
     * @param teacher
     * @return
     */
    List<Teacher> selectTeacherList(Teacher teacher);

    /**
     * 班级搜索教师
     */
    List<Teacher> searchTeacherList(Teacher teacher);

    /**
     * 条件分页查询教师信息
     * @param teacher
     * @return
     */
    Teacher selectTeacherById(Teacher teacher);

    /**
     * 验证用户名是否存在
     * @param userId
     * @return
     */
    String checkUserIdUnique(Long userId);

    /**
     * 更新教师信息
     */
    int updateTeacher(Teacher teacher);
}
