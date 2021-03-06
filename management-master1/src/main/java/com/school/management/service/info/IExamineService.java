package com.school.management.service.info;

import com.school.management.domain.Examine;
import com.school.management.domain.Student;

import java.util.List;

public interface IExamineService {

    /**
     * 获取考生列表
     */
    List<Student> selectExamineList(String examId, String classId, String subjectId, Long userId);

    /**
     * 添加考生
     */
    int insertExamines(Examine examine, String subjectIds);

    /**
     * 添加单个考生
     */
    int insertExamineById(Examine examine);

    /**
     * 查询学生信息
     * @param userId
     * @return
     */
    List<Student> searchStudentList(Long userId, String classId, String examId, String subjectId);
}
