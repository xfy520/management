package com.school.management.domain;

import com.school.management.common.annotation.Excel;
import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class Class extends BaseEntity{

    /** 年级id */
    @Excel(name = "年级id")
    private Long gradeId;

    /** 班级id */
    @Excel(name = "班级id")
    private Long classId;

    /** 班级号 */
    @Excel(name = "班级号")
    private int classNum;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 年级名称 */
    @Excel(name = "年级名称")
    private String gradeName;

    /** 学生数 */
    @Excel(name = "学生数")
    private int studentNum;

    /** 班主任名字 */
    @Excel(name = "班主任名字")
    private String leaderName;

    /** 班主任id */
    @Excel(name = "班主任id")
    private Long leader;


}
