package com.example.online_exam_system_backend.controller;

import com.example.online_exam_system_backend.entity.Teacher;
import com.example.online_exam_system_backend.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/")
    public List<Teacher> index() {
        List<Teacher> all = teacherMapper.findAll();
        return all;
    }
}
