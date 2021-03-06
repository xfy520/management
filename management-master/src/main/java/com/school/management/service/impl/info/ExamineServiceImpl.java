package com.school.management.service.impl.info;

import com.school.management.domain.Examine;
import com.school.management.mapper.info.ExamineMapper;
import com.school.management.service.info.IExamineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamineServiceImpl implements IExamineService {

    @Resource
    private ExamineMapper examineMapper;

    @Override
    public List<Examine> selectExamineList(Examine examine) {
        return examineMapper.selectExamineList(examine);
    }

    @Override
    public int insertExamines(Examine examine) {
        return examineMapper.insertExamines(examine);
    }

    @Override
    public int insertExamineById(Examine examine) {
        return examineMapper.insertExamineById(examine);
    }
}
