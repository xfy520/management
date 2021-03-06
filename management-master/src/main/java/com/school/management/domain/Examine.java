package com.school.management.domain;

import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class Examine extends BaseEntity {

    /** 成绩考生 */
    private Long examineId;

    /** 考生id */
    private Long studentId;

    /** 考生id */
    private Long examId;

    /** 考试科目 */
    private String subjectName;

    /** 考试编号 */
    private Long examNumber;

    /** 各科分数 */
    private String score;
}
