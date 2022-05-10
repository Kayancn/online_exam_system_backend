package com.example.online_exam_system_backend.service.impl;

import com.example.online_exam_system_backend.entity.PaperQuestion;
import com.example.online_exam_system_backend.entity.Question;
import com.example.online_exam_system_backend.mapper.PaperQuestionMapper;
import com.example.online_exam_system_backend.service.IPaperQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@Service
public class PaperQuestionServiceImpl extends ServiceImpl<PaperQuestionMapper, PaperQuestion> implements IPaperQuestionService {

    @Resource
    private PaperQuestionMapper paperQuestionMapper;
    @Override
    public List<Question> selectQuestions(Integer paperId) {
        return paperQuestionMapper.selectQuestions(paperId);
    }
}
