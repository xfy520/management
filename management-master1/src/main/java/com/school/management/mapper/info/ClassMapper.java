package com.school.management.mapper.info;

import com.school.management.domain.Class;
import com.school.management.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {

    /**
     * 获取班级列表
     */
    List<Class> selectClassList(Class shift);

    /**
     * 条件搜索班级
     */
    List<Class> searchClassList(@Param("teacherId") String teacherId, @Param("gradeId") String gradeId, @Param("subjectId") String subjectId);
    /**
     * 修改班级负责人
     */
    int updateClassLeader(Class shift);

    /**
     * 新增班级
     */
    int insertClass(Class shift);

    /**
     * 删除班级
     */
    int deleteClass(String classId);

    /**
     * 查询指定年级最大班号
     */
    Integer selectMaxClassNum(String gradeId);

    /**
     * 考试筛选班级
     */
    List<Class> selectExamClassList(Teacher teacher);

    /**
     * 查询考试班级
     */
    List<Class> selectExamineClassList(String examId);
}
