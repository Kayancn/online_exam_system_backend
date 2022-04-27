package com.example.online_exam_system_backend.mapper;

import com.example.online_exam_system_backend.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("SELECT * FROM exam_system.teacher")
    List<Teacher> findAll();
}
