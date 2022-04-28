package com.example.online_exam_system_backend.service;

import com.example.online_exam_system_backend.entity.Student;
import com.example.online_exam_system_backend.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int save(Student student) {
        if(student.getId() == null){    //新增
            return studentMapper.insert(student);
        }else {     //更新
            return studentMapper.update(student);
        }
    }
}
