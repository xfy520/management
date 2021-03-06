package com.school.management.service.info;

import com.school.management.domain.Class;
import com.school.management.domain.Grade;

import java.util.List;

public interface IClassService {

    /**
     * 获取班级列表
     */
    List<Class> selectClassList(Class shift);

    /**
     * 条件搜索班级
     */
    List<Class> searchClassList(String teacherId, String gradeId, String subjectId);

    /**
     * 修改班级负责人
     */
    int updateLeader(Class shift);

    /**
     * 新增班级
     */
    int insertClass(String gradeId);

    /**
     * 删除班级
     */
    int deleteClass(String classId);

    /**
     * 查询考试班级
     */
    List<Class> selectExamineClassList(String examId);
}
