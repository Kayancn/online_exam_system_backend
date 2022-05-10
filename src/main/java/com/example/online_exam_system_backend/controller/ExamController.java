package com.example.online_exam_system_backend.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IExamService;
import com.example.online_exam_system_backend.entity.Exam;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 考试表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-09
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    private IExamService examService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Exam exam) {
        return examService.saveOrUpdate(exam);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return examService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return examService.removeByIds(ids);
    }

    @GetMapping
    public List<Exam> findAll() {
        return examService.list();
    }

    @GetMapping("/{id}")
    public Exam findOne(@PathVariable Integer id) {
        return examService.getById(id);
    }

    @GetMapping("/page")
    public Page<Exam> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name) {
        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
        if(!"".equals(name)){
            queryWrapper.like("name", name);
        }
        queryWrapper.orderByDesc("id");
        return examService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

