package com.school.management.domain;

import lombok.Data;

@Data
public class Teacher extends User{

    /** 教师 id */
    private String teacherId;

    /** 所上科目id */
    private String subjectId;

    /** 所上科目 */
    private String subjectName;

    /** 是否班主任 */
    private String job;

    /** 所上班级名称 */
    private String className;

    /** 所上班级id */
    private String classIds;
}
