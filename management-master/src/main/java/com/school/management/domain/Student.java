package com.school.management.domain;

import lombok.Data;

@Data
public class Student extends User{

    /** 学校id */
    private Long schoolId;

    /** 学校名称 */
    private String schoolName;

    /** 年级id */
    private Long gradeId;

    /** 年级名次 */
    private String gradeName;

    /** 班级id */
    private Long classId;

    /** 班级名称 */
    private int classNum;
}
