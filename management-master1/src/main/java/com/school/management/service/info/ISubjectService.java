package com.school.management.service.info;

import com.school.management.domain.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface ISubjectService {

    /**
     * 根据条件分页查询科目列表
     *
     * @return 科目信息集合信息
     */
    List<Subject> selectSubjectList(Subject subject);

    /**
     * 查询科目
     *
     * @return 科目信息
     */
    Subject selectSubjectById(Subject subject);

    /**
     * 新增学科
     * @param subject
     * @return
     */
    int insertSubject(Subject subject);

   /**
     * 删除学科
     * @param ids
     * @return
     */
    int deleteSubjectByIds(String ids);

 /**
     * 修改学科
     * @param subject
     * @return
     */
    int updateSubject(Subject subject);

    /**
     * 修改必修选修状态
     * @param subject
     * @return
     */
    int changeElective(Subject subject);

    /**
     * 验证学科是否存在
     * @param subjectName
     * @return
     */
    String checkSubjectNameUnique(String subjectName);

    /**
     * 查询考试科目
     */
    List<Subject> selectExamineSubjectList(String examId);

}
