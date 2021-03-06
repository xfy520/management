package com.school.management.service.info;

import com.school.management.domain.Grade;

import java.util.List;

public interface IGradeService {

    /**
     * 查询年级信息列表
     *
     * @return
     */
    List<Grade> selectGradeList();

    /**
     * 修改年级负责人
     */
    int updateLeader(Grade grade);
}
