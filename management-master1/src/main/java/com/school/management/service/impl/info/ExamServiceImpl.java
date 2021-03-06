package com.school.management.service.impl.info;

import com.school.management.common.core.text.Convert;
import com.school.management.domain.Class;
import com.school.management.domain.Exam;
import com.school.management.domain.Subject;
import com.school.management.domain.Teacher;
import com.school.management.mapper.info.ClassMapper;
import com.school.management.mapper.info.ExamMapper;
import com.school.management.mapper.info.SubjectMapper;
import com.school.management.service.info.IExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements IExamService {

    @Resource
    private ExamMapper examMapper;

    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private ClassMapper classMapper;

    /**
     * 获取考试列表
     */
    @Override
    public List<Exam> selectExamList(Exam exam){
        return examMapper.selectExamList(exam);
    }

    /**
     * 考试筛选科目
     */
    public List<Subject> selectExamSubjectList(Teacher teacher){
        return subjectMapper.selectExamSubjectList(teacher);
    }

    /**
     * 考试筛选班级
     */
    public List<Class> selectExamClassList(Teacher teacher){
        return classMapper.selectExamClassList(teacher);
    }

    /**
     * 添加考试
     */
    public int insertExam(Exam exam){
        return examMapper.insertExam(exam);
    }

    /**
     * 删除考试
     */
    public int deleteExamByIds(String ids){
        String[] examIds = Convert.toStrArray(ids);
        return examMapper.deleteExamByIds(examIds);
    }

    /**
     * 开启考试
     */
    public int isExam(String examId){
        return examMapper.isExam(examId);
    }

    /**
     * 查询单场考试
     */
    public Exam selectExamById(String examId){
        return examMapper.selectExamById(examId);
    }

    /**
     * 修改考试
     */
    public int updateExam(Exam exam){
        return examMapper.updateExam(exam);
    }
}
