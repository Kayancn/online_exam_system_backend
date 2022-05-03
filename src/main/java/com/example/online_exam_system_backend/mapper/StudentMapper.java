package com.example.online_exam_system_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.online_exam_system_backend.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
//    @Select("SELECT * FROM exam_system.student")
//    List<Student> findAll();
//    @Insert("INSERT INTO `exam_system`.`student` (`id`, `password`, `name`, `email`, `phone`) VALUES (#{id}, " +
//            "#{password}, #{name}, #{email}, #{phone})")
//    int insert(Student student);
//
//    int update(Student student);
//    @Delete("DELETE FROM `exam_system`.`student` WHERE (`id` = #{id})")
//    Integer deleteById(@Param("id") String id);
}
