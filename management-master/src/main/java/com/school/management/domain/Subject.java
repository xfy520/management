package com.school.management.domain;

import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class Subject extends BaseEntity {

    /** 学科id */
    private Long subjectId;

    /** 学科名称 */
    private String subjectName;

    /** 选修还是必修*/
    private String elective;

    /** 学科描述 */
    private String remark;

    /** 是否三年级以上才上 */
    private String sign;
}
