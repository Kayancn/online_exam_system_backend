package com.example.online_exam_system_backend.controller;


import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.online_exam_system_backend.common.Result;
import com.example.online_exam_system_backend.controller.dto.PaperDTO;
import com.example.online_exam_system_backend.entity.PaperQuestion;
import com.example.online_exam_system_backend.entity.Question;
import com.example.online_exam_system_backend.exception.ServiceException;
import com.example.online_exam_system_backend.service.IPaperQuestionService;
import com.example.online_exam_system_backend.service.IQuestionService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IPaperService;
import com.example.online_exam_system_backend.entity.Paper;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 试卷表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-10
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Resource
    private IPaperService paperService;

    @Resource
    private IQuestionService questionService;

    @Resource
    private IPaperQuestionService paperQuestionService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Paper paper) {
        return paperService.saveOrUpdate(paper);
    }

    //自动组卷
    @PostMapping("/takePaper")
    public Result takePaper(@RequestBody PaperDTO paperDTO) {
        //删除老试卷
        UpdateWrapper<PaperQuestion> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("paper_id", paperDTO.getPaperId());
        paperQuestionService.remove(updateWrapper);

        //生成新试卷
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", paperDTO.getCourseId());
        //根据课程id查出所有该课程的题目，然后根据type去区分
        List<Question> questionList = questionService.list(queryWrapper);
        List<Question> type1List = questionList.stream().filter(question -> question.getType().equals(1)).collect(Collectors.toList()); //选择
        List<Question> type2List = questionList.stream().filter(question -> question.getType().equals(2)).collect(Collectors.toList()); //判断
        List<Question> type3List = questionList.stream().filter(question -> question.getType().equals(3)).collect(Collectors.toList()); //填空
        if(type1List.size() < paperDTO.getType1()){
            throw new ServiceException("-1","选择题数量不足");
        }
        if(type2List.size() < paperDTO.getType2()){
            throw new ServiceException("-1","判断题数量不足");
        }
        if(type3List.size() < paperDTO.getType3()){
            throw new ServiceException("-1","问答题题数量不足");
        }
        //开始随机组卷
        //获取已选题目list
        List<Question> SelectedList = RandomUtil.randomEleList(type1List,paperDTO.getType1());
        SelectedList.addAll(RandomUtil.randomEleList(type2List,paperDTO.getType2()));
        SelectedList.addAll(RandomUtil.randomEleList(type3List,paperDTO.getType3()));
        //向paper_question表批量插入数据
        List<PaperQuestion> list = new ArrayList<>();
        for(Question q : SelectedList){
            PaperQuestion pq = new PaperQuestion();
            pq.setPaperId(paperDTO.getPaperId());
            pq.setQuestionId(q.getId());
            list.add(pq);
        }
        paperQuestionService.saveBatch(list);

        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return paperService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return paperService.removeByIds(ids);
    }

    @GetMapping("/view/{paperId}")
    public Result view(@PathVariable Integer paperId) {
        List<Question> list = paperQuestionService.selectQuestions(paperId);
        return Result.success(list);
    }

    @GetMapping
    public List<Paper> findAll() {
        return paperService.list();
    }

    @GetMapping("/{id}")
    public Paper findOne(@PathVariable Integer id) {
        return paperService.getById(id);
    }

    @GetMapping("/page")
    public Page<Paper> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String name) {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        if(!"".equals(name)){
            queryWrapper.like("name", name);
        }
        queryWrapper.orderByDesc("id");
        return paperService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

