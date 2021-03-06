package com.school.management.domain;

import lombok.Data;

@Data
public class Class{

    /** 年级id */
    private String gradeId;

    /** 班级id */
    private String classId;

    /** 班级号 */
    private int classNum;

    /** 班级名称 */
    private String className;

    /** 年级名称 */
    private String gradeName;

    /** 学生数 */
    private int studentNum;

    /** 班主任名字 */
    private String teacherName;

    /** 班主任id */
    private String teacherId;


}
