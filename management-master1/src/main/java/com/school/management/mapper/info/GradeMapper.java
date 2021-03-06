package com.school.management.mapper.info;

import com.school.management.domain.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {

    /**
     * 查询年级信息列表
     *
     * @return
     */
    List<Grade> selectGradeList(@Param("subjectId") String subjectId);

    /**
     * 更新年级科目
     */
    int updateSubject(Grade grade);
}
