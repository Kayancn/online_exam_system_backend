package com.example.online_exam_system_backend.service.impl;

import com.example.online_exam_system_backend.entity.Student;
import com.example.online_exam_system_backend.mapper.StudentMapper;
import com.example.online_exam_system_backend.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
