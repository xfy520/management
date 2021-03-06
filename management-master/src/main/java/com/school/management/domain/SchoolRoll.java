package com.school.management.domain;

import lombok.Data;

@Data
public class SchoolRoll extends Student{

    /** 学籍id */
    private Long rollId;

    /** 学籍号 */
    private Long rollNumber;
}
