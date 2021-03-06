package com.school.management.mapper.info;

import com.school.management.domain.*;
import com.school.management.domain.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {

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
    List<Class> scoreClass(@Param("examId") String examId, @Param("teacherId") String teacherId);

    /**
     * 查询考试班级下的考生
     */
    List<Score> selectScoreList(@Param("examId") String examId, @Param("classId") String classId, @Param("teacherId") String teacherId);

    /**
     * 查询学生成绩
     */
    List<Object> listScore(@Param("examId") String examId, @Param("classId") String classId, @Param("sqlStr") String sqlStr);

    /**
     * 查询学生成绩
     */
    List<Object> studentScore(@Param("examId") String examId, @Param("studentId") String classId, @Param("sqlStr") String sqlStr);

    /**
     * 修改分数
     */
    int updateScore(Score score);

    /**
     * 查询班主任班级所有考试
     */
    List<Exam> selectMyClassExam(@Param("classId") String classId);

    /**
     * 查询考试科目
     */
    List<Subject> selectExamSubject(@Param("examId") String examId);

    /**
     * 导入学生信息
     */
    int importUpdateScore(Score score);

}
