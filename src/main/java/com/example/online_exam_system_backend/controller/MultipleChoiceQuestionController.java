package com.example.online_exam_system_backend.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IMultipleChoiceQuestionService;
import com.example.online_exam_system_backend.entity.MultipleChoiceQuestion;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 选择题表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-03
 */
@Controller
@RequestMapping("/multipleChoiceQuestion")
public class MultipleChoiceQuestionController {

    @Resource
    private IMultipleChoiceQuestionService multipleChoiceQuestionService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody MultipleChoiceQuestion multipleChoiceQuestion) {
        return multipleChoiceQuestionService.saveOrUpdate(multipleChoiceQuestion);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return multipleChoiceQuestionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return multipleChoiceQuestionService.removeByIds(ids);
    }

    @GetMapping
    public List<MultipleChoiceQuestion> findAll() {
        return multipleChoiceQuestionService.list();
    }

    @GetMapping("/{id}")
    public MultipleChoiceQuestion findOne(@PathVariable Integer id) {
        return multipleChoiceQuestionService.getById(id);
    }

    @GetMapping("/page")
    public Page<MultipleChoiceQuestion> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<MultipleChoiceQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return multipleChoiceQuestionService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

