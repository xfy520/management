package com.school.management.service.impl.info;

import com.school.management.domain.Grade;
import com.school.management.mapper.info.GradeMapper;
import com.school.management.service.info.IGradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService {

    @Resource
    private GradeMapper gradeMapper;

    /**
     * 查询年级信息列表
     *
     * @return
     */
    @Override
    public List<Grade> selectGradeList()
    {
        return gradeMapper.selectGradeList();
    }

    /**
     * 修改年级负责人
     */
    public int updateLeader(Grade grade){
        return gradeMapper.updateGradeLeader(grade);
    }

}
