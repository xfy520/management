package com.school.management.mapper.info;

import com.school.management.domain.Subject;
import com.school.management.domain.Teacher;

import java.util.List;

/**
 * 学生信息层 数据层
 *
 */
public interface SubjectMapper {

    /**
     * 根据分页查询科目列表
     *
     * @return 科目信息集合信息
     */
    List<Subject> selectSubjectList(Subject subject);

    /**
     * 修改科目
     * @param subject
     * @return
     */
    int updateSubject(Subject subject);

    /**
     * 查询单个科目信息
     *
     * @return 单个科目信息
     */
    Subject selectSubjectById(Subject subject);

    /**
     * 获取科目编号
     */
    Long maxSubjectNumber();


    /** 插入科目信息 */
    int insertSubject(Subject subject);

    /**
     * 批量删除科目信息
     *
     * @param ids 需要科目的数据ID
     * @return 结果
     */

    int deleteSubjectByIds(String[] ids);

    /**
     * 验证学科是否存在
     * @param subjectName
     * @return
     */
    String checkSubjectNameUnique(String subjectName);

    /**
     * 考试筛选科目
     */
    List<Subject> selectExamSubjectList(Teacher teacher);

    /**
     * 查询考试科目
     */
    List<Subject> selectExamineSubjectList(String examId);
}
