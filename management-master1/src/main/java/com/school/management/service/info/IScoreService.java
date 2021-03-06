package com.school.management.service.info;

import com.school.management.domain.*;
import com.school.management.domain.Class;

import java.util.List;

public interface IScoreService {

    /**
     * 查询指定老师关联的考试
     */
    List<Exam> selectMarkExamList(String teacherId);

    /**
     * 查询学生所参加考试
     */
    List<Exam> selectStudentExamList(String studentId);

    /**
     * 验证是不是班主任
     */
    String classTeacher(String teacherId);

    /**
     * 查询指定考试指定老师关联班级
     */
    List<Class> scoreClass(String examId, String teacherId);

    /**
     * 查询考试班级下的考生
     */
    List<Score> selectScoreList(String examId, String classId, String teacherId);

    /**
     * 查询学生成绩
     */
    List<Object> listScore(String examId, String classId, String subjectIds, String subjectIdChar);

    /**
     * 查询学生成绩
     */
    List<Object> studentScore(String examId, String studentId, String subjectIds, String subjectIdChar);

    /**
     * 修改分数
     */
    int updateScore(Score score);

    /**
     * 查询班主任班级所有考试
     */
    List<Exam> selectMyClassExam(String classId);

    /**
     * 查询考试科目
     */
    List<Subject> selectExamSubject(String examId);

    /**
     * 导入学生成绩
     *
     * @return 结果
     */
    String importScore(List<Score> scoreLis, String examId, String classId);

}
