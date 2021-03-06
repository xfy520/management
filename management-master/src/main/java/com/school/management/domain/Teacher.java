package com.school.management.domain;

import com.school.management.common.annotation.Excel;
import lombok.Data;

@Data
public class Teacher extends User{

    /** 学科id */
    @Excel(name = "学科ID")
    private Long subjectId;

    /** 学科名称 */
    @Excel(name = "学科名称")
    private String subjectName;

    /** 职称，是否是科目组长 */
    @Excel(name = "职务", readConverterExp = "0=组长,1=副组长,2=科任教师")
    private String job;

    /** 所上班级名称 */
    private String className;

    /** 所上班级id */
    private String classIds;
}
