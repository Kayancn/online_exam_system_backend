package com.example.online_exam_system_backend.mapper;

import com.example.online_exam_system_backend.entity.PaperQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.online_exam_system_backend.entity.Question;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
public interface PaperQuestionMapper extends BaseMapper<PaperQuestion> {

    List<Question> selectQuestions(Integer paperId);
}
