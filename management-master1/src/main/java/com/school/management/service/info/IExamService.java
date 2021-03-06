package com.school.management.service.info;

import com.school.management.domain.Class;
import com.school.management.domain.Exam;
import com.school.management.domain.Subject;
import com.school.management.domain.Teacher;

import java.util.List;

public interface IExamService {

    /**
     * 获取考试列表
     */
    List<Exam> selectExamList(Exam exam);

    /**
     * 考试筛选科目
     */
    List<Subject> selectExamSubjectList(Teacher teacher);

    /**
     * 考试筛选班级
     */
    List<Class> selectExamClassList(Teacher teacher);

    /**
     * 添加考试
     */
    int insertExam(Exam exam);

    /**
     * 删除考试
     */
    int deleteExamByIds(String ids);

    /**
     * 开启考试
     */
    int isExam(String examId);

    /**
     * 查询单场考试
     */
    Exam selectExamById(String examId);

    /**
     * 修改考试
     */
    int updateExam(Exam exam);
}
