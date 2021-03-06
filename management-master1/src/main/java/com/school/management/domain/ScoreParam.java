package com.school.management.domain;

import lombok.Data;

@Data
public class ScoreParam {
    private String examId;
    private String classId;
    private String subjectIds;
    private String isAsc;
    private  String orderByColumn;
    private Integer pageSize;
    private Integer pageNum;
}
