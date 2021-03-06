package com.school.management.mapper.info;

import com.school.management.domain.Exam;
import com.school.management.domain.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {

    /**
     * 获取考试列表
     */
    List<Exam> selectExamList(Exam exam);

    /**
     * 添加考试
     */
    int insertExam(Exam exam);

    /**
     * 删除考试
     */
    int deleteExamByIds(Long[] examIds);

    /**
     * 开启考试
     */
    int isExam(@Param("examId") Long examId);

    /**
     * 查询单场考试
     */
    Exam selectExamById(@Param("examId") Long examId);

    /**
     * 修改考试
     */
    int updateExam(Exam exam);
}
