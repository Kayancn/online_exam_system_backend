package com.example.online_exam_system_backend.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IQuestionService;
import com.example.online_exam_system_backend.entity.Question;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 题目表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private IQuestionService questionService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Question question) {
        return questionService.saveOrUpdate(question);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return questionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return questionService.removeByIds(ids);
    }

    @GetMapping
    public List<Question> findAll() {
        return questionService.list();
    }

    @GetMapping("/{id}")
    public Question findOne(@PathVariable Integer id) {
        return questionService.getById(id);
    }

    @GetMapping("/page")
    public Page<Question> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(required = false) Integer courseId,
                                   @RequestParam(required = false) Integer type) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if(!"".equals(name)){
            queryWrapper.like("name", name);
        }
        if(courseId != null){
            queryWrapper.eq("course_id", courseId);
        }
        if(type != null){
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByDesc("id");
        return questionService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

