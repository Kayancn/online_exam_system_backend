package com.example.online_exam_system_backend.service.impl;

import com.example.online_exam_system_backend.entity.Exam;
import com.example.online_exam_system_backend.mapper.ExamMapper;
import com.example.online_exam_system_backend.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

}
