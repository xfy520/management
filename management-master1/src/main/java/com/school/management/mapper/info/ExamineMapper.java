package com.school.management.mapper.info;

import com.school.management.domain.Examine;

import java.util.List;

public interface ExamineMapper {

    /**
     * 添加考生
     */
    int insertExamines(Examine examine);

    /**
     * 添加单个考生
     */
    int insertExamineById(Examine examine);
}
