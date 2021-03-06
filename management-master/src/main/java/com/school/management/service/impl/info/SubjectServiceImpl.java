package com.school.management.service.impl.info;

import com.school.management.common.core.text.Convert;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.Subject;
import com.school.management.mapper.info.SubjectMapper;
import com.school.management.service.info.ISubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    /**
     * 根据条件分页查询科目列表
     *
     * @return 科目信息集合信息
     */
    @Override
    public List<Subject> selectSubjectList(Subject subject)
    {
        return subjectMapper.selectSubjectList(subject);
    }

    /**
     * 查询科目
     *
     * @return 科目信息
     */
    @Override
    public Subject selectSubjectById(Subject subject)
    {
        return subjectMapper.selectSubjectById(subject);
    }

    /**
     * 新增学科
     * @param subject
     * @return
     */
    @Override
    public int insertSubject(Subject subject)
    {
        subject.setSubjectId(IDUtils.getId());
        return subjectMapper.insertSubject(subject);
    }

    /**
     * 新增学科
     * @param ids
     * @return
     */
    @Override
    public int deleteSubjectByIds(String ids)
    {
        Long[] subjectIds = Convert.toLongArray(ids);
        return subjectMapper.deleteSubjectByIds(subjectIds);
    }

    /**
     * 修改学科
     * @param subject
     * @return
     */
    @Override
    public int updateSubject(Subject subject)
    {
        return subjectMapper.updateSubject(subject);
    }


    /**
     * 修改必修选修状态
     * @param subject
     * @return
     */
    @Override
    public int changeElective(Subject subject)
    {
        return subjectMapper.updateSubject(subject);
    }

    /**
     * 验证学科是否存在
     * @param subjectName
     * @return
     */
    public String checkSubjectNameUnique(String subjectName){
        return subjectMapper.checkSubjectNameUnique(subjectName);
    }
}
