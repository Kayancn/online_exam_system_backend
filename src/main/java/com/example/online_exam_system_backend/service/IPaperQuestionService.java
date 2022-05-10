package com.example.online_exam_system_backend.service;

import com.example.online_exam_system_backend.entity.PaperQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.online_exam_system_backend.entity.Question;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
public interface IPaperQuestionService extends IService<PaperQuestion> {

    List<Question> selectQuestions(Integer paperId);
}
