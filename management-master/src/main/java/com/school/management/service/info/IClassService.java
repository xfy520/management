package com.school.management.service.info;

import com.school.management.domain.Class;
import com.school.management.domain.Grade;

import java.util.List;

public interface IClassService {

    /**
     * 获取班级列表
     */
    List<Class> selectClassList(Class shift);

    /**
     * 条件搜索班级
     */
    List<Class> searchClassList(Long userId, Long gradeId, Long subjectId);

    /**
     * 修改班级负责人
     */
    int updateLeader(Class shift);

    /**
     * 新增班级
     */
    int insertClass(Long gradeId, Long uuid);

    /**
     * 删除班级
     */
    int deleteClass(Long classId);
}
