package com.school.management.domain;

import lombok.Data;

@Data
public class Grade{

    /** 年级id */
    private String gradeId;

    /** 年级名称 */
    private String gradeName;

    /** 所上科目 */
    private String subjectName;

    /** 所上科目id */
    private String subjectIds;

    /** 年级序号 */
    private int gradeNum;

    /** 班级数 */
    private int classNum;

    /** 学生数 */
    private int studentNum;
}
