package com.school.management.service.impl.info;

import com.school.management.common.utils.IDUtils;
import com.school.management.domain.Class;
import com.school.management.mapper.info.ClassMapper;
import com.school.management.service.info.IClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

    @Resource
    private ClassMapper classMapper;

    /**
     * 获取班级列表
     */
    @Override
    public List<Class> selectClassList(Class shift){
        return classMapper.selectClassList(shift);
    }

    /**
     * 条件搜索班级
     */
    public List<Class> searchClassList(String teacherId, String gradeId, String subjectId){
        return classMapper.searchClassList(teacherId, gradeId, subjectId);
    }

    /**
     * 修改班级负责人
     */
    public int updateLeader(Class shift){
        return classMapper.updateClassLeader(shift);
    }

    /**
     * 新增班级
     */
    public int insertClass(String gradeId){
        Class shift = new Class();
        shift.setClassId(IDUtils.getId());
        shift.setGradeId(gradeId);
        Integer class_num = classMapper.selectMaxClassNum(gradeId);
        class_num = class_num == null ? 1 : class_num + 1;
        shift.setClassNum(class_num);
        return classMapper.insertClass(shift);
    }

    /**
     * 删除班级
     */
    public int deleteClass(String classId){
        return classMapper.deleteClass(classId);
    }

    /**
     * 查询考试班级
     */
    public List<Class> selectExamineClassList(String examId){
        return classMapper.selectExamineClassList(examId);
    }
}
