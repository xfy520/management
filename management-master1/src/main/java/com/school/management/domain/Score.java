package com.school.management.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.management.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Score {

    /** 成绩id */
    private String Id;

    /** 学生id */
    private String studentId;

    /** 科目id */
    private String subjectId;

    /** 学号 */
    @Excel(name = "学号")
    private Long userId;

    /** 学生姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 考试科目 */
    @Excel(name = "科目编号")
    private String subjectNumber;

    /** 考试科目 */
    @Excel(name = "科目")
    private String subjectName;

    /** 分数 */
    @Excel(name = "分数", defaultValue="0.0")
    private float score;

    private String examId;

    private String classId;

    /** 考试开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startDate;

    /** 考试结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endDate;
}
