package com.example.online_exam_system_backend.service.impl;

import com.example.online_exam_system_backend.entity.StudentPaper;
import com.example.online_exam_system_backend.mapper.StudentPaperMapper;
import com.example.online_exam_system_backend.service.IStudentPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生答卷表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-24
 */
@Service
public class StudentPaperServiceImpl extends ServiceImpl<StudentPaperMapper, StudentPaper> implements IStudentPaperService {

}
