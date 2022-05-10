package com.example.online_exam_system_backend.controller.dto;

import lombok.Data;

@Data
public class PaperDTO {
    private Integer type1; //选择题数量
    private Integer type2; //判断题数量
    private Integer type3; //问答题数量
    private Integer paperId; //试卷id
    private Integer courseId; //课程ID
}
