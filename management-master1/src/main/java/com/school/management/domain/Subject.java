package com.school.management.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Subject{

    /** 学科id */
    private String subjectId;

    /** 科目编号 */
    private Long subjectNumber;

    /** 学科名称 */
    private String subjectName;

    /** 选修还是必修*/
    private String elective;

    /** 学科描述 */
    private String remark;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
