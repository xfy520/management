package com.school.management.service.impl.info;

import com.school.management.common.core.text.Convert;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.Examine;
import com.school.management.domain.Student;
import com.school.management.mapper.info.ExamineMapper;
import com.school.management.mapper.info.StudentMapper;
import com.school.management.service.info.IExamineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamineServiceImpl implements IExamineService {

    @Resource
    private ExamineMapper examineMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectExamineList(String examId, String classId, String subjectId, Long userId) {
        return studentMapper.selectExamineList(examId, classId, subjectId, userId);
    }

    @Override
    public int insertExamines(Examine examine, String subjectIds) {
        String[] subjectIdLongs = Convert.toStrArray(subjectIds);
        for (int i = 0; i < subjectIdLongs.length; i++){
            Examine examine1 = new Examine();
            examine1.setExamId(examine.getExamId());
            examine1.setExamNumber(examine.getExamNumber());
            examine1.setSubjectId(subjectIdLongs[i]);
            examineMapper.insertExamines(examine1);
        }
        return 1;
    }

    @Override
    public int insertExamineById(Examine examine) {
        examine.setExamineId(IDUtils.getId());
        return examineMapper.insertExamineById(examine);
    }

    /**
     * 查询学生信息
     * @param userId
     * @return
     */
    @Override
    public List<Student> searchStudentList(Long userId, String classId, String examId, String subjectId){
        return studentMapper.searchStudentList(userId, classId, examId, subjectId);
    }
}
