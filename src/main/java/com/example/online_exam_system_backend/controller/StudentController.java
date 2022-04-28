package com.example.online_exam_system_backend.controller;

import com.example.online_exam_system_backend.entity.Student;
import com.example.online_exam_system_backend.mapper.StudentMapper;
import com.example.online_exam_system_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> index() {
        List<Student> all = studentMapper.findAll();
        return all;
    }
    // 新增和修改
    @PostMapping
    public Integer save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable String id) {
        return studentMapper.deleteById(id);
    }
}
