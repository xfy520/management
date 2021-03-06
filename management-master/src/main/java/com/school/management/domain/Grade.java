package com.school.management.domain;

import com.school.management.common.annotation.Excel;
import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class Grade extends BaseEntity {

    /** 年级id */
    @Excel(name = "年级id")
    private Long gradeId;

    /** 年级名称 */
    @Excel(name = "年级名称")
    private String gradeName;

    /** 年级负责人ID */
    @Excel(name = "年级负责人ID")
    private long leader;

    /** 年级负责人名字 */
    @Excel(name = "年级负责人名字")
    private String leaderName;

    /** 年级序号 */
    @Excel(name = "年级序号")
    private int gradeNum;

    /** 班级数 */
    @Excel(name = "班级数")
    private int classNum;
}
