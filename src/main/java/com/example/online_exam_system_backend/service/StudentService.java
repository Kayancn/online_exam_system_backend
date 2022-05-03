package com.example.online_exam_system_backend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.online_exam_system_backend.entity.Student;
import com.example.online_exam_system_backend.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceImpl<StudentMapper,Student> {
}
