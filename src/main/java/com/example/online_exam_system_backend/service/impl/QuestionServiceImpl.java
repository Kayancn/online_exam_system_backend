package com.example.online_exam_system_backend.service.impl;

import com.example.online_exam_system_backend.entity.Question;
import com.example.online_exam_system_backend.mapper.QuestionMapper;
import com.example.online_exam_system_backend.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目表 服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
