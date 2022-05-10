package com.example.online_exam_system_backend.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IPaperQuestionService;
import com.example.online_exam_system_backend.entity.PaperQuestion;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@RestController
@RequestMapping("/paper-question")
public class PaperQuestionController {

    @Resource
    private IPaperQuestionService paperQuestionService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody PaperQuestion paperQuestion) {
        return paperQuestionService.saveOrUpdate(paperQuestion);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return paperQuestionService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return paperQuestionService.removeByIds(ids);
    }

    @GetMapping
    public List<PaperQuestion> findAll() {
        return paperQuestionService.list();
    }

    @GetMapping("/{id}")
    public PaperQuestion findOne(@PathVariable Integer id) {
        return paperQuestionService.getById(id);
    }

    @GetMapping("/page")
    public Page<PaperQuestion> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<PaperQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return paperQuestionService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

