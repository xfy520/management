package com.school.management.service.info;

import com.school.management.domain.Grade;

import java.util.List;

public interface IGradeService {

    /**
     * 查询年级信息列表
     *
     * @return
     */
    List<Grade> selectGradeList(String subjectId);

    /**
     * 更新年级科目
     */
    int updateSubject(Grade grade);
}
