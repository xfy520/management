package com.school.management.domain;

import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class Examine extends BaseEntity {

    /** 考生id */
    private String examineId;

    /** 学生id */
    private String studentId;

    /** 科目id */
    private String subjectId;

    /** 考试id */
    private String examId;

    /** 考试科目 */
    private String subjectName;

    /** 考试编号 */
    private Long examNumber;

    /** 各科分数 */
    private Float score;
}
