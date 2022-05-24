package com.example.online_exam_system_backend.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.online_exam_system_backend.common.Constants;
import com.example.online_exam_system_backend.common.Result;
import com.example.online_exam_system_backend.exception.ServiceException;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.online_exam_system_backend.service.IStudentPaperService;
import com.example.online_exam_system_backend.entity.StudentPaper;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学生答卷表 前端控制器
 * </p>
 *
 * @author Kayan
 * @since 2022-05-24
 */
@RestController
@RequestMapping("/student-paper")
public class StudentPaperController {

    @Resource
    private IStudentPaperService studentPaperService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody StudentPaper studentPaper) {
        if(studentPaper.getId() == null) {
            //判定是否已提交试卷
            List<StudentPaper> list = studentPaperService.list(new QueryWrapper<StudentPaper>().eq("exam_id",studentPaper.getExamId())
                    .eq("student_id",studentPaper.getStudentId()));
            if(CollUtil.isNotEmpty(list)) {
                throw new ServiceException(Constants.CODE_600,"您已提交考卷，请勿重复提交！");
            }
            studentPaper.setTime(DateUtil.now());
        }
        //提交试卷
        studentPaperService.saveOrUpdate(studentPaper);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return studentPaperService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return studentPaperService.removeByIds(ids);
    }

    @GetMapping
    public List<StudentPaper> findAll() {
        return studentPaperService.list();
    }

    @GetMapping("/{id}")
    public StudentPaper findOne(@PathVariable Integer id) {
        return studentPaperService.getById(id);
    }

    @GetMapping("/score")
    public List<StudentPaper> score(@RequestParam String studentId) {
        QueryWrapper<StudentPaper> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId);
        return studentPaperService.list(queryWrapper);
    }

    @GetMapping("/page")
    public Page<StudentPaper> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam(required = false) Integer examId) {
        QueryWrapper<StudentPaper> queryWrapper = new QueryWrapper<>();
        if(examId != null){
            queryWrapper.eq("exam_id", examId);
        }
        queryWrapper.orderByDesc("id");
        return studentPaperService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }

}

