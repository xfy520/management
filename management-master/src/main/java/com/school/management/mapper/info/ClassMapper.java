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
    List<Class> searchClassList(@Param("userId") Long userId, @Param("gradeId") Long gradeId, @Param("subjectId") Long subjectId);
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
    int deleteClass(Long classId);

    /**
     * 查询指定年级最大班号
     */
    Integer selectMaxClassNum(Long gradeId);

    /**
     * 考试筛选班级
     */
    List<Class> selectExamClassList(Teacher teacher);
}
