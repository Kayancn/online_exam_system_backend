package com.example.online_exam_system_backend.controller.dto;

import lombok.Data;

//接受前端登陆请求的参数
@Data
public class LoggerDTO {
    private String id;
    private String password;
    private String name;
}
