package com.example.online_exam_system_backend.controller.dto;

import lombok.Data;

@Data
public class ExamDTO {
    private Integer id;
    private String password;
    private Integer paperId;
    private String name;
    private String time;
    private Integer duration;
}
