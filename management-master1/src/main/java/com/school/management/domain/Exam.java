package com.school.management.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Exam {

    /** 考试id */
    private String examId;

    /** 创建者 */
    private String createBy;

    /** 发起者名字 */
    private String userName;

    /** 考试编号 */
    private Long examNumber;

    /** 考试名称 */
    private String examName;

    /** 考生数 */
    private int examNum;

    /** 考试类型 */
    private String examType;

    /** 科目id */
    private String subjectIds;

    /** 考试科目 */
    private String subjectName;

    /** 班级id */
    private String classIds;

    /** 参考班级 */
    private String className;

    /** 标志是否添加考生 */
    private String isExam;

    /** 考试开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startDate;

    /** 考试结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date endDate;


}
